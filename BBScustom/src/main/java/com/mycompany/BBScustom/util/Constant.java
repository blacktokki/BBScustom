package com.mycompany.BBScustom.util;

import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class Constant {
	
	static public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		Constant.jdbcTemplate=jdbcTemplate;
	}
	
	public static Map<String, ?> getDaoMap() {
		return daoMap;
	}

	public void setDaoMap(Map<String, ?> daoMap) {
		Constant.daoMap = daoMap;
	}
	
	static private JdbcTemplate jdbcTemplate;
	
	static private Map<String,?> daoMap;
}
