package uvsq.pglp_9_9.command;

import uvsq.pglp_9_9.Point;
import uvsq.pglp_9_9.Square;
import uvsq.pglp_9_9.SquareDAO;
import uvsq.pglp_9_9.TupleNotExistException;

public class MoveSquareCommand implements Command {
	String id;
	Point decalage;
	
	public MoveSquareCommand(String id,Point decalage)
	{
		this.id=id;
		this.decalage=decalage;
	}

	@Override
	public void execute() throws Exception {
		
		//String url="jdbc:derby:Bdpglp;shutdown=true";
		String url="jdbc:derby:Bdpglp";
		SquareDAO squaredao=new SquareDAO(url);
		
		
		try {
			if (squaredao.existTuple1(this.id))
			{
				Square square=squaredao.getObjet(this.id);
				
				//square.draw();
				square.move(this.decalage);
				squaredao.updateSquare(square);
				squaredao.AfficheThisSquare(square);
				
				 }
			
			else throw new TupleNotExistException(this.id + "que vous voulez deplacer n'existe pas dans la table");
		} catch (TupleNotExistException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
