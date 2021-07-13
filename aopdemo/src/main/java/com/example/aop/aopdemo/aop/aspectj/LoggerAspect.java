package com.example.aop.aopdemo.aop.aspectj;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {

	@Pointcut("execution(* com.example.aop.aopdemo.aop.SampleBean.*(..))")
	private void allmethods() {
	}

	//This expression will advise to all the methods in  SampleBean class
	@Before("execution(* com.example.aop.aopdemo.aop.SampleBean.*(..))")
	public void executeBefore() {
		System.out.println("before method execution .......");
	}

	@Around("allmethods()")
	public Object aroundAdviceMethod(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		String methodSig = pjp.getSignature().toShortString();
		System.out.println("Around before executing ......");
		Object retVal = pjp.proceed(args);
		System.out.println("Method sig =" + methodSig + "   args are = " + Arrays.toString(args));
		return null;
	}
	
	// This pointcut expression will execute at all the methods in "com.example.aop.aopdemo.aop.aspectj.beans" 
	//in subpackages methods
	@Before("execution(* com.example.aop.aopdemo.aop.aspectj.beans..*.*(..))")
	public void beforeMethod() {
		System.out.println("before method");
	}
	
	@After("execution(* com.example.aop.aopdemo.aop.aspectj.beans..*.*(..))")
	public void afterMethod() {
		System.out.println("After method = ");
	}

}
