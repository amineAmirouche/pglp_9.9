package uvsq.pglp_9_9.command;

import java.util.ArrayList;

import uvsq.pglp_9_9.CompositeShape;
import uvsq.pglp_9_9.Shape;
import uvsq.pglp_9_9.dao.CircleDAO;
import uvsq.pglp_9_9.dao.CompositeShapeDAO;
import uvsq.pglp_9_9.dao.SquareDAO;
import uvsq.pglp_9_9.dao.TriangleDAO;

/**
 * @author amine
 *
 */
public class CreateCompositeCommand implements Command {
	String id;
	String[] types;
	String[] ids;
	ArrayList<Shape> myElements;
	
	public CreateCompositeCommand (String id,String []types,String[] ids)
	{	this.id=id;
		this.types=types;
		this.ids=ids;
		myElements=new ArrayList<Shape>();
	}
	
	
	
	/**
	 *methode execute qui crée le composite et l'insert dans la bd
	 */
	@Override
	public void execute() throws Exception {
		String url="jdbc:derby:Bdpglp";
		fillMyElements();
		CompositeShape compositeshape=new CompositeShape(this.id);
		CompositeShapeDAO compositeshapedao=new CompositeShapeDAO(url);
		for (int i=0;i<this.myElements.size();i++)
		{
			compositeshape.add(this.myElements.get(i));
		}
		compositeshapedao.saveComposite(compositeshape);
		compositeshapedao.AfficheThisComposite(this.id);
	}
	
	/**
	 * Remplire ma liste d'elements
	 */
	public void fillMyElements()
	{
		String url="jdbc:derby:Bdpglp";
		System.out.println("mon type est :" + this.types[0]);
		for (int i=0;i<this.types.length;i++)
		{
			if (this.types[i].equals("Circle"))
			{
				CircleDAO circledao=new CircleDAO(url);
				if (circledao.existTuple1(ids[i]))
				{this.myElements.add(circledao.getObjet(ids[i]));}
			}
			else if (this.types[i].equals("Square"))
			{
				SquareDAO squaredao=new SquareDAO(url);
				if (squaredao.existTuple1(ids[i]))
				{this.myElements.add(squaredao.getObjet(ids[i]));}
			}
			else if (this.types[i].equals("Triangle"))
			{
				TriangleDAO triangledao=new TriangleDAO(url);
				if (triangledao.existTuple1(ids[i]))
				{this.myElements.add(triangledao.getObjet(ids[i]));}
			}
			
		}
	}
}
