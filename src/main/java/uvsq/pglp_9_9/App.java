package uvsq.pglp_9_9;
import java.sql.*;
import java.beans.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	 /*String url="jdbc:derby:Bdpglp";
    	  try {
              Connection con = DriverManager.getConnection(url);
              java.sql.Statement statement =con.createStatement();

              statement.execute("CREATE TABLE TRIANGLE ( id VARCHAR(10), point1 VARCHAR(10),point2 VARCHAR(10),point3 VARCHAR(10))");
              statement.execute("CREATE TABLE CIRCLE ( id VARCHAR(10), centre VARCHAR(10),rayon INT)");
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
    	String url="jdbc:derby:Bdpglp";
    	 Point p1=new Point(1,2);
         Point p2=new Point (3,4);
         Point p3=new Point (5,6);
         
         Point decalage=new Point (2,2);
         String cc1="cercle6";
         //Square c1=new Square(cc1,p1,p2);
        
         Triangle t=new Triangle("tri",p1,p2,p3);
         
         TriangleDAO tri=new TriangleDAO(url);
         tri.saveTriangle(t);
         tri.AfficheTriangles();
         t.move(decalage);
         tri.updateTriangle(t);
         tri.AfficheTriangles();
        
        
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
