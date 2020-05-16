package uvsq.pglp_9_9;

public class Triangle implements Shape {

	Point p1;
	Point p2;
	Point p3;
	
	public Triangle(Point p1,Point p2,Point p3)
	{
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
	}
	
	public void move(Point decalage)
	{
		this.p1.x+=decalage.x;
		this.p1.y+=decalage.y;
		this.p2.x+=decalage.x;
		this.p2.y+=decalage.y;
		this.p3.x+=decalage.x;
		this.p3.y+=decalage.y;
	}
	
	public void draw()
	{
		System.out.println("aaaaaaa");
	}
	
}
