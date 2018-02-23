package struct.test1;

/**
 * 
 * @author Administrator 一元多项式的项类TermX
 * @param <T>
 *            支持泛型
 */
public class TermX<T> implements Comparable<TermX>, Addible<TermX> {
	protected int coef, exp;// 系数，指数

	public TermX(int coef, int exp) {
		this.coef = coef;
		this.exp = exp;
	}

	public TermX(TermX<T> term) {
		this(term.coef, term.exp);
	}

	/**
	 * 用系数x^指数的省略形式构造一元多项式的一项; 当系数为1或-1且指数大于零时省略1,-1只写负号，如x^2,-x^3;
	 * 当指数为0时,省略x^0,只写系数,当指数为1省略^1只写x;
	 * 
	 * @param termstr
	 */
	public TermX(String termstr) {
		if (termstr.charAt(0) == '+') {
			termstr = termstr.substring(1);// 如果以加开头就去掉加号
		}
		int i = termstr.indexOf('x');
		if (i == -1) {// 没有x,指数为零
			this.coef = Integer.parseInt(termstr);// 直接获取系数
		} else {// 有x,x之前为系数,x^后为指数
			if (i == 0) {// 以x开头所以系数为1
				this.coef = 1;
			} else {
				String sub = termstr.substring(0, i);// 截取x以前的字符串
				if (sub.equals("-")) {// 如果只有-则系数为-1
					this.coef = -1;
				} else {
					this.coef = Integer.parseInt(sub);
				}
			}
			i = termstr.indexOf('^');
			if (i == -1) {// 如果没有^则指数为-1
				this.exp = 1;
			} else {// 获得指数
				this.exp = Integer.parseInt(termstr.substring(i + 1));
			}
		}

	}

	@Override // 返回一元多项式的一项对应的"系数^指数"的省略形式的字符串
	public String toString() {
		String str = this.coef > 0 ? "+" : "-";// 系数的负号
		if (this.exp == 0 || this.exp > 0 && this.coef != 1 && this.coef != -1) {
			str += Math.abs(this.coef);// 系数绝对值,省略1
		}
		if (this.exp > 0) {// 指数为零省略x^0
			str += "x";
		}
		if (this.exp > 1) {// 指数为零省略^1,只写x
			str += "^" + this.exp;
		}
		return str;
	}

	@Override // 按指数比较两项大小
	public int compareTo(TermX term) {
		if (this.exp == term.exp) {// 比较相等,仅比较指数
			return 0;
		}
		return this.exp < term.exp ? -1 : 1;
	}

	@Override
	public void add(TermX term) {// 加法
		if (this.compareTo(term) == 0) {
			this.coef += term.coef;
		} else {
			throw new IllegalArgumentException("他俩指数不一样不能相加");

		}
	}

	@Override // 不存储系数为 0 的项
	public boolean removeable() {
		return this.coef == 0;
	}

	@Override // 比较两项是否相等(参数系数)
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof TermX)) {
			return false;
		}
		TermX term = (TermX) obj;
		return this.coef == term.coef && this.exp == term.exp;
	}

}
