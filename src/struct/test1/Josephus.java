package struct.test1;

public class Josephus {

	public Josephus(int number,int start,int distance,int end) {
		LList<String> list;
//		list = new SeqList<String>(number);
		list = new SinglyLinkedList<String>();
		for (int i = 0; i < number; i++) {
			list.append((char)('A'+i)+"");
		}
		System.out.println("约瑟夫环("+number+","+start+","+distance+")");
		System.out.println(list.toString());
		int i = start;
		while (list.length()>end) {
			i = (i+distance-1)%list.length();
			System.out.println("删除"+list.remove(i).toString()+",");
			System.out.println(list.toString());
			
		}
		System.out.println("被赦免的是"+list.get(0));
		
		
	}
	public static void main(String[] args) {
		new Josephus(5,0,3,1);
	}
}
