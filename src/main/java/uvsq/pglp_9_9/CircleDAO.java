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
			
			statement.execute();}
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
               System.out.println("point1: "+resultSet.getString("centre"));
               System.out.println("point2: "+resultSet.getInt("rayon"));
               
           }
			
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
				System.out.println("lid du CERCLE"+resultSet.getString("id"));
				return true;
			}
			else return false;
	        
		} catch (SQLException e) {
			//return false;
			e.printStackTrace();
			return false;
		}
		
	}
	

}
