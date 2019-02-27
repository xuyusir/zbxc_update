package com.jy.entiy.content.file.directory;

/**
 * @ClassName: TreeNode
 * @Description:树形结构节点实体类
 * @author: cheng fei
 * @date: 2018-09-11 09:20
 */
public class VueTreeNode {

	private long code;
	
	private String name;

	private boolean expand;

	public boolean isExpand() {
		return expand;
	}

	public void setExpand(boolean expand) {
		this.expand = expand;
	}

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
