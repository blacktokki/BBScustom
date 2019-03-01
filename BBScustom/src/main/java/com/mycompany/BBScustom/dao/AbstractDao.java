package com.mycompany.BBScustom.dao;

import java.sql.*;
import javax.naming.*;
import javax.sql.DataSource;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

public abstract class AbstractDao {

	protected DataSource dataSource;
	protected BeanPropertyRowMapper<?> bprm;
	protected PlatformTransactionManager transactionManager;
	
	protected <T> void initialize(String name,Class<T> mappedClass) {
		try {
			Context context =new InitialContext();
			dataSource =(DataSource)context.lookup(name);
			bprm=new BeanPropertyRowMapper<>(mappedClass);
			transactionManager=new DataSourceTransactionManager(dataSource);
		}
		catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	protected void execute(String query,DaoException daoquery) {
		Connection connection=null;
		PreparedStatement preparedStatement=null;
		ResultSet resultSet=null;
		TransactionDefinition definition= new DefaultTransactionDefinition();
		TransactionStatus status=transactionManager.getTransaction(definition);
		try {
			connection = dataSource.getConnection();
			preparedStatement=connection.prepareStatement(query);
			resultSet=daoquery.executeTry(preparedStatement,resultSet);
			transactionManager.commit(status);
		}
		catch(Exception e) {
			transactionManager.rollback(status);
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
