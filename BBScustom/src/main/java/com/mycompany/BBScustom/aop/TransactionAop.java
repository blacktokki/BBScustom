package com.mycompany.BBScustom.aop;

import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.jdbc.datasource.DataSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.support.TransactionSynchronizationManager;

@Component
public class TransactionAop  extends AbstractAop{	
	
	@Inject
	DataSource dataSource;
	
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable{
		TransactionSynchronizationManager.initSynchronization();
		Connection conn =DataSourceUtils.getConnection(dataSource);
		logger.info(indent+"¦£Transaction is start");
		indent+="¦¢ ";
		Object object=null;
		try {
			conn.setAutoCommit(false);
			try {
				object = joinpoint.proceed();
				conn.commit();
			}
			catch(Exception e) {
				conn.rollback();
			}
		}
		catch(Exception e) {
		}
		finally {
			DataSourceUtils.releaseConnection(conn, dataSource); 
			TransactionSynchronizationManager.unbindResource(this.dataSource);
            TransactionSynchronizationManager.clearSynchronization();
            indent=indent.substring(2);
			logger.info(indent+"¦¦Transaction is finished");
		}
		return object;
	}
}
