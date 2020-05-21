package uvsq.pglp_9_9;

public class Square implements Shape {
	private String Id;
	private Point p1;
	private Point p2;
	
	public Square(String Id,Point p1,Point p2)
	{	
		this.Id=Id;
		this.p1=p1;
		this.p2=p2;
		
	}
		
	public void move(Point decalage)
	{
		/*this.p1.x+=decalage.x;
		this.p1.y+=decalage.y;
		this.p2.x+=decalage.x;
		this.p2.y+=decalage.y;*/
		this.p1.SetX(this.p1.getX()+decalage.getX());
		this.p1.SetY(this.p1.getY()+decalage.getY());
		this.p2.SetX(this.p2.getX()+decalage.getX());
		this.p2.SetY(this.p2.getY()+decalage.getY());
		//System.out.println("SQuare  :" + this.GetCoordp1() +this.GetCoordp2() + "decalage : " + decalage.getX() + decalage.getY());
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
	
	
	public String getId()
	{
		return this.Id;
	}
	
	public String type()
	{
		String type="Square";
		return type;
	}
	
	
	public void Setp1(float x,float y)
	{
		this.p1.SetX(x);
		this.p1.SetY(y);
	}
	
	public void Setp2(float x,float y)
	{
		this.p2.SetX(x);
		this.p2.SetY(y);
	}
	
	
	
	public void SetId(String s)
	{
		this.Id=s;
	}
	
	
	
}
