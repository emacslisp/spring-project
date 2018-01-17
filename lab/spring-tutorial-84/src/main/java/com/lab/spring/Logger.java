package com.lab.spring;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Logger {

	// @Pointcut("within(@org.springframework.stereotype.Component com.caveofprogramming.spring..*)")
	// public void somePointcut() {
	// }
	//
	//
	// @Before("somePointcut()")
	// public void somePointcutDemo() {
	// System.out.println("********** BEFORE DEMO ************");
	// }

	// // @within
	// @Pointcut("@target(org.springframework.stereotype.Component)")
	// public void somePointcut() {
	// }
	//
	//
	// @Before("somePointcut()")
	// public void somePointcutDemo() {
	// System.out.println("********** BEFORE DEMO ************");
	// }

//	@Pointcut("@annotation(java.lang.Deprecated)")
//	public void somePointcut() {
//	}
//
//	@Before("somePointcut()")
//	public void somePointcutDemo() {
//		System.out.println("********** BEFORE DEMO ************");
//	}
	
	/*@Pointcut("@args(java.lang.Deprecated)")
	public void somePointcut() {
	}*/
	
	/*
	// int, .. or .., double
	@Pointcut("target(com.lab.spring.Camera)")
	public void somePointcut() {
	}

	@Before("somePointcut()")
	public void somePointcutDemo(JoinPoint jp) {
		System.out.println("********** BEFORE DEMO ************");
		
		for(Object obj: jp.getArgs()) {
			System.out.println("ARG: " + obj);
		}
	}*/
	
	@Pointcut("args(exposure, aperture)")
	public void somePointcut(int exposure, double aperture) {
	}
	
	@Pointcut("target(com.lab.spring.Camera)")
	public void targetCamera() {
	}
	

	@Before("targetCamera() &&  somePointcut(exposure, aperture)")
	public void somePointcutDemo(int exposure, double aperture) {
		System.out.println("********** BEFORE DEMO ************");
		
		System.out.printf("exposure %d, aperture %.2f\n", exposure, aperture);
	}
	
	@After("within(com.lab.spring.*) && !@annotation(Deprecated)")
	public void someAfterAdvice() {
		System.out.println("After advice running!!!");
	}

}
