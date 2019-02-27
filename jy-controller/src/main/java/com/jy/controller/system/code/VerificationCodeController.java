package com.jy.controller.system.code;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.jy.common.redis.JedisClient;
import com.jy.controller.base.BaseController;
import com.jy.entiy.constant.Constant;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;



/**
 * @ClassName:  VerificationCodeController   
 * @Description:验证码Controller
 * @author: cheng fei
 * @date:   2018-07-30 15:43
 */
@Controller
@Api(tags = "system.code.VerificationCodeController", description = "系统-验证码-验证码模块")
@RequestMapping("/system")
public class VerificationCodeController extends BaseController{
	
	
	@Resource
	private JedisClient jedisClient;
	
	@Value("${VERIFICATIONCODE_EXPIRE}")
	private Integer VERIFICATIONCODE_EXPIRE;
	
	@Value("${REDIS_PASSWORD}")
	private String REDIS_PASSWORD;
	
	@ApiOperation(value = "加载验证码接口",httpMethod = "GET", produces = "image/png")
	@RequestMapping(value="/code",method = RequestMethod.GET)
	public void generate(
			@ApiParam(value = "验证码宽度", required = false) @RequestParam(required = false, defaultValue = "70") Integer width,
			@ApiParam(value = "验证码高度", required = false) @RequestParam(required = false, defaultValue = "25") Integer height,
			HttpServletRequest request,
			HttpServletResponse response){
		ByteArrayOutputStream output = new ByteArrayOutputStream();
		String code = drawImg(width,height, output);
		String ip = this.getIP();
		jedisClient.set(Constant.VERIFICATION_CODE + ip, code,REDIS_PASSWORD);
		jedisClient.expire(Constant.VERIFICATION_CODE + ip, VERIFICATIONCODE_EXPIRE, REDIS_PASSWORD);
		try {
			ServletOutputStream out = response.getOutputStream();
			output.writeTo(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private String drawImg(Integer width, Integer height, ByteArrayOutputStream output){
		String code = "";
		for(int i=0; i<4; i++){
			code += randomChar();
		}
		
		//没有设置验证码宽高，采用默认设置
		//width = width == null ? 70 : width;
		//height = height == null ? 25 : height;

		BufferedImage bi = new BufferedImage(width,height,BufferedImage.TYPE_3BYTE_BGR);
		Font font = new Font("Times New Roman",Font.PLAIN, (height - 5));
		Graphics2D g = bi.createGraphics();
		g.setFont(font);
		Color color = new Color(66,2,82);
		g.setColor(color);
		g.setBackground(new Color(226,226,240));
		g.clearRect(0, 0, width, height);
		FontRenderContext context = g.getFontRenderContext();
		Rectangle2D bounds = font.getStringBounds(code, context);
		double x = (width - bounds.getWidth()) / 2;
		double y = (height - bounds.getHeight()) / 2;
		double ascent = bounds.getY();
		double baseY = y - ascent;
		g.drawString(code, (int)x, (int)baseY);
		g.dispose();
		try {
			ImageIO.write(bi, "jpg", output);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return code;
	}
	
	private char randomChar(){
		Random r = new Random();
		String s = "ABCDEFGHJKLMNPRSTUVWXYZ0123456789";
		return s.charAt(r.nextInt(s.length()));
	}

}
