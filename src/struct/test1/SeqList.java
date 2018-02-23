package struct.test1;

public class SeqList<T> implements LList<T> {
	private Object[] element;
	private int len;

	public SeqList(int size) {
		this.element = new Object[size];
		this.len = 0;
	}

	public SeqList() {
		this(64);
	}

	@Override
	public boolean isEmpty() {
		return this.len == 0;
	}

	@Override
	public int length() {
		return this.len;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T get(int i) {
		if (i >= 0 && i < this.len) {
			return (T) this.element[i];
		}
		return null;
	}

	@Override
	public void set(int i, T x) {
		if (x == null) {
			return;
		}
		if (i >= 0 && i < this.len) {
			this.element[i] = x;
		} else {
			throw new IndexOutOfBoundsException(i + "");
		}
	}

	@Override
	public String toString() {
		String str = "(";
		if (this.len > 0) {
			str += this.element[0].toString();
		}
		for (int i = 1; i < this.len; i++) {
			str += "," + this.element[i].toString();
		}
		return str + ")";
	}

	@Override
	public void insert(int i, T x) {
		if (x == null) {
			return;
		}
		if (this.len == element.length) {
			Object[] temp = this.element;
			this.element = new Object[temp.length * 2];
			for (int j = 0; j < temp.length; j++) {
				this.element[j] = temp[j];
			}
		}
		if (i < 0) {
			i = 0;
		}
		if (i > this.len) {
			i = this.len;
		}
		for (int j = this.len - 1; j >= i; j++) {
			this.element[j + 1] = this.element[j];
		}
		this.element[i] = x;
		this.len++;

	}

	@Override
	public void append(T x) {
		insert(this.len, x);
	}

	@SuppressWarnings("unchecked")
	@Override
	public T remove(int i) {
		if (this.len == 0 || i < 0 || i > this.len) {
			return null;
		}
		T old = (T) this.element[i];
		for (int j = i; j < this.len - 1; j++) {
			this.element[j] = this.element[j + 1];
		}
		this.element[this.len - 1] = null;
		this.len--;
		return old;
	}

	@Override
	public void removeAll() {
		this.element = new Object[this.element.length];
	}

	public int indexOf(T key) {
		if (key != null) {
			for (int i = 0; i < this.len; i++) {
				if (this.element[i].equals(key)) {
					return i;
				}
			}
		}
		return -1;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T search(T key) {
		int find = this.indexOf(key);
		return find == -1 ? null : (T) this.element[find];
	}

	public boolean contain(T key) {
		return this.indexOf(key) >= 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		return super.equals(obj);
	}
}
