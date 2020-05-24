package uvsq.pglp_9_9.command;

import uvsq.pglp_9_9.Circle;
import uvsq.pglp_9_9.Point;
import uvsq.pglp_9_9.dao.CircleDAO;

public class CreateCircleCommand implements Command{

	String id;
	Point centre;
	int rayon;
	
	
	/**
	 * @param id= identifiant du cercle
	 * @param c=centre du cercle
	 * @param r=rayon du cercle
	 */
	public CreateCircleCommand(String id,Point c,int r)
	{
		this.id=id;
		this.centre=c;
		this.rayon=r;
	}
	/**methode qui cree le cercle demandé par l'utilisateur et qui le sauvegarde dans la bd dans
	 * dans la table CIRCLE
	 *
	 */
	@Override
	public void execute() {
		String url="jdbc:derby:Bdpglp";
		Circle c1=new Circle(id,centre,rayon);
		CircleDAO circle=new CircleDAO(url);
		circle.saveCircle(c1);
		System.out.println("le cercle a bien ete sauvegardé");
		circle.AfficheThisCircle(c1);
		
	}

}


