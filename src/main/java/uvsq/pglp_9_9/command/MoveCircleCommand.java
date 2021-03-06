package uvsq.pglp_9_9.command;

import uvsq.pglp_9_9.Circle;
import uvsq.pglp_9_9.Point;
import uvsq.pglp_9_9.TupleNotExistException;
import uvsq.pglp_9_9.dao.CircleDAO;

/**
 * @author amine
 *
 */
public class MoveCircleCommand implements Command {
	String id;
	Point decalage;
	
	public MoveCircleCommand(String id,Point d)
	{
		this.id=id;
		this.decalage=d;
		
	}

	/**
	 *methode execute qui move un cercle existant : 
	 *récuperation de l'objet cercle depuis la bd , le move puis
	 *mettre a jour ces coordonnée dans la bd
	 */
	@Override
	public void execute() throws Exception {
		String url="jdbc:derby:Bdpglp";
		CircleDAO circledao=new CircleDAO(url);
		try {
			if (circledao.existTuple1(this.id))
			{
				Circle cercle=circledao.getObjet(this.id);
				cercle.move(this.decalage);
				circledao.updateCircle(cercle);
				circledao.AfficheThisCircle1(this.id);
				}
			
			else throw new TupleNotExistException(this.id + "que vous voulez deplacer n'existe pas dans la bd");
		} catch (TupleNotExistException e) {
			e.printStackTrace();
		}
		
		}

	
}


