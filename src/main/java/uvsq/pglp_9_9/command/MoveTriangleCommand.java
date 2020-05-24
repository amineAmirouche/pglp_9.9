package uvsq.pglp_9_9.command;

import uvsq.pglp_9_9.Point;
import uvsq.pglp_9_9.Triangle;
import uvsq.pglp_9_9.TupleNotExistException;
import uvsq.pglp_9_9.dao.TriangleDAO;

/**
 * @author amine
 *
 */
public class MoveTriangleCommand implements Command {
	String id;
	Point decalage;
	
	public MoveTriangleCommand(String id,Point decalage)
	{
		this.id=id;
		this.decalage=decalage;
	}
	/**
	 *Verification dans la bd l'existance du triangle 
	 *deplacer ce triangle si il existe
	 *mettre a jour ces coordonnées dans la bd
	 */
	@Override
	public void execute() throws Exception {
			String url="jdbc:derby:Bdpglp";
			TriangleDAO triangledao=new TriangleDAO(url);
		try {
				if (triangledao.existTuple1(this.id))
				{
					Triangle triangle=triangledao.getObjet(this.id);
					triangle.move(this.decalage);
					triangledao.updateTriangle(triangle);
					triangledao.AfficheThisTriangle(triangle);
					 }
				else throw new TupleNotExistException(this.id + "que vous voulez deplacer n'existe pas dans la bd");
			}
			catch (TupleNotExistException e) {
				e.printStackTrace();
			}
			
	}
		
	

}
