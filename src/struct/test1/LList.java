package struct.test1;

public interface LList<T> {
	boolean isEmpty();//判断是否为空

	int length();//返回List长度

	T get(int i);//取得第I个元素

	void set(int i, T x);//将第i个元素设置为x

	void insert(int i, T x);//在第i位置插入x

	void append(T x);//在最后插入一个x

	T remove(int i);//移除第i个元素

	void removeAll();//移除所有元素

	T search(T key);//按照key查找
}
