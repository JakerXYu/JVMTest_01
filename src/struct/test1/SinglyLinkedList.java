package struct.test1;

public class SinglyLinkedList<T> implements LList<T> {
	public Node<T> head;

	public SinglyLinkedList() {
		this.head = new Node<T>();
	}

	public SinglyLinkedList(T[] element) {
		this();
		Node<T> rear = this.head;
		for (int i = 0; i < element.length; i++) {
			rear.next = new Node<T>(element[i], null);
			rear = rear.next;
		}
	}
	public SinglyLinkedList(SinglyLinkedList<T> list) {
		this();
		Node<T> p = list.head.next;
		Node<T> rear = this.head;
		while (p!=null) {
			rear.next = new Node<T>(p.data,null);
			rear = rear.next;
			p = p.next;
		}
	}

	@Override
	public boolean isEmpty() {
		return this.head.next == null;
	}

	@Override
	public int length() {
		int i = 0;
		Node<T> p = this.head.next;
		while (p != null) {
			i++;
			p = p.next;
		}
		return i;
	}

	@Override
	public String toString() {
		String str = "(";
		Node<T> p = this.head.next;
		while (p != null) {
			str += p.data.toString();
			if (p.next != null) {
				str += ",";
			}
			p = p.next;

		}

		return str + ")";
	}

	@Override
	public T get(int i) {
		if (i >= 0) {
			Node<T> p = this.head.next;
			for (int j = 0; p != null && j < i; j++) {
				p = p.next;
			}
			if (p != null) {
				return p.data;
			}
		}
		return null;
	}

	@Override
	public void set(int i, T x) {
		if (x == null) {
			return;
		}
		if (i >= 0) {
			Node<T> p = this.head.next;
			for (int j = 0; p != null && j < i; j++) {
				p = p.next;
			}
			if (p != null) {
				p.data = x;
			}
		} else {
			throw new IndexOutOfBoundsException(i + "");
		}
	}

	@Override
	public void insert(int i, T x) {
		if (x == null) {
			return;
		}
		Node<T> p = this.head;
		if (i <= 0) {
			Node<T> q = new Node<>(x, p.next);
			p.next = q;
		}
		for (int j = 0; p.next != null && j < i; j++) {
			p = p.next;
		}
		p.next = new Node<>(x, p.next);
	}

	@Override
	public void append(T x) {
		insert(Integer.MAX_VALUE, x);
	}

	@Override
	public T remove(int i) {
		if (i >= 0) {
			Node<T> p = this.head;
			for (int j = 0; p.next != null && j < i; j++) {
				p = p.next;
			}
			if (p.next != null) {
				T old = p.next.data;
				p.next = p.next.next;
				return old;
			}
		}
		return null;
	}

	@Override
	public void removeAll() {
		this.head.next = null;
	}

	@Override
	public T search(T key) {
		if (key == null) {
			return null;
		}
		Node<T> p = this.head.next;
		while (p != null) {
			if (p.data.equals(key)) {
				return p.data;
			}
			p = p.next;
		}
		return null;
	}

	public void remove(T x) {
		if (this.head.next == null || x == null) {
			return;
		}
		Node<T> front = this.head;
		Node<T> p = front.next;
		while (p != null && p.data.equals(x)) {
			front = p;
			p = p.next;
		}
		if (p != null) {
			front.next = p.next;
		}
	}
}
