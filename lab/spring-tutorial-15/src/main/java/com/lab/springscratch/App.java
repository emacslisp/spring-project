package com.lab.springscratch;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class App {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans-16.xml");
        
        Jungle jungle = (Jungle)context.getBean("jungle");
        
        System.out.println(jungle);
        
        ((ClassPathXmlApplicationContext)context).close();
        
    }
}
