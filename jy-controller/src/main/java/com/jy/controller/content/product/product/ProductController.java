package com.jy.controller.content.product.product;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.controller.base.BaseController;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.constant.Constant;
import com.jy.entiy.content.product.product.Productbindcousre;
import com.jy.entiy.content.product.product.Productinfo;
import com.jy.service.content.product.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

/**
 * 产品管理模块
 * @author liuhong
 * @date: 2018年8月24日 下午5:46:23 
 * @Package: com.jy.controller.product
 */
@Controller
@RequestMapping("/product")
@Api(tags = "content.product.product.ProductController", description = "内容-产品-产品管理模块")
public class ProductController extends BaseController {
	
	@Resource
	ProductService productService;
	
	/*************************产品信息增删改查
	 * @throws MyException ***********************************/
	@RequestMapping(value = "/addProduct", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "添加产品信息", httpMethod = "POST", produces = "application/json")
	public Result addProduct(
			@ApiParam(value = "产品ID", required = false) Long ProductID,
			@ApiParam(value = "产品名字", required = true) String ProductName,
			@ApiParam(value = "产品价格", required = true) BigDecimal ProductPrice,
			@ApiParam(value = "描述", required = true) String Description,
			@ApiParam(value = "审核结果", required = true) String isauditpassed,
			@ApiParam(value = "产品副标题", required = false) String Subheading,
			@ApiParam(value = "产品介绍", required = false) String Introduce,
			@ApiParam(value = "产品缩略图ID", required = false) Long FileID,
			@ApiParam(value = "课程ID,格式:id1,id2,id3....", required = false) String courseIDs,
			HttpServletRequest request) throws MyException {
		Productinfo productinfo = new Productinfo();
		productinfo.setProductname(ProductName);
		productinfo.setProductprice(ProductPrice);
		productinfo.setDescription(Description);
		productinfo.setIsauditpassed(isauditpassed);
		productinfo.setFileid(FileID);
		productinfo.setSubheading(Subheading);
		productinfo.setIntroduce(Introduce);
		productinfo.setProductid(ProductID);
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return productService.addProduct(accountInfo,productinfo,courseIDs);
	}
	
