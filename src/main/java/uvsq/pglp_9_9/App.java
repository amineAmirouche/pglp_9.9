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
    	String url="jdbc:derby:MaBdFin;create=true";
    	 Point p1=new Point(1,2);
         Point p2=new Point (3,4);
         Point decalage=new Point (2,2);
         
         Square c1=new Square(4,p1,p2);
        SquareDAO carre=new SquareDAO(url);
        carre.saveSquare(c1);
        //carre.AfficheSquares();
        carre.AfficheSquares();
       // c1.move(decalage);
        
    	
    	
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
