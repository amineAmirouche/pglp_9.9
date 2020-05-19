package uvsq.pglp_9_9;
import java.sql.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws Exception
    {
    	/* String url="jdbc:derby:Bdpglp:create=true";
    	  try {
              Connection con = DriverManager.getConnection(url);
              java.sql.Statement statement =con.createStatement();
				statement.execute("CREATE TABLE COMPOSITE (type VARCHAR(10),reference VARCHAR(10), id VARCHAR(10))");
              //statement.execute("CREATE TABLE TRIANGLE ( id VARCHAR(10), point1 VARCHAR(10),point2 VARCHAR(10),point3 VARCHAR(10))");
             // statement.execute("CREATE TABLE CIRCLE ( id VARCHAR(10), centre VARCHAR(10),rayon INT)");
             //statement.execute("insert into SQUARE(point1,point2) values ('3;7' , '4;8')");
             ResultSet resultSet = statement.executeQuery("select * from SQUARE");

             while (resultSet.next()){
                 System.out.println("id: "+resultSet.getString("id"));
                 System.out.println("nom: "+resultSet.getString("point1"));
                 System.out.println("nom: "+resultSet.getString("point2"));
             }
              	
              
          } catch (SQLException e) {
              e.printStackTrace();
          }*/
    	
    	
    	Scanner in=new Scanner(System.in);
    	DrawingTUI t=new DrawingTUI(in);
    	Command cf=t.NextCommand();
    	cf.execute();
    	String url="jdbc:derby:Bdpglp";
    	CircleDAO circle=new CircleDAO(url);
    	circle.AfficheCercles();
    	
    	
    	/*String url="jdbc:derby:Bdpglp";
    	 Point p1=new Point(1,2);
         Point p2=new Point (3,4);
         Point p3=new Point (5,6);
         CircleDAO circledao=new CircleDAO(url);
        
         Command cf= new CreateCircleCommand("Cercle40",p1,10);
         cf.execute();
         circledao.AfficheCercles();
         
        Command cf1=new MoveCircleCommand("Cercle40",p2);
        
    	cf1.execute();
    	System.out.println(" apres le mouv ....");
        System.out.println(" .....................");
        circledao.AfficheCercles();*/
    	/*String url="jdbc:derby:Bdpglp";
    	 Point p1=new Point(1,2);
         Point p2=new Point (3,4);
         Point p3=new Point (5,6);
        Point p4=new Point (7,2);
         Point p5=new Point (4,2);
         Point p6=new Point (4,1);
         Point p7=new Point (4,1);
         Point decalage=new Point (2,2);
         String cc1="carre1";
         Square carre=new Square(cc1,p1,p2);
        
         Triangle triangle=new Triangle("triangle1",p3,p4,p5);
        
        Circle cercle2=new Circle("cercle2",p7,50);
         Circle cercle=new Circle("cercle1",p6,50);
         
         CompositeShape compose=new CompositeShape("Composite1");
         compose.add(cercle);
         compose.add(triangle);
         compose.add(carre);
         
         CompositeShape compose2=new CompositeShape("composite2");
         compose2.add(cercle2);
         
         compose.add(compose2);*/
         
         //compose.draw();
        /* compose.draw();
         System.out.println("je deplace le composite ... ");
         compose.move(decalage);
         compose.draw();*/
         //CompositeShapeDAO compositeDAO=new CompositeShapeDAO(url);
        //compositeDAO.saveComposite(compose);
         //compositeDAO.removeComposite(compose);
         
         //compositeDAO.AfficheComposite();
        
        //carre.AfficheSquares();
       // carre.AfficheSquares();
       // c1.move(decalage);*/
        
    	
    	
    	/* String url="jdbc:derby:MaBd;create=true";
        
        
        try {
            Connection con = DriverManager.getConnection(url);
            java.sql.Statement statement =con.createStatement();

            //statement.execute("CREATE TABLE SQUARE ( id INT GENERATED ALWAYS AS IDENTITY not null primary key, point1 VARCHAR(10),point2 VARCHAR(10))");
           statement.execute("insert into SQUARE(point1,point2) values ('3;7' , '4;8')");
           ResultSet resultSet = statement.executeQuery("select * from SQUARE");

           while (resultSet.next()){
               System.out.println("id: "+resultSet.getInt("id"));
               System.out.println("nom: "+resultSet.getString("point1"));
               System.out.println("nom: "+resultSet.getString("point2"));
           }
            	
            
        } catch (SQLException e) {
            e.printStackTrace();
        }*/
    
       /* System.out.println( "je suis le programme main du 9.9" );
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
       
       groupe1.draw();*/
    	
    	
    	
    	
    }
}
