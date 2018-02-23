package struct.test1;

public class SortedSinglyLinkedList<T extends Comparable<T>> extends SinglyLinkedList<T> {

	public SortedSinglyLinkedList() {
		super();
	}

	public SortedSinglyLinkedList(T[] element) {
		super();
		if (element != null) {
			for (int i = 0; i < element.length; i++) {
				this.insert(element[i]);
			}
		}
	}
	public SortedSinglyLinkedList(SortedSinglyLinkedList<T> list) {
		super(list);
	}

	@Override
	public void insert(int i, T x) {
		throw new UnsupportedOperationException("insert(int i, T x)");
	}

	@Override
	public void append(T x) {
		throw new UnsupportedOperationException("append(T x)");
	}

	public void insert(T x) {
		if (x == null) {
			return;
		}
		Node<T> front = this.head, p = front.next;

		while (p != null && p.data.compareTo(x) < 0) {
			front = p;
			p = p.next;
		}
		front.next = new Node<T>(x, p);
	}

	@Override
	public void remove(T x) {
		if (x == null) {
			return;
		}
		Node<T> front = this.head, p = front.next;

		while (p != null && p.data.compareTo(x) < 0) {
			front = p;
			p = p.next;
		}
		if(p!=null&&p.data.compareTo(x)==0){
			front.next = p.next;
		}
	}

	public static void main(String[] args) {

	}

}
