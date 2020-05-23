package uvsq.pglp_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class CircleDAO {
	
private String url;
	
	public CircleDAO(String url)
	{
		this.url=url;
	}
	
	public void saveCircle(Circle s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			if (!existTuple(s))
			{
			java.sql.PreparedStatement statement=conn.prepareStatement("insert into CIRCLE(id,centre,rayon) values(?,?,?)");
			statement.setString(1, s.getId());
			statement.setString(2, s.GetCoordcentre());
			statement.setInt(3, s.getRayon());
			
			statement.execute();
			statement.close();
			
			}
			
			conn.close();
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateCircle(Circle s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("update CIRCLE Set centre=? , rayon=? where id=?");
			statement.setString(1, s.GetCoordcentre());
			statement.setInt(2, s.getRayon());
			statement.setString(3, s.getId());
			statement.execute();
			statement.close();
			conn.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void AfficheCercles()
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from CIRCLE");

           while (resultSet.next()){
               System.out.println("id: "+resultSet.getString("id"));
               System.out.println("centre: "+resultSet.getString("centre"));
               System.out.println("rayon: "+resultSet.getInt("rayon"));
               
           }
           resultSet.close();
           statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean existTuple(Circle s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM CIRCLE where id='"+s.getId()+"'");
	          
			if(resultSet.next() && resultSet.getString("id")!=null )
			{
				resultSet.close();
				statement.close();
				conn.close();
				System.out.println("Insertion echoué dans la table Circle "+s.getId() + "existe deja dans la bd");
				return true;
			}
			else 
				{
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
	
	public void RenitialiseTable() 
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("delete from CIRCLE");
			statement.execute();
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public Circle getObjet(String id)
	{
		System.out.println("l id du debut est"+ id);
		Point g=new Point(0,0);
		Circle circle =new Circle("c0",g,0);
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("select * from CIRCLE where id='"+id+"'");
			
			while (resultSet.next())
			{
			circle.SetId(resultSet.getString("id"));
			String[] arrOfStr=splitt(resultSet.getString("centre"));
			circle.SetCentre(Float.parseFloat(arrOfStr[0]), Float.parseFloat(arrOfStr[1]));
			circle.SetRayon(resultSet.getInt("rayon"));}
			resultSet.close();
			statement.close();
			conn.close();
			return circle; 
			
		} catch (SQLException e) {
			return circle;
			//e.printStackTrace();
		}
		
		
	}
	
	public String[] splitt(String s)
	{
		 String[] arrOfStr = s.split(";", 2); 
		 return arrOfStr;
		
	}
	
	public void AfficheThisCircle(Circle s)
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from CIRCLE where id='"+s.getId()+"'");

           while (resultSet.next()){
        	   System.out.println("affichage du tuple depuis la BD Square");
               System.out.println("id: "+resultSet.getString("id"));
               System.out.println("centre: "+resultSet.getString("centre"));
               System.out.println("rayon: "+resultSet.getInt("rayon"));
               
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
	
	public void AfficheThisCircle1(String s)
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from CIRCLE where id='"+s+"'");

           while (resultSet.next()){
        	   System.out.println("affichage du tuple depuis la BD Circle");
               System.out.println("id: "+resultSet.getString("id"));
               System.out.println("centre: "+resultSet.getString("centre"));
               System.out.println("rayon: "+resultSet.getInt("rayon"));
               
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
	 
	
	
	
	
	public boolean existTuple1(String s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM CIRCLE where id='"+s+"'");
	          
			if(resultSet.next() && resultSet.getString("id")!=null )
			{
				resultSet.close();
				statement.close();
				conn.close();
				//System.out.println("Insertion echoué dans la table Circle "+s+ "existe deja dans la bd");
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

}
