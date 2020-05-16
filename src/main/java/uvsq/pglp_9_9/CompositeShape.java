package uvsq.pglp_9_9;

import java.util.ArrayList;

public class CompositeShape implements Shape {

	ArrayList<Shape> listFormes;
	public CompositeShape()
	{
		this.listFormes=new ArrayList<Shape>();
	}
	
	public void add(Shape form)
	{
		this.listFormes.add(form);
	}
	
	public void move(Point decalage)
	{
		for (int i=0;i<this.listFormes.size();i++)
		{
			this.listFormes.get(i).move(decalage);
			
		}
		
	}
	
	public void draw()
	{
		for (Shape s : listFormes)
		{
			s.draw();
		}
	}
	
	//CompositeShape p1;
	//p1.add(triangle);
	//compositeShape p2;
	//p2.add(cercle);
	//p2.add(rectangle);
	//p1.add(p2);
	
	//premier element de p1 est triangle 
	//deuxieme element de p1 est tout p2
	
}
