package com.lab.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
public class Camera {
	public void snap() {
		System.out.println("SNAP!");
	}
	
	public void snap(int exposure) throws Exception {
		System.out.println("SNAP! Exposure: " + exposure);
		throw new Exception();
	}
	
	public String snap(String name) {
		System.out.println("SNAP! String with name: " + name);
		
		return name;
	}
	
	public void snapNighttime() {
		System.out.println("SNAP! Night mode.");
	}
}
