package uvsq.pglp_9_9;

public class Triangle implements Shape {
	private String id;
	private Point p1;
	private Point p2;
	private Point p3;
	
	public Triangle(String id,Point p1,Point p2,Point p3)
	{
		this.id=id;
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
	}
	
	public void move(Point decalage)
	{
		System.out.println(" point 1 du traingle "+ this.GetCoordp1());
		/*this.p1.x+=decalage.x;
		this.p1.y+=decalage.y;
		this.p2.x+=decalage.x;
		this.p2.y+=decalage.y;
		this.p3.x+=decalage.x;
		this.p3.y+=decalage.y;*/
		
		this.p1.SetX(this.p1.getX()+decalage.getX());
		this.p1.SetY(this.p1.getY()+decalage.getY());
		this.p2.SetX(this.p2.getX()+decalage.getX());
		this.p2.SetY(this.p2.getY()+decalage.getY());
		this.p3.SetX(this.p3.getX()+decalage.getX());
		this.p3.SetY(this.p3.getY()+decalage.getY());
		System.out.println("triangle : "   + this.GetCoordp1() +this.GetCoordp2() + this.GetCoordp3()+ "decalage : " + decalage.getX() + decalage.getY());

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
		String s=this.p1.getX()+";"+this.p1.getY();
		//String s=this.p1.x+ ";"+this.p1.y;
		return s;
	}
	
	public String GetCoordp2()
	{
		String s=this.p2.getX()+";"+this.p2.getY();
		//String s=this.p2.x+ ";"+this.p2.y;
		return s;
	}
	
	public String GetCoordp3()
	{
		String s=this.p3.getX()+";"+this.p3.getY();
		//String s=this.p3.x+ ";"+this.p3.y;
		return s;
	}
	
	public String type()
	{
		String type="Triangle";
		return type;
	}
	
}
