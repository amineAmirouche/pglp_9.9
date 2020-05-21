package uvsq.pglp_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TriangleDAO {
private String url;
	
	public TriangleDAO(String url)
	{
		this.url=url;
	}
	
	public void saveTriangle(Triangle s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			if (!existTuple(s))
			{
			java.sql.PreparedStatement statement=conn.prepareStatement("insert into TRIANGLE(id,point1,point2,point3) values(?,?,?,?)");
			statement.setString(1, s.getId());
			statement.setString(2, s.GetCoordp1());
			statement.setString(3, s.GetCoordp2());
			statement.setString(4, s.GetCoordp3());
			statement.execute();}
			return;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateTriangle(Triangle s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("update TRIANGLE Set point1=? , point2=?,point3=? where id=?");
			statement.setString(1, s.GetCoordp1());
			statement.setString(2, s.GetCoordp2());
			statement.setString(3, s.GetCoordp3());
			statement.setString(4, s.getId());
			statement.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	
	public void AfficheTriangles()
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from TRIANGLE");

           while (resultSet.next()){
               System.out.println("id: "+resultSet.getString("id"));
               System.out.println("point1: "+resultSet.getString("point1"));
               System.out.println("point2: "+resultSet.getString("point2"));
               System.out.println("point3: "+resultSet.getString("point3"));
           }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean existTuple(Triangle s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM TRIANGLE where id='"+s.getId()+"'");
	          
			if(resultSet.next() && resultSet.getString("id")!=null )
			{
			
				return true;
			}
			else return false;
	        
		} catch (SQLException e) {
			//return false;
			e.printStackTrace();
			return false;
		}
		
	}
	
	public Triangle getObjet(String id)
	{
		Point g=new Point(0,0);
		Point f=new Point(0,0);
		Point d=new Point(0,0);
		Triangle triangle =new Triangle("t0",d,g,f);
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("select * from TRIANGLE where id='"+id+"'");
		while (resultSet.next())
			{
			triangle.SetId(resultSet.getString("id"));
			String[] arrOfStr1=splitt(resultSet.getString("point1"));
			String[] arrOfStr2=splitt(resultSet.getString("point2"));
			String[] arrOfStr3=splitt(resultSet.getString("point3"));
			triangle.Setp1(Float.parseFloat(arrOfStr1[0]), Float.parseFloat(arrOfStr1[1]));
			triangle.Setp2(Float.parseFloat(arrOfStr2[0]), Float.parseFloat(arrOfStr2[1]));
			triangle.Setp3(Float.parseFloat(arrOfStr3[0]), Float.parseFloat(arrOfStr3[1]));}
			return triangle; 
			
		} catch (SQLException e) {
			return triangle;
			}
		
	}
	
	public String[] splitt(String s)
	{
		 String[] arrOfStr = s.split(";", 2); 
		 return arrOfStr;
		
	}
	
	

	public boolean existTuple1(String s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM TRIANGLE where id='"+s+"'");
	          
			if(resultSet.next() && resultSet.getString("id")!=null )
			{
				return true;
			}
			else return false;
	        
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	
	

}
