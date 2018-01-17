package com.lab.spring;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class MachineAspect {
	
	//make Machine as parent
	@DeclareParents(value="com.lab.spring.*", defaultImpl=com.lab.spring.Machine.class)
	private IMachine machine;
	
	@Around("within(com.lab.spring.*)")
	public void runMachine(ProceedingJoinPoint jp) {
		
		System.out.println("Running ...");
		try {
			jp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("... completed.");
	}
}
