package com.mycompany.BBScustom.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

public abstract class AbstractDao {

	protected DataSource dataSource;
	protected BeanPropertyRowMapper<?> bprm;
	
	protected <T> void initialize(String name,Class<T> mappedClass) {
		try {
			Context context =new InitialContext();
			dataSource =(DataSource)context.lookup(name);
			bprm=new BeanPropertyRowMapper<>(mappedClass);
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
			resultSet=daoquery.executeTry(preparedStatement,resultSet);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(resultSet !=null) {resultSet.close();}
				if(preparedStatement !=null)preparedStatement.close();
				if(connection !=null)connection.close();
			}
			catch(Exception e2) {
			}
		}
	}
}
