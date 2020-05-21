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
    	//String url="jdbc:derby:Bdpglp";
    	/*CompositeShape test15=new CompositeShape("test15");
    	 Point p1=new Point(0,0);
         Point p2=new Point (1,1);
         Point centre=new Point (0,0);
         Point dec=new Point (20,20);
         Point centre1=new Point (10,0);
         Square c1=new Square("carre15",p1,p2);
         Circle circle1=new Circle("circle15",centre,30);
         Circle circle2=new Circle ("circle15",centre1,50);
         test15.add(c1);
         test15.add(circle1);
         test15.add(circle2);
         
         CompositeShapeDAO csd=new CompositeShapeDAO(url);
         csd.saveComposite(test15);
     
          test15.move(dec);
         csd.updateComposite(test15);*/
        /*CircleDAO circledao=new CircleDAO(url);
        circledao.AfficheCercles();*/
    	
    String url="jdbc:derby:Bdpglp";
 
    	Scanner sc = new Scanner(System.in);
    	
    	DrawingTUI t=new DrawingTUI(sc);
    	while (true)
    	{
    	Command cf=t.NextCommand();
    	cf.execute();}
    	/*SquareDAO squaredao=new SquareDAO(url);
    	squaredao.AfficheSquares();*/
    //TriangleDAO triangledao=new TriangleDAO(url);
    //triangledao.AfficheTriangles();
   
    
        
    /*    try {
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
