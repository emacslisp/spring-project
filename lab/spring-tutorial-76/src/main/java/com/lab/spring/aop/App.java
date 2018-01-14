package com.lab.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Camera camera = (Camera)context.getBean("camera");
		
		Lens lens = (Lens)context.getBean("lens");
		
		camera.snap();
		try {
		camera.snap(10);
		}catch(Exception e) {
			System.out.println("Exception happends " + e.getMessage());
		}
		
		camera.snap("name");
		
		lens.zoom(5);
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
