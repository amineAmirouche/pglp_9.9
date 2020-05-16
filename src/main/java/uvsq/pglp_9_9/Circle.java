package uvsq.pglp_9_9;

public class Circle implements Shape {
	Point centre;
	int rayon;
	
	public Circle(Point centre,int r)
	{
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
	
	
}
