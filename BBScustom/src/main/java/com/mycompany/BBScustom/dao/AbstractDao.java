package com.mycompany.BBScustom.dao;

import java.sql.*;

import javax.naming.*;
import javax.sql.DataSource;

import com.mycompany.BBScustom.dto.IDto;


public abstract class AbstractDao {

	protected DataSource dataSource;
	
	abstract protected IDto createDto(ResultSet rs) throws SQLException;
	
	protected void bindName(String name) {
		try {
			Context context =new InitialContext();
			dataSource =(DataSource)context.lookup(name);
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	protected void execute(String query,DaoException daoquery) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		try {
			connection = dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			daoquery.executeTry(preparedStatement,resultSet);
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
