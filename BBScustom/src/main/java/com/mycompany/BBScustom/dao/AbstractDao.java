package com.mycompany.BBScustom.dao;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;


public abstract class AbstractDao {
	protected DataSource dataSource;
	protected Connection connection;
	protected PreparedStatement preparedStatement;
	protected ResultSet resultSet;
	
	protected void bindName(String name) {
		try {
			Context context =new InitialContext();
			dataSource =(DataSource)context.lookup(name);
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	protected void execute(String query,DaoQuery daoquery) {
		try {
			connection = dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			daoquery.executeTry();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet !=null)resultSet.close();
				if(preparedStatement !=null)preparedStatement.close();
				if(connection !=null)connection.close();
			}
			catch(Exception e2) {
			}
		}
	}
}
