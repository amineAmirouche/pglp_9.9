package uvsq.pglp_9_9.command;

import uvsq.pglp_9_9.Point;
import uvsq.pglp_9_9.Square;
import uvsq.pglp_9_9.dao.SquareDAO;

/**
 * @author amine
 *
 */
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
	
	/**
	 *methode execute qui crée le square et l'insert dans la bd
	 */
	@Override
	public void execute() throws Exception {
		String url="jdbc:derby:Bdpglp";
		Square square=new Square(this.id,this.p1,this.p2);
		SquareDAO squaredao=new SquareDAO(url);
		squaredao.saveSquare(square);
		squaredao.AfficheThisSquare(square);
	}
	

}
