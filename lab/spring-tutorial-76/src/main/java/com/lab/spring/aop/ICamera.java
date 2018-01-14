package com.lab.spring.aop;

public interface ICamera {

	public abstract void snap() throws Exception;

	public abstract void snap(int exposure);

	public abstract String snap(String name);

	public abstract void snapNighttime();

}