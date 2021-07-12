package com.example.aop.aopdemo.aop.aspectj;

import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class LoggerAspect {

	@Pointcut("execution(* com.example.aop.aopdemo.aop.SampleBean.*(..))")
	private void allmethods() {
	}

	@Before("execution(* com.example.aop.aopdemo.aop.SampleBean.*(..))")
	public void executeBefore() {
		System.out.println("before method execution .......");
	}

	@Around("allmethods()")
	public Object aroundAdviceMethod(ProceedingJoinPoint pjp) throws Throwable {
		Object[] args = pjp.getArgs();
		String methodSig = pjp.getSignature().toShortString();
		Object retVal = pjp.proceed(args);
		System.out.println("Method sig =" + methodSig + "   args are = " + Arrays.toString(args));
		return null;
	}

}
