package com.practice.learnspringaop.aopexample.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

//Define that this is a Configuration Class
@Configuration
//Which contains AOP Configuration
@Aspect
public class LoggingAspect {
	
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	//Pointcut -- Defines When to log Method Calls - When ?
	//If we want to intercept all the calls to the class in a specific package then the syntax for pointcut is ->
	// execution(* Package.*.*(..))
	// execution(* com.practice.learnspringaop.aopexample.business.*.*(..))
	//@Pointcut("execution(* com.practice.learnspringaop.aopexample.business.*.*(..))")
	//We want to execute this Pointcut before a method is called, and that's why we will use ->
	//@Before("execution(* com.practice.learnspringaop.aopexample.business.*.*(..))")
	//@Before("execution(* com.practice.learnspringaop.aopexample.data.*.*(..))")
	//@Before("execution(* com.practice.learnspringaop.aopexample.*.*.*(..))")
	//@Before("execution(* com.practice.*.*.*.*.*(..))")
	@Before("com.practice.learnspringaop.aopexample.aspects.CommonPointcutConfig.allPackageConfigUsingBean()")
	//@Before("com.practice.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCallBeforeExecution(JoinPoint joinPoint) {
		//Now, we want to identify a specific method execution, a specific method execution is called - JoinPoint
		
		//Logic here - What ?
		//logger.info("Before Aspect - Method is called - {}" , joinPoint);
		logger.info("Before Aspect - {} is called with arguments: {}" , joinPoint,joinPoint.getArgs());
	}
	
	@After("com.practice.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()")
	public void logMethodCallAfterExecution(JoinPoint joinPoint) {
		logger.info("After Aspect - {} has executed" , joinPoint);
	}
	
	@AfterThrowing(
			pointcut = "com.practice.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", 
			throwing = "exception"
			)
	public void logMethodCallAfterException(JoinPoint joinPoint, Exception exception) {
		logger.info("AfterThrowing Aspect - {} has thrown an exception {}" , joinPoint, exception);
	}
	
	@AfterReturning(
			pointcut = "com.practice.learnspringaop.aopexample.aspects.CommonPointcutConfig.businessAndDataPackageConfig()", 
			returning = "resultValue"
			)
	public void logMethodCallAfterSuccessfulExecution(JoinPoint joinPoint, Object resultValue) {
		logger.info("AfterReturning Aspect - {} has returned the value {}" , joinPoint, resultValue);
	}
}