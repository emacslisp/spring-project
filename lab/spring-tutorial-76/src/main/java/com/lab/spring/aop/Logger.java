package com.lab.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Pointcut("execution(void com.lab.spring.aop.Camera.snap())")
	public void cameraSnap() {
	}
	
	@Before("cameraSnap()")
	public void aboutToTakePhoto() {
		System.out.println("About to take photo...");
	}
}
