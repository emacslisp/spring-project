package com.lab.spring.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Camera camera = (Camera)context.getBean("camera");
		
		camera.snap();
		
		camera.snap(10);
		
		camera.snap("name");
		
		((ClassPathXmlApplicationContext)context).close();
	}
}
