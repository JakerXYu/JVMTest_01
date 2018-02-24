package com.lean.ssm.charpter2.reflect;

import java.lang.reflect.InvocationTargetException;

public class ReflectServiceImpl2 {
	String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ReflectServiceImpl2(String name) {
		super();
		this.name = name;
	}

	public void sayHello() {
		System.err.println("Hello" + name);
	}

	public static ReflectServiceImpl2 getInstence() {
		ReflectServiceImpl2 object = null;
		try {
			object = (ReflectServiceImpl2) Class
					.forName(
							"com.lean.ssm.charpter2.reflect.ReflectServiceImpl2")
					.getConstructor(String.class).newInstance("张三");

		} catch (ClassNotFoundException | IllegalAccessException
				| InstantiationException | NoSuchMethodException
				| IllegalArgumentException | SecurityException
				| InvocationTargetException ex) {
			ex.printStackTrace();
		}
		return object;
	}
}
