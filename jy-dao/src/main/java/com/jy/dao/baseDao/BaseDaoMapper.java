package com.jy.dao.baseDao;

import java.util.List;
import java.util.Map;

public interface BaseDaoMapper {
	public List<Map<String,Object>> doSqlMap(String sql);
	public Long doSqlLong(String sql);
	public void doSql(String sql);
}
