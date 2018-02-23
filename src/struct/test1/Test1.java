package struct.test1;

public class Test1 {

	public static void main(String[] args) {
		SortedDoublyLinkedList<Integer> list = new SortedDoublyLinkedList<Integer>();
		list.append(10);
		list.append(11);
		list.append(12);
		list.append(13);
		list.append(14);
		list.append(15);
		System.out.println(list);
		SortedDoublyLinkedList<Integer> list2 =new SortedDoublyLinkedList<Integer>(list);
		System.out.println(list2);

	}

}
