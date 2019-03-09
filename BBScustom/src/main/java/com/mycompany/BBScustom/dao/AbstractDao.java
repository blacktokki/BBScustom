package com.mycompany.BBScustom.dao;
import org.springframework.jdbc.core.JdbcTemplate;
public abstract class AbstractDao implements Dao{
	
	protected JdbcTemplate jdbcTemplate;
	
	public final void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
}
