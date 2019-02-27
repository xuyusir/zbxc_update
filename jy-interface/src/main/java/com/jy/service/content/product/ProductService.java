package com.jy.service.content.product;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

import com.jy.common.exception.MyException;
import com.jy.common.result.Result;
import com.jy.entiy.account.account.AccountInfo;
import com.jy.entiy.content.product.product.Productbindcousre;
import com.jy.entiy.content.product.product.Productdiscount;
import com.jy.entiy.content.product.product.Productinfo;

/**
 * 产品管理业务逻辑层接口
 * 
 * @author liuhong
 * @date: 2018年8月24日 下午5:40:10
 * @Package: com.jy.service.product
 */
public interface ProductService {

	/**
	 * 添加产品信息
	 * 
	 * @param accountInfo
	 * @param productinfo
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result addProduct(AccountInfo accountInfo, Productinfo productinfo,String courseIDs) throws MyException;

	/**
	 * 修改产品信息
	 * 
	 * @param accountInfo
	 * @param productinfo
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result updateProduct(AccountInfo accountInfo, Productinfo productinfo,String courseIDs) throws MyException;

	
	/**
	 * 产品审核
	 * 
	 * @param accountInfo
	 * @param productinfo
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result checkProduct(AccountInfo accountInfo, Productinfo productinfo) throws MyException;

	/**
	 * 查询产品信息
	 * 
	 * @param param
	 * @return
	 */
	public Result getProduct(Map<String, Object> param);

	/**
	 * 删除产品信息
	 * 
	 * @param accountInfo
	 * @param ProductID
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result deleteProduct(AccountInfo accountInfo, String ids,Integer type) throws MyException;

	/**
	 * 产品绑定课程信息
	 * 
	 * @param accountInfo
	 * @param productbindcousre
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result addProductBindCousre(AccountInfo accountInfo, Productbindcousre productbindcousre,int temp) throws MyException;

	/**
	 * 修改产品绑定课程信息
	 * 
	 * @param accountInfo
	 * @param productbindcousre
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result updateProductBindCousre(AccountInfo accountInfo, Productbindcousre productbindcousre,
			String CONTROLLER_CODE) throws MyException;

	/**
	 * 删除产品课程绑定信息
	 * 
	 * @param accountInfo
	 * @param productbindcousre
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result deleteProductBindCousre(AccountInfo accountInfo, Long productbindcousre) throws MyException;

	/**
	 * 查询课程产品绑定信息
	 * 
	 * @param productbindcousre
	 * @return
	 */
	public Result getProductBindCousre(Productbindcousre productbindcousre);

	/**
	 * 增加产品折扣信息
	 * 
	 * @param accountInfo
	 * @param discount
	 * @return
	 * @throws MyException 
	 */
	public Result addProductdiscount(AccountInfo accountInfo, Productdiscount discount, String CONTROLLER_CODE) throws MyException;

	/**
	 * 修改折扣信息
	 * 
	 * @param accountInfo
	 * @param discount
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result updateProductdiscount(AccountInfo accountInfo, Productdiscount discount, String CONTROLLER_CODE) throws MyException;

	/**
	 * 删除产品折扣信息
	 * @param accountInfo
	 * @param ProductDiscountID
	 * @param CONTROLLER_CODE
	 * @return
	 * @throws MyException 
	 */
	public Result deleteProductdiscount(AccountInfo accountInfo, Integer ProductDiscountID, String CONTROLLER_CODE) throws MyException;
	
	/**
	 * 查询产品折扣信息
	 * @param discount
	 * @return
	 */
	public Result getProductdiscount(Productdiscount discount);
	
	/**
	 * 删除缩略图
	 * @param accountInfo
	 * @param ProductID
	 * @return
	 * @throws MyException 
	 */
	public Result thumbnail(AccountInfo accountInfo,Long ProductID) throws MyException;
	
	/**
	 * 回收站产品还原
	 * @param accountInfo
	 * @param ProductID
	 * @return
	 * @throws MyException 
	 */
	public Result returns(AccountInfo accountInfo,String ProductID) throws MyException;
}
