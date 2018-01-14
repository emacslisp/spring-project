package com.lab.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
public class Camera {
	public void snap() {
		System.out.println("SNAP!");
	}
	
	public void snap(int exposure) {
		System.out.println("SNAP! Exposure: " + exposure);
	}
	
	public String snap(String name) {
		System.out.println("SNAP! String with name: " + name);
		
		return name;
	}
}
