package uvsq.pglp_9_9;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
/**
 * @author amine
 *
 */
public class AppTest 
{
    /**
     * Test constructeur de Circle
     */
    @Test
    public void TestConstructCircle()
    {
    	Point p1=new Point(1,2);
    	Circle circle=new Circle("c1",p1,50); 
    	assertTrue(circle.getId().equals("c1") && circle.getRayon()==50 && circle.GetCoordcentre().equals(("1.0;2.0")));
    }
    
    /**
     * test de la méthode move du cercle
     */
    @Test
    public void TestMoveCircle()
    {
    	Point p1=new Point(1,2);
    	Point decalage=new Point (10,10);
    	Circle circle=new Circle("c1",p1,50);
    	circle.move(decalage);
    	assertTrue(circle.GetCoordcentre().equals("11.0;12.0"));
    	
    }
    
    /**
     * test du constructeur du square
     */
    @Test
    public void TestConstructSquare()
    {
    	Point p1=new Point(1,2);
    	Point p2=new Point(3,4);
    	Square square=new Square("carre",p1,p2);
    	assertTrue(square.getId().equals("carre") && square.GetCoordp1().equals("1.0;2.0") && square.GetCoordp2().contentEquals("3.0;4.0"));
    	
    }
   /**
 * Test de la méthode move de square
 */
@Test
   public void TestMoveSquare()
   {
	   Point p1=new Point(1,2);
	   Point p2=new Point(3,4);
	   Point decalage=new Point (10,10);
   		Square square=new Square("carre",p1,p2);  
   		square.move(decalage);
   		//System.out.println(square.GetCoordp1() + " p2" + square.GetCoordp2());
   		assertTrue(square.GetCoordp1().equals("11.0;12.0") && square.GetCoordp2().equals("13.0;14.0"));
   }

/**
 * Methode qui test le contructeur de triangle
 */
@Test
	public void TestConstructTriangle()
	{
	Point p1=new Point(1,2);
	 Point p2=new Point(3,4);
	 Point p3=new Point(5,6);
	 Triangle triangle=new Triangle("triangle",p1,p2,p3);
	 assertTrue(triangle.getId().equals("triangle") && triangle.GetCoordp1().equals("1.0;2.0") && triangle.GetCoordp2().equals("3.0;4.0") && triangle.GetCoordp3().equals("5.0;6.0"));
		}

/**
 * Methode qui test le move du triangle
 */
@Test
	public void TestMoveTriangle()
	{
	Point p1=new Point(1,2);
	 Point p2=new Point(3,4);
	 Point p3=new Point(5,6);
	 Point decalage=new Point (10,10);
	 Triangle triangle=new Triangle("triangle",p1,p2,p3);
	 triangle.move(decalage);
	 assertTrue(triangle.GetCoordp1().equals("11.0;12.0") && triangle.GetCoordp2().equals("13.0;14.0") && triangle.GetCoordp3().equals("15.0;16.0"));
	 
	}
  
/**
 * test la methode add pour le composite
 */
@Test
	public void TestAddElementForComposite()
	{
	Point p1=new Point(1,2);
	 Point p2=new Point(3,4);
	 Point p3=new Point(5,6);
	 Triangle triangle=new Triangle("triangle",p1,p2,p3);
	 Point decalage=new Point (10,10);
	 Point centre=new Point(1,2);
	 Circle cercle=new Circle("cercle",centre,50);
	CompositeShape compositeshape=new CompositeShape("2");
	compositeshape.add(cercle);
	compositeshape.add(triangle);
	assertTrue(compositeshape.getList().size()==2 && compositeshape.getList().get(0).getId().equals("cercle") && compositeshape.getList().get(1).getId().equals("triangle"));
	}

/**
 * On test qu'on peut bien ajouter un composite dans un autre composite 
 */
@Test
	public void TestAddCompositeForComposite()
	{
	Point p1=new Point(1,2);
	 Point p2=new Point(3,4);
	 Point p3=new Point(5,6);
	 Triangle triangle=new Triangle("triangle",p1,p2,p3);
	 Point decalage=new Point (10,10);
	 Point centre=new Point(1,2);
	 Point centre2=new Point(1,2);
	 Circle cercle=new Circle("cercle",centre,50);
	 Circle cercle2=new Circle("cercle2",centre2,50);
	CompositeShape compositeshape=new CompositeShape("2");
	CompositeShape compositeshape2=new CompositeShape("3");
	compositeshape.add(cercle);
	compositeshape.add(triangle);
	compositeshape2.add(cercle2);
	compositeshape.add(compositeshape2);
	assertTrue(compositeshape.getList().get(2).type().equals("Composite"));
	}

}
