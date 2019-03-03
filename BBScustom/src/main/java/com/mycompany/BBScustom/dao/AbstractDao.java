package com.mycompany.BBScustom.dao;

import java.sql.*;
import java.util.ArrayList;

//import javax.naming.*;
import javax.sql.DataSource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.transaction.*;
import org.springframework.transaction.support.DefaultTransactionDefinition;


public abstract class AbstractDao {

	protected DataSource dataSource;
	protected PlatformTransactionManager transactionManager;
	
	public void setDataSource(DataSource _dataSource) {
		dataSource = _dataSource;
	}
	
	public void setTransactionManager(PlatformTransactionManager _transactionManager) {
		transactionManager = _transactionManager;
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
	protected <T> void mapper(Class<T> mappedClass,ResultSet resultSet,ArrayList<T> dtos) throws SQLException {
		BeanPropertyRowMapper<T> beanPropertyRowMapper =new BeanPropertyRowMapper<>(mappedClass);
		for(int i=0;resultSet.next();i++) {
			dtos.add(beanPropertyRowMapper.mapRow(resultSet, i));
		}
	}
}
