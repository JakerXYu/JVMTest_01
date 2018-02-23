package jvm.test1;
/**
 * 虚拟机栈和本地方法栈OOM测试
 * @author Administrator
 *
 */
public class JavaVMStackSOF {
	private int stackLength = 1;
	public void stackLeak(){
		stackLength++;
		stackLeak();
	}
	public static void main(String[] args) {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
		} catch (Throwable e) {
			System.out.println("steakLength:"+oom.stackLength);
			throw e;
		}
	}
}
