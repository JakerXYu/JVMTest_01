package com.lean.ssm.charpter2.reflect;

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
	public static void main(String[] args) {
		ReflectServiceImpl object = ReflectServiceImpl.getInstence();
		object.sayHello("hh");
	}
}
