package uvsq.pglp_9_9;

import java.util.Scanner;

import uvsq.pglp_9_9.command.Command;
import uvsq.pglp_9_9.dao.CircleDAO;
import uvsq.pglp_9_9.dao.CompositeShapeDAO;
import uvsq.pglp_9_9.dao.SquareDAO;
import uvsq.pglp_9_9.dao.TriangleDAO;

public class DrawingApp {
	
	public static void Manuel()
	{
		System.out.println("********************************MANUEL D'UTILISATION*********************************");
    	System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("Pour créer un carré et le sauvegardé dans la base de données suiviez la syntaxe suivante:");
		System.out.println("idDusquare=Square(xPoint1,yPoint1;xPoint2,yPoint2");
		System.out.println("exemple : square12=Square(0,0;12,12)");
		System.out.println("Vous pouvez déplacer le carré et mettre a jour ses coordonnées dans la bd en tapant:");
		System.out.println("moveSquare(idDusquare,(xDecalage,yDecalage))");
		System.out.println("exemple : moveSquare(square12,(10,10))");
		System.out.println("---------------------------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------------------------");
		System.out.println("------------------------------------------------------------------------------------------");
		System.out.println("Vous Pouvez créer un cercle et le sauvegarder dans la bd en suivant la syntaxe suivante:");
		System.out.println("idDuCercle=Circle((xCentre,yCentre),rayon)");
		System.out.println("exemple : cercle12=Circle((0,0),50)");
		System.out.println("deplacer le cercle : moveCircle(idDuCercle,(xDecalage,yDecalage))");
		System.out.println("exemple :moveCircle(cercle12,(10,10))");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("--------------------------------------------------------------------------------------------");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("Vous pouvez créer un triangle et le sauvegarder dans la bd en suivant la syntaxe suivante :");
		System.out.println("idDuTriangle=Triangle(xPoint1,yPoint1;xPoint2,yPoint2;xPoint3,yPoint3");
		System.out.println("deplacer le triangle : moveTriangle(idDuTriangle(xDecalage,yDecalage))");
		System.out.println("---------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("----------------------------------------------------------------------------------------------");
		System.out.println("Créer un dessin qui englobe differentes formes");
		System.out.println("dessin+numero(idElem1,idElem2,idElem3;typeElem1,typeElem2,typeElem3");
		System.out.println("exemple : dessin12(square12,cercle12,triangle12;Square,Circle,Triangle)");
		System.out.println("le dessin sera automatiquement sauvegardé dans la base de données, ainsi que chaque element dans sa table");
		System.out.println("deplacer le dessin (ce qui signifie deplacer chaque forme du dessin):");
		System.out.println("moveComposite(idDessin,(xDecalage,yDecalage))");
		System.out.println("exemple : moveComposite(dessin12,(10,10))");
		System.out.println("cette ligne deplacera le dessin indiqué et affichera les coordonnées de chaqu'un des elements à partir de la bd");
		System.out.println("Veuillez rentrer votre commande en dessous ");
		System.out.println("************************************************FIN DU MANUEL ******************************************");
		System.out.println("-------------------------------------------------------------------------------------------------------------");
		}
	
	
	public static void run() throws Exception
	{
		System.out.println(" EN TAPANT exit VOUS QUITTEZ LE PROGRAMME");
		 Scanner sc = new Scanner(System.in);
    	DrawingTUI t=new DrawingTUI(sc);
		while (true)
	    	{
	    	Command cf=t.NextCommand();
	    	cf.execute();}
			
		}

	public static void main(String[] args) throws Exception {
		Manuel();
		run();

	}

}
