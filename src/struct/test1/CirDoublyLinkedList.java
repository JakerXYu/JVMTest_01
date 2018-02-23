
package struct.test1;

public class CirDoublyLinkedList<T> implements LList<T> {

	DLinkNode<T> head;

	public CirDoublyLinkedList() {//构造方法
		this.head = new DLinkNode<T>();
		this.head.prev = head;
		this.head.next = head;
	}
	public CirDoublyLinkedList(CirDoublyLinkedList<T> list) {//拷贝构造方法
		this();
		DLinkNode<T> p = list.head.next;
		DLinkNode<T> rear = this.head;
		while (p!=null) {
			rear.next = new DLinkNode<T>(p.data,p.prev,null);
			rear = rear.next;
			p = p.next;
		}
	}

	@Override
	public boolean isEmpty() {//如果头结点前后都指向自己则为空
		if (head.next == head && head.prev == head) {
			return true;
		}
		return false;
	}

	@Override
	public int length() {
		int i = 0;
		if (this.head.next == head) {//头指向自己则长度为零
			return 0;
		}
		DLinkNode<T> p = this.head.next;
		while (!p.equals(head)) {//只要记录中头结点不跟p相等就计数+1
			p = p.next;
			i++;
		}
		return i;
	}

	@Override
	public T get(int i) {
		if (i >= 0) {
			DLinkNode<T> p = this.head.next;
			for (int j = 0; p != null && j < i; j++) {//把指针移动到指定位置
				p = p.next;
			}
			if (p != null) {//不为空就返回
				return p.data;
			}
		}
		return null;
	}

	@Override
	public void set(int i, T x) {
		if (x == null) {//插入空元素就返回
			return;
		}
		if (i >= 0) {
			DLinkNode<T> p = this.head.next;
			for (int j = 0; p != null && j < i; j++) {//把指针移动到指定位置
				p = p.next;
			}
			if (p != null) {//set指定元素
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
		DLinkNode<T> p = this.head;
		for (int j = 0; p.next != this.head && j < i; j++) {//把指针移动到指定位置
			p = p.next;
		}
		//这个是重点,放到指定位置以后,前后的结点指针都指向他
		DLinkNode<T> q = new DLinkNode<>(x, p, p.next);
		p.next.prev = q;
		p.next = q;

	}

	@Override
	public void append(T x) {
		if (x == null) {
			return;
		}
		DLinkNode<T> q = new DLinkNode<T>(x, head.prev, head);
		//直接在头指针前插入,修改前后结点的指针
		head.prev.next = q;
		head.prev = q;

	}

	@Override
	public T remove(int i) {
		if (i >= 0) {
			DLinkNode<T> p = this.head.next;
			for (int j = 0; p != head && j < i; j++) {//把指针移动到指定位置
				p = p.next;
			}
			if (p != head) {//修改p前后的指针,p前的next指向p后,p后的prev指向p的next
				//达到把p从存在上抹掉(无人调用且没有指针指向他)
				T old = p.data;
				p.prev.next = p.next;
				p.next.prev = p.prev;
				return old;
			}
		}
		return null;
	}

	@Override
	public void removeAll() {//直接修改头结点指向自己就可以,剩下的都指不到
		this.head.next = head;
		this.head.prev = head;
	}

	@Override
	public T search(T key) {
		if (key == null) {
			return null;
		}
		DLinkNode<T> p = this.head.next;
		while (p != null) {//找不到就一个个比较吧找到了就返回
			if (p.data.equals(key)) {
				return p.data;
			}
			p = p.next;
		}
		return null;
	}

	@Override
	public String toString() {
		String str = "(";
		DLinkNode<T> p = this.head.next;
		while (p != null) {
			str += p.data.toString();
			if (p.next != null) {
				str += ",";
			}
			p = p.next;

		}
		return str + ")";
	}

}
