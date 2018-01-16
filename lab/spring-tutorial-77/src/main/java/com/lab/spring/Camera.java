package com.lab.spring;

import org.springframework.stereotype.Component;

@Component("camera")
public class Camera implements PhotoSnapper, Machine, ICamera {
	public Camera() {
		System.out.println("Hello from camera constructor");
	}
	
	@Override
	public void snap() {
		System.out.println("SNAP!");

	}

	@Override
	public void snap(int exposure) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String snap(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void snapNighttime() {
		// TODO Auto-generated method stub
		
	}
	
	
}
