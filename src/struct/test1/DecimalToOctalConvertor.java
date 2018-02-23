package struct.test1;

import java.util.Scanner;
import java.util.Stack;

/**
 * 将十进制数转换为八进制数
 *
 * @author austin
 */
public class DecimalToOctalConvertor {
	public static void main(String[] args) {

		Scanner reader = new Scanner(System.in);
		System.out.print("请输入要转换的十进制数：");
		int decimalNum = reader.nextInt();
		/*
		 * 采用除8取余，从下至上的算法来计算八进制数：即用进制数除以8，然后将所得余数作为8进制数的低位数，
		 * 再用所得的商继续除以8，以此类推，直到商为0为止
		 * 在这个过程中，每次的余数都需要保存到一个列表中，而且后添加到列表中的元素要先输出，即后进先出， 因此采用栈结构来处理
		 */
		Stack<Integer> octalStack = new Stack<Integer>();
		int temp = decimalNum;
		while (temp != 0) // 如果商不为0，则继续计算下去
		{
			octalStack.push(temp % 8); // 将除以8所得的余数添加到栈中
			temp /= 8; // 计算除以8所得的商
		} 
		/*
		 * 采用后进先出的方式输入栈中的元素，就得到了所要求的八进制数
		 */
		System.out.print("八进制：0");
		while (!octalStack.isEmpty()) {
			System.out.print(octalStack.pop());
		}
		reader.close();
		System.out.println();
	}
}