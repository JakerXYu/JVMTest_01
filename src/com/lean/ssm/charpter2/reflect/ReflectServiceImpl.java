package com.lean.ssm.charpter2.reflect;

import java.lang.reflect.Method;

public class ReflectServiceImpl {
	public void sayHello(String name) {
		System.err.println("Hello" + name);
	}

	public static ReflectServiceImpl getInstence() {
		ReflectServiceImpl object = null;
		try {
			object = (ReflectServiceImpl) Class.forName(
					"com.lean.ssm.charpter2.reflect.ReflectServiceImpl")
					.newInstance();

		} catch (ClassNotFoundException | IllegalAccessException
				| InstantiationException ex) {
			ex.printStackTrace();
		}
		return object;
	}

	public Object reflectMethod() {
		Object returnObj = null;
		ReflectServiceImpl target = new ReflectServiceImpl();
		try {
			Method method = ReflectServiceImpl.class.getMethod("sayHello",
					String.class);
			returnObj = method.invoke(target, "张三");
		} catch (Exception e) {
			e.printStackTrace();
		}

		return returnObj;
	}
	public Object reflect() {
		Object object = null;
		try {
			object = (ReflectServiceImpl) Class.forName(
					"com.lean.ssm.charpter2.reflect.ReflectServiceImpl")
					.newInstance();
			Method method = ReflectServiceImpl.class.getMethod("sayHello",
					String.class);
			method.invoke(object, "张三");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return object;
	}

	public static void main(String[] args) {
		ReflectServiceImpl object = ReflectServiceImpl.getInstence();
		object.reflect();
	}
}
