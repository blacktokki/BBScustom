package com.mycompany.BBScustom.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Component
public class LogAop {
	private static final Logger logger = LoggerFactory.getLogger(LogAop.class);
	
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable{
		String signatureStr =joinpoint.getSignature().toShortString();
		logger.info(signatureStr +"is start");
		long st=System.currentTimeMillis();
		
		try {
			Object object = joinpoint.proceed();
			return object;
		}finally {
			long et =System.currentTimeMillis();
			logger.info(signatureStr +"is finished: "+(et-st)+"ms");
		}
	}
}
