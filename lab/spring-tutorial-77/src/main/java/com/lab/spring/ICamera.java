package com.lab.spring;

public interface ICamera {
	public abstract void snap();

	public abstract void snap(int exposure);

	public abstract String snap(String name);

	public abstract void snapNighttime();
}