	@RequestMapping(value = "/updateProduct", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改产品信息", httpMethod = "PUT", produces = "application/json")
	public Result updateProduct(
			@ApiParam(value = "产品ID", required = false) Long ProductID,
			@ApiParam(value = "产品名字", required = false) String ProductName,
			@ApiParam(value = "产品副标题", required = false) String Subheading,
			@ApiParam(value = "产品介绍", required = false) String Introduce,
			@ApiParam(value = "产品缩略图ID", required = false) Long FileID,
			@ApiParam(value = "产品价格", required = false) BigDecimal ProductPrice,
			@ApiParam(value = "简介", required = false) String Description,
			@ApiParam(value = "审核结果", required = false) String isauditpassed,
			@ApiParam(value = "课程ID,格式:id1,id2,id3....", required = false) String courseIDs,
			HttpServletRequest request) throws MyException {
		if (isauditpassed != null && isauditpassed.equals("审核")) {
			isauditpassed = "Y";
		}else if(isauditpassed != null && isauditpassed.equals("不审核")) {
			isauditpassed = "N";
		}
		Productinfo productinfo = new Productinfo();
		productinfo.setProductid(ProductID);
		productinfo.setProductname(ProductName);
		productinfo.setProductprice(ProductPrice);
		productinfo.setDescription(Description);
		productinfo.setIsauditpassed(isauditpassed);
		productinfo.setFileid(FileID);
		productinfo.setSubheading(Subheading);
		productinfo.setIntroduce(Introduce);
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return productService.updateProduct(accountInfo,productinfo,courseIDs);
	}
	
	@RequestMapping(value = "/checkProduct", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "审核产品信息", httpMethod = "PUT", produces = "application/json")
	public Result checkProduct(
			@ApiParam(value = "产品ID", required = true) Long ProductID,
			@ApiParam(value = "审核结果", required = true) String isauditpassed,
			HttpServletRequest request) throws MyException {
		Productinfo productinfo = new Productinfo();
		productinfo.setProductid(ProductID);
		productinfo.setIsauditpassed(isauditpassed);
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return productService.checkProduct(accountInfo,productinfo);
	}
	
	@RequestMapping(value = "/getProduct", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "查询产品信息", httpMethod = "POST", produces = "application/json")
	public Result getProduct(
			@ApiParam(value = "产品ID", required = false) Long ProductID,
			@ApiParam(value = "分页参数页数", required = false) Integer page,
			@ApiParam(value = "分页参数每页条数", required = false) Integer pageSize,
			@ApiParam(value = "产品名字（可模糊查询）", required = false) String ProductName,
			@ApiParam(value = "是否审核（Y/N）", required = true) String check,
			@ApiParam(value = "是否删除（Y/N）", required = true) String isDelete
			) {
		Map<String, Object> param = new HashMap<>();
		param.put("ProductID", ProductID);
		param.put("page", page);
		param.put("pageSize", pageSize);
		if (ProductName != null ) {
			param.put("ProductName", "%"+ProductName+"%");
		}
		param.put("check", check);
		param.put("isDelete", isDelete);
		return productService.getProduct(param);
	}
	
	@RequestMapping(value = "/deleteProduct", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "删除产品信息", httpMethod = "DELETE", produces = "application/json")
	public Result deleteProduct(
			@ApiParam(value = "产品ID", required = true) String ProductID,
			@ApiParam(value = "删除类型1.删除到回收站2.彻底删除", required = true) Integer type,
			HttpServletRequest request
			) throws MyException {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return productService.deleteProduct(accountInfo,ProductID,type);
	}
	
	@RequestMapping(value = "/returns", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "回收站产品还原", httpMethod = "PUT", produces = "application/json")
	public Result returns(
			@ApiParam(value = "产品ID", required = true) String ProductID,
			HttpServletRequest request
			) throws MyException {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return productService.returns(accountInfo,ProductID);
	}
	
/************************************产品课程绑定
 * @throws MyException ************************************************/
	
	@RequestMapping(value = "/addProductBindCousre", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "产品绑定课程信息", httpMethod = "POST", produces = "application/json")
	public Result addProductBindCousre(
			@ApiParam(value = "产品ID", required = true) Long ProductID,
			@ApiParam(value = "课程ID", required = true) Long CourseID,
			HttpServletRequest request
			) throws MyException {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		Productbindcousre productbindcousre = new Productbindcousre();
		productbindcousre.setProductid(ProductID);
		productbindcousre.setCourseid(CourseID);
		return productService.addProductBindCousre(accountInfo,productbindcousre,0);
	}
	
	/*@RequestMapping(value = "/updateProductBindCousre", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改绑定课程信息", httpMethod = "PUT", produces = "application/json")
	public Result updateProductBindCousre(
			@ApiParam(value="ID",required= true)Long ProuctBindCourseID,  
			@ApiParam(value = "产品ID", required = false) Long ProductID,
			@ApiParam(value = "课程ID", required = false) Long CourseID,
			@ApiParam(value = "有效天数", required = false) Integer ValidDays,
			@ApiParam(value = "讲义存放地址", required = false) String LectureAttachmentPath,
			@ApiParam(value = "讲义名字", required = false) String LectureAttachmentName,
			@ApiParam(value = "讲义类型", required = false) String LectureAttachmentType,
			HttpServletRequest request
			) {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		Productbindcousre productbindcousre = new Productbindcousre();
		productbindcousre.setProductid(ProductID);
		productbindcousre.setCourseid(CourseID);
		productbindcousre.setValiddays(ValidDays);
		productbindcousre.setLectureattachmentname(LectureAttachmentName);
		productbindcousre.setLectureattachmentpath(LectureAttachmentPath);
		productbindcousre.setLectureattachmenttype(LectureAttachmentType);
		productbindcousre.setProuctbindcourseid(ProuctBindCourseID);
		return productService.updateProductBindCousre(accountInfo,productbindcousre,CONTROLLER_CODE);
	}*/
	
	@RequestMapping(value = "/deleteProductBindCousre", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "删除绑定课程信息", httpMethod = "DELETE", produces = "application/json")
	public Result deleteProductBindCousre(
			@ApiParam(value="ID",required= true)Long ProuctBindCourseID, 
			HttpServletRequest request
			) throws MyException {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);

		return productService.deleteProductBindCousre(accountInfo,ProuctBindCourseID);
	}
	
	@RequestMapping(value = "/getProductBindCousre", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "查询绑定课程信息", httpMethod = "POST", produces = "application/json")
	public Result getProductBindCousre(
			@ApiParam(value="ID",required= false)Long ProuctBindCourseID,  
			@ApiParam(value = "产品ID", required = false) Long ProductID,
			@ApiParam(value = "课程ID", required = false) Long CourseID
			) {
		Productbindcousre productbindcousre = new Productbindcousre();
		productbindcousre.setProductid(ProductID);
		productbindcousre.setCourseid(CourseID);
		productbindcousre.setProuctbindcourseid(ProuctBindCourseID);
		return productService.getProductBindCousre(productbindcousre);
	}
	
	
/************************************产品折扣增删查改********************************************************/

