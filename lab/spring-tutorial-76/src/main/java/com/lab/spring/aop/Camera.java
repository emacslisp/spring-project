package com.lab.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
public class Camera implements PhotoSnapper, Machine, ICamera {
	public void snap() {
		System.out.println("SNAP!");
	}
	
	@Override
	public void snap(int exposure) {
		System.out.println("SNAP! Exposure: " + exposure);
		//throw new Exception();
	}
	
	@Override
	public String snap(String name) {
		System.out.println("SNAP! String with name: " + name);
		
		return name;
	}
	
	@Override
	public void snapNighttime() {
		System.out.println("SNAP! Night mode.");
	}
}
