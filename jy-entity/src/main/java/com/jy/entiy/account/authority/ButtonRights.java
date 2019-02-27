package com.jy.entiy.account.authority;

/**
 * @ClassName:  ButtonRights   
 * @Description:页面权限封装类
 * @author: cheng fei
 * @date:   2018-08-18 11:10
 */
public class ButtonRights {

	private boolean insertRights;
	
	private boolean updateRights;
	
	private boolean selectRights;
	
	private boolean deleteRights;
	
	public boolean isInsertRights() {
		return insertRights;
	}
	public void setInsertRights(boolean insertRights) {
		this.insertRights = insertRights;
	}
	public boolean isUpdateRights() {
		return updateRights;
	}
	public void setUpdateRights(boolean updateRights) {
		this.updateRights = updateRights;
	}
	public boolean isSelectRights() {
		return selectRights;
	}
	public void setSelectRights(boolean selectRights) {
		this.selectRights = selectRights;
	}
	public boolean isDeleteRights() {
		return deleteRights;
	}
	public void setDeleteRights(boolean deleteRights) {
		this.deleteRights = deleteRights;
	}
	
	
	
}
