package uvsq.pglp_9_9.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.iapi.sql.PreparedStatement;
import org.apache.derby.iapi.sql.ResultSet;

import uvsq.pglp_9_9.Point;
import uvsq.pglp_9_9.Square;
import uvsq.pglp_9_9.TupleExistException;

public class SquareDAO {
	
	private String url;
	
	public SquareDAO(String url)
	{
		this.url=url;
	}
	
	public void saveSquare(Square s) throws TupleExistException
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			if (!existTuple(s))
			{
			java.sql.PreparedStatement statement=conn.prepareStatement("insert into SQUARE(id,point1,point2) values(?,?,?)");
			statement.setString(1, s.getId());
			statement.setString(2, s.GetCoordp1());
			statement.setString(3, s.GetCoordp2());
			statement.execute();
			// conn=DriverManager.getConnection("jdbc:derby:;shutdown=true");
			//conn=DriverManager.getConnection("jdbc:derby:Bdpglp;shutdown=true");
			//resultSet.close();
			statement.close();
			conn.close();
			System.out.println(s.getId()+ " a bien été sauvegardé dans la base de donne pglp table Square");
			}
			else 
				{	
					conn.close();
					return;
					//throw new TupleExistException("Vous essayez d'inserer un tuple deja existant");
					}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateSquare(Square s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("update SQUARE Set point1=? , point2=? where id=?");
			statement.setString(1, s.GetCoordp1());
			statement.setString(2, s.GetCoordp2());
			statement.setString(3, s.getId());
			statement.execute();
			statement.close();
			conn.close();
			 //conn=DriverManager.getConnection("jdbc:derby:;shutdown=true");
			//conn=DriverManager.getConnection("jdbc:derby:Bdpglp;shutdown=true");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void AfficheSquares()
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from SQUARE");

           while (resultSet.next()){
               System.out.println("id: "+resultSet.getString("id"));
               System.out.println("point1: "+resultSet.getString("point1"));
               System.out.println("point2: "+resultSet.getString("point2"));
           }
           resultSet.close();
           statement.close();
           conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AfficheThisSquare(Square s)
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from SQUARE where id='"+s.getId()+"'");

           while (resultSet.next()){
        	   System.out.println("affichage du tuple depuis la BD Square");
               System.out.println("id: "+resultSet.getString("id"));
               System.out.println("point1: "+resultSet.getString("point1"));
               System.out.println("point2: "+resultSet.getString("point2"));
               
           }
           resultSet.close();
           statement.close();
           conn.close();
           //conn=DriverManager.getConnection("jdbc:derby:;shutdown=true");
           //conn=DriverManager.getConnection("jdbc:derby:Bdpglp;shutdown=true");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AfficheThisSquare1(String s)
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from SQUARE where id='"+s+"'");

           while (resultSet.next()){
        	   System.out.println("affichage du tuple depuis la BD Square");
               System.out.println("id: "+resultSet.getString("id"));
               System.out.println("point1: "+resultSet.getString("point1"));
               System.out.println("point2: "+resultSet.getString("point2"));
               
           }
           resultSet.close();
           statement.close();
           conn.close();
           //conn=DriverManager.getConnection("jdbc:derby:;shutdown=true");
           //conn=DriverManager.getConnection("jdbc:derby:Bdpglp;shutdown=true");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public boolean existTuple(Square s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM SQUARE where id='"+s.getId()+"'");
	          
			if(resultSet.next() && resultSet.getString("id")!=null )
			{	
				resultSet.close();
		           statement.close();
		           conn.close();
				//System.out.println("Insertion echoué dans la table Square "+s.getId() + "existe deja dans la bd");
				return true;
			}
			else {
				resultSet.close();
		           statement.close();
		           conn.close();
				return false;}
	        
		} catch (SQLException e) {
			//return false;
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	public boolean existTuple1(String s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM SQUARE where id='"+s+"'");
	          
			if(resultSet.next() && resultSet.getString("id")!=null )
			{
				resultSet.close();
		           statement.close();
		           conn.close();
				return true;
			}
			else {
				resultSet.close();
		           statement.close();
		           conn.close();
				return false;}
	        
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public void RenitialiseTable() 
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("delete from SQUARE");
			statement.execute();
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Square getObjet(String id)
	{
		Point g=new Point(0,0);
		Point f=new Point(0,0);
		
		Square square=new Square("c0",g,f);
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("select * from SQUARE where id='"+id+"'");
		while (resultSet.next())
			{
			square.SetId(resultSet.getString("id"));
			String[] arrOfStr1=splitt(resultSet.getString("point1"));
			String[] arrOfStr2=splitt(resultSet.getString("point2"));
			square.Setp1(Float.parseFloat(arrOfStr1[0]), Float.parseFloat(arrOfStr1[1]));
			square.Setp2(Float.parseFloat(arrOfStr2[0]), Float.parseFloat(arrOfStr2[1]));
			}
		resultSet.close();
        statement.close();
        conn.close();
			return square; 
			
		} catch (SQLException e) {
			return square;
			}
		
	}
	
	public String[] splitt(String s)
	{
		 String[] arrOfStr = s.split(";", 2); 
		 return arrOfStr;
		
	}
	
	
	
}