	/*@RequestMapping(value = "/addProductdiscount", method = RequestMethod.POST)
	@ResponseBody
	@ApiOperation(value = "增加产品折扣信息", httpMethod = "POST", produces = "application/json")
	public Result addProductdiscount(
			@ApiParam(value="折扣",required= true)Float Discount,  
			@ApiParam(value = "产品ID", required = true) Long ProductID,
			@ApiParam(value = "开始时间", required = false) String StartDate,
			@ApiParam(value = "结束时间", required = false) String EndDate,
			@ApiParam(value = "是否生效", required = false) String IsActice,
			@ApiParam(value = "备注", required = false) String Remark,
			HttpServletRequest request
			) {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		Productdiscount discount = new Productdiscount();
		discount.setDiscount(Discount);
		discount.setProductid(ProductID);
		if (StartDate!=null) {
			discount.setStartdate(super.getDate(StartDate));
		}
		if (EndDate!=null) {
			discount.setEnddate(super.getDate(EndDate));
		}
		discount.setIsactice(IsActice);
		discount.setRemark(Remark);
		return productService.addProductdiscount(accountInfo, discount,CONTROLLER_CODE);
	}
	
	@RequestMapping(value = "/updateProductdiscount", method = RequestMethod.PUT)
	@ResponseBody
	@ApiOperation(value = "修改产品折扣信息", httpMethod = "PUT", produces = "application/json")
	public Result updateProductdiscount(
			@ApiParam(value="产品折扣ID",required= true)Integer ProductDiscountID,  
			@ApiParam(value="折扣",required= false)Float Discount,  
			@ApiParam(value = "产品ID", required = false) Long ProductID,
			@ApiParam(value = "开始时间", required = false) String StartDate,
			@ApiParam(value = "结束时间", required = false) String EndDate,
			@ApiParam(value = "是否生效", required = false) String IsActice,
			@ApiParam(value = "备注", required = false) String Remark,
			HttpServletRequest request
			) {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		Productdiscount discount = new Productdiscount();
		discount.setDiscount(Discount);
		discount.setProductid(ProductID);
		if (StartDate!=null) {
			discount.setStartdate(super.getDate(StartDate));
		}
		if (EndDate!=null) {
			discount.setEnddate(super.getDate(EndDate));
		}
		discount.setIsactice(IsActice);
		discount.setRemark(Remark);
		discount.setProductdiscountid(ProductDiscountID);
		return productService.updateProductdiscount(accountInfo, discount,CONTROLLER_CODE);
	}
	
	@RequestMapping(value = "/deleteProductdiscount/{ProductDiscountID}", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "删除产品折扣信息", httpMethod = "DELETE", produces = "application/json")
	public Result deleteProductdiscount(
			@PathVariable @ApiParam(value="折扣",required= true)Integer ProductDiscountID,  
			HttpServletRequest request
			) {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);

		return productService.deleteProductdiscount(accountInfo, ProductDiscountID,CONTROLLER_CODE);
	}
	
	@RequestMapping(value = "/getProductdiscount", method = RequestMethod.GET)
	@ResponseBody
	@ApiOperation(value = "修改产品折扣信息", httpMethod = "GET", produces = "application/json")
	public Result getProductdiscount(
			@ApiParam(value="产品折扣ID",required= false)Integer ProductDiscountID,  
			@ApiParam(value = "产品ID", required = false) Long ProductID,
			@ApiParam(value = "开始时间", required = false) String StartDate,
			@ApiParam(value = "结束时间", required = false) String EndDate,
			@ApiParam(value = "是否生效", required = false) String IsActice
			) {
		Productdiscount discount = new Productdiscount();
		discount.setProductid(ProductID);
		if (StartDate!=null) {
			discount.setStartdate(super.getDate(StartDate));
		}
		if (EndDate!=null) {
			discount.setEnddate(super.getDate(EndDate));
		}
		discount.setIsactice(IsActice);
		discount.setProductdiscountid(ProductDiscountID);
		return productService.getProductdiscount(discount);
	}*/
	
	@RequestMapping(value = "/thumbnail", method = RequestMethod.DELETE)
	@ResponseBody
	@ApiOperation(value = "删除缩略图", httpMethod = "DELETE", produces = "application/json")
	public Result thumbnail(
		@ApiParam(value = "产品ID", required = false) Long ProductID,
		HttpServletRequest request
			) throws MyException {
		AccountInfo accountInfo = (AccountInfo) request.getAttribute(Constant.ACCOUNTINFO);
		return productService.thumbnail(accountInfo,ProductID);
	}
}
