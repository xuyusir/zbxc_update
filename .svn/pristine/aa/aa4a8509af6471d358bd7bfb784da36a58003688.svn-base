package com.jy.service.function.marketingFunction.votingManagement;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

public class Qr_code {

	/**
	 * 绘制二维码
	 * @param content(二维码内容)
	 * @param imgPath(二维码保存地址)
	 */
	public  void getQrCodeImg(String content, String imgPath) {
		// 图片宽
		int width = 140;
		// 图片高
		int height = 140;

		// 实例化一个qrcode对象
		Qrcode qrcode = new Qrcode();
		// 设置纠错级别（级别有：L(7%) M(15%) Q(25%) H(30%) ）
		qrcode.setQrcodeErrorCorrect('M');
		// 设置编码方式
		qrcode.setQrcodeEncodeMode('B');
		// 设置二维码版本(版本有 1-40个，)
		qrcode.setQrcodeVersion(7);
		// 开始绘制图片start
		// 1.设置图片大小(BufferedImage.TYPE_INT_RGB:利用三原色绘制二维码)
		BufferedImage img = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
		// 获取绘图工具start
		// 创建画笔
		Graphics2D gs = img.createGraphics();
		// 设置背景为白色
		gs.setBackground(Color.WHITE);
		// 设置一个矩形(四个参数分别为：开始绘图的x坐标，y坐标，图片宽，图片高)
		gs.clearRect(0, 0, width, height);
		// 设置二维码图片的颜色
		gs.setColor(Color.red);
		// 把内容转换字节数组
		byte[] bt = null;

		try {
			bt = content.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 偏移量
		int py = 2;
		// 开始准备画图
		boolean[][] code = qrcode.calQrcode(bt);
		for (int i = 0; i < code.length; i++) {
			for (int j = 0; j < code.length; j++) {
				if (code[j][i]) {
					// 四个参数（画图的起始x和y位置，每个小模块的宽和高（二维码是有一个一个的小模块构成的））；
					gs.fillRect(j * 3 + py, i * 3 + py, 3, 3);
				}
			}
		}
		// 画图
		try {
			ImageIO.write(img, "png", new File(imgPath));
			System.out.println("OK！");
		} catch (IOException e) {
			System.out.println("二维码异常。。。。。");
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		Qr_code qr_code = new Qr_code();
		qr_code.getQrCodeImg("java绘制二维码", "D:\\test2.png");
	}

}
