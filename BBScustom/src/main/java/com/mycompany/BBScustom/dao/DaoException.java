package com.mycompany.BBScustom.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@FunctionalInterface
public interface DaoException{
	public void executeTry(PreparedStatement ps, ResultSet rs) throws SQLException;
}
