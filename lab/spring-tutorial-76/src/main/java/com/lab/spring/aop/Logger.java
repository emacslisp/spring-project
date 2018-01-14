package com.lab.spring.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Pointcut("execution(* com.lab.spring.aop.*.*(..))")
	public void cameraSnap() {
	}
	
	@Pointcut("execution(String com.lab.spring.aop.Camera.snap(String))")
	public void cameraSnapWithName() {
	}
	
	@Before("cameraSnap()")
	public void aboutToTakePhoto() {
		System.out.println("About to take photo...");
	}
	
	@Before("cameraSnapWithName()")
	public void aboutToTakePhotoWithName() {
		System.out.println("About to take photo with name...");
	}
	
	@After("cameraSnap()")
	public void afterAdvice() {
		System.out.println("after advice...");
	}
	
	@AfterReturning("cameraSnapWithName()")
	public void afterReturning() {
		System.out.println("after returning...");
	}
	
	@AfterThrowing("cameraSnap()")
	public void afterThrowing() {
		System.out.println("after throwing...");
	}
	
	@Around("cameraSnap()")
	public void afterAround(ProceedingJoinPoint p) throws Throwable {
		System.out.println("after Around (before)...");
		
		p.proceed();
		
		System.out.println("after Around (after)...");
	}
}
