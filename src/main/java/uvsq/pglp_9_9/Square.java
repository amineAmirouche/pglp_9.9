package uvsq.pglp_9_9;

public class Square implements Shape {
	Point p1;
	Point p2;
	
	public Square(Point p1,Point p2)
	{
		this.p1=p1;
		this.p2=p2;
		
	}
		
	public void move(Point decalage)
	{
		this.p1.x+=decalage.x;
		this.p1.y+=decalage.y;
		this.p2.x+=decalage.x;
		this.p2.y+=decalage.y;
	}
	
	public void draw()
	{
		
		System.out.print("Dessin du carré ");
		Getp1().Print();
		Getp2().Print();
	}
	
	public Point Getp1()
	{
		return this.p1;
	}
	
	public Point Getp2()
	{
		return this.p2;
	}
}
