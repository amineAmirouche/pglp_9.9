package uvsq.pglp_9_9;

public class Circle implements Shape {
	String id;
	Point centre;
	int rayon;
	
	public Circle(String id,Point centre,int r)
	{
		this.id=id;
		this.centre=centre;
		this.rayon=r;
		/*this.centre.x=centre.x;
		this.centre.y=centre.y;
		this.rayon=r;*/
	}

	public void move(Point decalage)
	{
		this.centre.x+=decalage.x;
		this.centre.y+=decalage.y;
	}
	
	public void draw()
	{
		System.out.println("cercle au rayon : " + this.rayon);
		getCentre().Print();
	}
	
	public Point getCentre()
	{
		return this.centre;
	}
	
	public int getRayon()
	{
		return this.rayon;
	}
	
	public String GetCoordcentre()
	{
		
		String s=this.centre.x+ ";"+this.centre.y;
		return s;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	
}
