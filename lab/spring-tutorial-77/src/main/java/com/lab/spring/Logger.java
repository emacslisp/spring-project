package com.lab.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {
	
	@Pointcut("within(com.lab.spring..*)")
	public void withinDemo() {
	}
	
	@Pointcut("target(com.lab.spring.Camera)")
	public void targetDemo() {
	}
	
	@Pointcut("this(com.lab.spring.ICamera)")
	public void thisDemo() {
	}
	
	@Before("withinDemo()")
	public void withinDemoAdvice() {
		System.out.println("********** BEFORE DEMO ************");
	}
	
	@Before("targetDemo()")
	public void targetDemoAdvice() {
		System.out.println("********** TARGET DEMO ************");
	}
	
	@Before("thisDemo()")
	public void thisDemoAdvice() {
		System.out.println("********** THIS DEMO ************");
	}
	
}
