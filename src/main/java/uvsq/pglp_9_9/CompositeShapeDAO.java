package uvsq.pglp_9_9;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class CompositeShapeDAO {
	String url;
	public CompositeShapeDAO(String url)
	{
		this.url=url;
	}
	
	public void saveComposite(CompositeShape s) throws TupleExistException
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			ArrayList<Shape> list=s.getList();
			for (int i=0;i<list.size();i++)
			{
				if (list.get(i).type()=="Triangle")
				{
					TriangleDAO triangle=new TriangleDAO(this.url);
					triangle.saveTriangle(( Triangle) list.get(i));
				}
				
				if (list.get(i).type()=="Square")
				{
					SquareDAO square=new SquareDAO(this.url);
					square.saveSquare((Square) list.get(i));
				}
				
				if (list.get(i).type()=="Circle")
				{
					CircleDAO circle=new CircleDAO(this.url);
					circle.saveCircle((Circle) list.get(i));
					
				}
				
				if (list.get(i).type()=="Composite")
				{
					saveComposite((CompositeShape) list.get(i));
					
				}
				
				if (!existTuple(list.get(i),s))
				{
				java.sql.PreparedStatement statement=conn.prepareStatement("insert into COMPOSITE(type,reference,id) values(?,?,?)");
				//System.out.println("type:"+list.get(i).type() + "reference : "+ list.get(i).getId() + "id : "+ s.getId());
				statement.setString(1, list.get(i).type());
				statement.setString(2, list.get(i).getId());
				statement.setString(3, s.getId());
				statement.execute();}
				continue;
				
			}
 			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void updateComposite(CompositeShape s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			ArrayList<Shape> list=s.getList();
			for (int i=0;i<list.size();i++)
			{
				if (list.get(i).type()=="Triangle")
				{
					TriangleDAO triangle=new TriangleDAO(this.url);
					triangle.updateTriangle(( Triangle) list.get(i));
				}
				
				if (list.get(i).type()=="Square")
				{
					SquareDAO square=new SquareDAO(this.url);
					square.updateSquare((Square) list.get(i));
				}
				
				if (list.get(i).type()=="Circle")
				{
					CircleDAO circle=new CircleDAO(this.url);
					circle.updateCircle((Circle) list.get(i));
					
				}
				
				if (list.get(i).type()=="Composite")
				{
					updateComposite((CompositeShape) list.get(i));
					
				}
				
				if (!existTuple(list.get(i),s))
				{
				java.sql.PreparedStatement statement=conn.prepareStatement("update COMPOSITE Set type=? , reference=? where id=?");
				//System.out.println("type:"+list.get(i).type() + "reference : "+ list.get(i).getId() + "id : "+ s.getId());
				statement.setString(1, list.get(i).type());
				statement.setString(2, list.get(i).getId());
				statement.setString(3, s.getId());
				statement.execute();}
				continue;
				
			}
 			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public void removeComposite(CompositeShape s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("delete from COMPOSITE WHERE id=?");
			statement.setString(1, s.getId());
			statement.execute();
			System.out.println("le composite a bien ete supprimé");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public void removeComposite1(String s)
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("delete from COMPOSITE WHERE id=?");
			statement.setString(1, s);
			statement.execute();
			System.out.println("le composite a bien ete supprimé");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public void AfficheComposite()
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from COMPOSITE");

           while (resultSet.next()){
               System.out.println("type: "+resultSet.getString("type"));
               System.out.println("reference: "+resultSet.getString("reference"));
               System.out.println("id: "+resultSet.getString("id"));
              
           }
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean existTuple(Shape shape,CompositeShape composite)
	{
		try {
			
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
			java.sql.ResultSet resultSet = statement.executeQuery("SELECT * FROM COMPOSITE where id='"+composite.getId()+"'"+"AND reference='"+shape.getId()+"'");
	          
			if(resultSet.next() && resultSet.getString("id")!=null )
			{
				System.out.println(shape.getId()+" existe deja dans COMPOSITE");
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
