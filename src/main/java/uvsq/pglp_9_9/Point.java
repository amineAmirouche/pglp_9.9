package uvsq.pglp_9_9;

public class Point {
	
	public float x;
	public float y;
	
	public Point (float x,float y)
	{
		this.x=x;
		this.y=y;
	}
	
	public void Print()
	{
		
		System.out.println("("+ this.x + "; "+ this.y+ ")");
	}

	public float getX()
	{
		return this.x;
		
	}
	
	public float getY()
	{
		return this.y;
	}
	
	public void SetX(float x)
	{
		this.x+=x;
	}
	
	public void SetY(float y)
	{
		this.y+=y;
	}
	
}
