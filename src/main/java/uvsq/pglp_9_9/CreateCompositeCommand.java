package uvsq.pglp_9_9;

import java.util.ArrayList;

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
	
	
	
	
	@Override
	public void execute() throws Exception {
		String url="jdbc:derby:Bdpglp;shutdown=true";
		//String url="jdbc:derby:Bdpglp";
		fillMyElements();
		CompositeShape compositeshape=new CompositeShape(this.id);
		CompositeShapeDAO compositeshapedao=new CompositeShapeDAO(url);
		for (int i=0;i<this.myElements.size();i++)
		{
			//this.myElements.get(i).draw();
			compositeshape.add(this.myElements.get(i));
		}
		compositeshapedao.saveComposite(compositeshape);
	}
	
	public void fillMyElements()
	{
		String url="jdbc:derby:Bdpglp";
		System.out.println("mon type est :" + this.types[0]);
		for (int i=0;i<this.types.length;i++)
		{
			if (this.types[i].equals("Circle"))
			{
				System.out.println("je suis dans le if");
				CircleDAO circledao=new CircleDAO(url);
				this.myElements.add(circledao.getObjet(ids[i]));
			}
			
		}
	}
}
