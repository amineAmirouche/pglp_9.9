package uvsq.pglp_9_9;

public class Triangle implements Shape {
	String id;
	Point p1;
	Point p2;
	Point p3;
	
	public Triangle(String id,Point p1,Point p2,Point p3)
	{
		this.id=id;
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
		System.out.println(this.id+ ":");
		this.p1.Print();
		this.p2.Print();
		this.p3.Print();
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public String GetCoordp1()
	{
		
		String s=this.p1.x+ ";"+this.p1.y;
		return s;
	}
	
	public String GetCoordp2()
	{
		
		String s=this.p2.x+ ";"+this.p2.y;
		return s;
	}
	
	public String GetCoordp3()
	{
		
		String s=this.p3.x+ ";"+this.p3.y;
		return s;
	}
	
}
