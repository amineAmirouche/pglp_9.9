package uvsq.pglp_9_9;

public class Circle implements Shape {
	private String id;
	private Point centre;
	private int rayon;
	
	public Circle(String id,Point centre,int r)
	{
		this.id=id;
		this.centre=centre;
		this.rayon=r;
		}

	public void move(Point decalage)
	{
		this.centre.SetX(this.centre.getX()+decalage.getX());
		this.centre.SetY(this.centre.getY()+decalage.getY());
		
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
		String s=this.centre.getX()+";"+this.centre.getY();
		//String s=this.centre.x+ ";"+this.centre.y;
		return s;
	}
	
	public String getId()
	{
		return this.id;
	}
	
	public String type()
	{
		String type="Circle";
		return type;
	}
	
	public void SetId(String s)
	{
		this.id=s;
	}
	
	
	public void SetCentre(float x,float y)
	{
		this.centre.SetX(x);
		this.centre.SetY(y);
	}
	
	public void SetRayon(int r)
	{
		this.rayon=r;
	}
	
	
}
