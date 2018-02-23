package struct.test1.LinerListText.no9;

public class Line {
	public Point p1;
	public Point p2;

	public Line(Point p1, Point p2) {
		super();
		this.p1 = p1;
		this.p2 = p2;
	}

	public Line() {
		this(new Point(), new Point());
	}

}
