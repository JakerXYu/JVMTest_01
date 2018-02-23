package struct.test1;

public class PolySLinkedList<T extends Comparable<T> & Addible<T>> extends SortedSinglyLinkedList<T> {

	public PolySLinkedList() {
		super();
	}

	public PolySLinkedList(T[] terms) {
		super(terms);
	}

	public PolySLinkedList(PolySLinkedList<T> list) {
		super(list);
	}

	public void add(PolySLinkedList<T> polylist) {
		Node<T> front = this.head, p = front.next;
		Node<T> q = polylist.head.next;
		while (p != null && q != null) {
			if(p.data.compareTo(q.data)==0){//如果两项指数相同
				p.data.add(q.data);
				if(p.data.removeable()){//检测是否移除该项并执行
					front.next = p.next;
					p = front.next;
				}
			}
			
		}
	}
}
