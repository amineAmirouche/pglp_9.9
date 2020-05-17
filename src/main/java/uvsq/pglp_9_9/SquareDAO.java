package uvsq.pglp_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.derby.iapi.sql.PreparedStatement;
import org.apache.derby.iapi.sql.ResultSet;

public class SquareDAO {
	
	private String url;
	
	public SquareDAO(String url)
	{
		this.url=url;
	}
	
	public void saveSquare(Square s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			if (!existTuple(s))
			{
			java.sql.PreparedStatement statement=conn.prepareStatement("insert into SQUARE(id,point1,point2) values(?,?,?)");
			statement.setString(1, s.getId());
			statement.setString(2, s.GetCoordp1());
			statement.setString(3, s.GetCoordp2());
			statement.execute();}
			return;
			
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
				System.out.println("lid du carre"+resultSet.getString("id"));
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
