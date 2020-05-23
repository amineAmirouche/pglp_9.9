package uvsq.pglp_9_9.command;

import uvsq.pglp_9_9.Point;
import uvsq.pglp_9_9.Square;
import uvsq.pglp_9_9.SquareDAO;

public class CreateSquareCommand implements Command {
	String id;
	Point p1;
	Point p2;
	
	public CreateSquareCommand (String id,Point p1,Point p2)
	{
		this.id=id;
		this.p1=p1;
		this.p2=p2;
	}
	
	@Override
	public void execute() throws Exception {
		//String url="jdbc:derby:Bdpglp;";
		String url="jdbc:derby:Bdpglp";
		//String url="jdbc:derby://localhost:1527/Bdpglp";
		Square square=new Square(this.id,this.p1,this.p2);
		SquareDAO squaredao=new SquareDAO(url);
		squaredao.saveSquare(square);
		squaredao.AfficheThisSquare(square);
	}
	

}
