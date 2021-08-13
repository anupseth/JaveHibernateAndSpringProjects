package com.cousemanageent.apo;

import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class CourseAspect {
	
	Logger logger = LoggerFactory.getLogger(getClass());
	
//	@Before("execution(* com.cousemanageent.service.CourseServiceImpl.*(..))")
//	public void before(JoinPoint joinPoint) {
//		logger.info("................ Before method calls");
//		logger.info(joinPoint.getSignature().getName());
//		logger.info(Arrays.toString(joinPoint.getArgs()));
//	}

	@Around(value = "execution(* com.cousemanageent.service.CourseServiceImpl.*(..))")
	public Object before(ProceedingJoinPoint proJoinPoint) throws Throwable {
		logger.info("................ Around method started = "+ proJoinPoint.getSignature().getName());
		logger.info(Arrays.toString(proJoinPoint.getArgs()));
		Object proceed = proJoinPoint.proceed();
		logger.info("................ Around method finished = "+ proJoinPoint.getSignature().getName());
		return proceed;
	}
	

}
