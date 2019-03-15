package com.mycompany.BBScustom.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class LogAop extends AbstractAop{
	
	public Object around(ProceedingJoinPoint joinpoint) throws Throwable{
		String signatureStr =joinpoint.getSignature().toShortString();
		logger.info(indent+"¦£"+signatureStr +"is start");
		indent+="¦¢ ";
		long st=System.currentTimeMillis();
		
		try {
			Object object = joinpoint.proceed();
			return object;
		}finally {
			long et =System.currentTimeMillis();
			indent=indent.substring(2);
			logger.info(indent+"¦¢ Execution time : "+(et-st)+" ms");
			logger.info(indent+"¦¦"+signatureStr +"is finished");
		}
	}
}
