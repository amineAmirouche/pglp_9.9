package uvsq.pglp_9_9.command;

import uvsq.pglp_9_9.Point;
import uvsq.pglp_9_9.Square;
import uvsq.pglp_9_9.TupleNotExistException;
import uvsq.pglp_9_9.dao.SquareDAO;

/**
 * @author amine
 *
 */
public class MoveSquareCommand implements Command {
	
	String id;
	Point decalage;
	
	public MoveSquareCommand(String id,Point decalage)
	{
		this.id=id;
		this.decalage=decalage;
	}

	/**
	 *Récuparation des coordonnées du square depuis la bd
	 *move ce triangle et mettre a jour les coordonnées dans la bd
	 *
	 */
	@Override
	public void execute() throws Exception {
		String url="jdbc:derby:Bdpglp";
		SquareDAO squaredao=new SquareDAO(url);
		try {
			if (squaredao.existTuple1(this.id))
			{
				Square square=squaredao.getObjet(this.id);
				square.move(this.decalage);
				squaredao.updateSquare(square);
				squaredao.AfficheThisSquare(square);
			}
				else throw new TupleNotExistException(this.id + "que vous voulez deplacer n'existe pas dans la table");
			} 
		catch (TupleNotExistException e) {
			e.printStackTrace();
		}
	}

}
