package uvsq.pglp_9_9;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "je suis le programme main du 9.9" );
        Point p1=new Point(1,2);
        Point p2=new Point (3,4);
        Point centre=new Point (0,0);
        Point centre1=new Point (10,0);
        Square c1=new Square(p1,p2);
        Circle circle1=new Circle(centre,30);
        Circle circle2=new Circle (centre1,50);
        
        CompositeShape groupe1=new CompositeShape();
        CompositeShape groupe2=new CompositeShape();
        
        groupe1.add(c1);
        
        groupe2.add(circle2);
       groupe2.add(circle1);
       
       groupe1.add(groupe2);
       
       groupe1.draw();
    }
}
