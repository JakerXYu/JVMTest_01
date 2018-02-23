package struct.test1;

public class SinglyLinkedList_average {

	public static Integer[] random(int n) {
		Integer[] element = new Integer[n];
		for (int i = 0; i < n; i++) {
			element[i] = new Integer((int) (Math.random() * 100));
		}
		return element;
	}

	public static double averageExcepMaxMin(SinglyLinkedList<Integer> list) {
		if (list.isEmpty()) {
			throw new IllegalArgumentException("空表你让劳资算个锤锤哦");
		}
		int sum = 0, i = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
		Node<Integer> p = list.head.next;
		while (p != null) {
			int value = p.data.intValue();
			sum += value;
			if (value > max) {
				max = value;
			}
			if (value < min) {
				min = value;
			}
			p = p.next;
			i++;
		}
		if (i == 1 || i == 2) {
			return (double) sum / i;
		}
		return (double) (sum - max - min) / (i - 2);
	}
	
	public static void main(String[] args) {
		SinglyLinkedList<Integer> list = new SinglyLinkedList<Integer>(random(0));
		System.out.println("list"+list.toString());
		System.out.println("去极值均值"+averageExcepMaxMin(list));
	}
	
}
