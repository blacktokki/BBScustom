package com.mycompany.BBScustom.dao;

import java.sql.SQLException;

@FunctionalInterface
public interface DaoQuery{
	public void executeTry() throws SQLException;
}
