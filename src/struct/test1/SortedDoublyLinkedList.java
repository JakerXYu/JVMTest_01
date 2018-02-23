package struct.test1;

public class SortedDoublyLinkedList<T extends Comparable<T>> extends CirDoublyLinkedList<T> {

	public SortedDoublyLinkedList() {
		super();
	}
	public SortedDoublyLinkedList(T[] elements) {
		super();
		for (int i = 0; i < elements.length; i++) {
			this.insert(elements[i]);
		}
	}
	public SortedDoublyLinkedList(SortedDoublyLinkedList<T> list) {
		super(list);
	}
	private void insert(T t) {
		// TODO Auto-generated method stub
		
	}

}
