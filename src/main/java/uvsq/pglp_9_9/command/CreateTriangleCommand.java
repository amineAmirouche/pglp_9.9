package uvsq.pglp_9_9.command;

import uvsq.pglp_9_9.Point;
import uvsq.pglp_9_9.Triangle;
import uvsq.pglp_9_9.dao.TriangleDAO;

/**
 * @author amine
 *
 */
public class CreateTriangleCommand implements Command {
	String id;
	Point p1;
	Point p2;
	Point p3;
	
	public CreateTriangleCommand(String id,Point p1,Point p2,Point p3)
	{
		this.id=id;
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		
	}
	/**
	 *methode execute qui crée le triangle et l'insert dans la bd
	 */
	@Override
	public void execute() throws Exception {
		String url="jdbc:derby:Bdpglp";
		Triangle triangle=new Triangle(this.id,this.p1,this.p2,this.p3);
		TriangleDAO triangledao=new TriangleDAO(url);
		triangledao.saveTriangle(triangle);
		triangledao.AfficheThisTriangle(triangle);
		
		System.out.println("le triangle a bien ete sauvegardé dans la bd");
		
	}

}
