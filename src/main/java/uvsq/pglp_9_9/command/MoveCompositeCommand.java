package uvsq.pglp_9_9.command;
import java.util.ArrayList;

import uvsq.pglp_9_9.Shape;
import uvsq.pglp_9_9.dao.CompositeShapeDAO;
import uvsq.pglp_9_9.CompositeShape;
import uvsq.pglp_9_9.Point;

/**
 * @author amine
 *
 */
public class MoveCompositeCommand implements Command {
	ArrayList<Shape> myElements;
	String id;
	Point decalage;

public MoveCompositeCommand(String id,Point decalage)
{
	this.id=id;
	this.decalage=decalage;
}

/**
 *Recupération de tout les elements du composite précisé et move de ce dernier
 */
@Override
public void execute() throws Exception {
	String url="jdbc:derby:Bdpglp";
	CompositeShapeDAO compositeshapedao=new CompositeShapeDAO(url);
	CompositeShape compositeshape=compositeshapedao.getObjet(this.id);
	compositeshape.move(this.decalage);
	compositeshapedao.updateComposite(compositeshape);
	compositeshapedao.AfficheThisComposite(this.id);
	compositeshapedao.AfficheCoordonnesComposite(this.id);
	}
}
