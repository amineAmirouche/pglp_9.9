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
				statement.execute();
				statement.close();
				}
				
				continue;
				
			}
			conn.close();
 			
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
				statement.execute();
				statement.close();
				}
				conn.close();
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
			statement.close();
			conn.close();
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
			statement.close();
			conn.close();
			System.out.println("le composite a bien ete supprimé");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public void RenitialiseTable() 
	{
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.PreparedStatement statement=conn.prepareStatement("delete from COMPOSITE");
			statement.execute();
			statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
           resultSet.close();
           statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void AfficheThisComposite(String id)
	{
		
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from COMPOSITE where id='"+id+"'");

           while (resultSet.next()){
               System.out.println("type: "+resultSet.getString("type"));
               System.out.println("reference: "+resultSet.getString("reference"));
               System.out.println("id: "+resultSet.getString("id"));
              
           }
           resultSet.close();
           statement.close();
			conn.close();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void AfficheCoordonnesComposite(String id)
	{
		CircleDAO circledao=new CircleDAO(this.url);
		int i=1;
		TriangleDAO triangledao=new TriangleDAO(this.url);
		SquareDAO squaredao=new SquareDAO(this.url);
		try {
			Connection conn=DriverManager.getConnection(this.url);
			java.sql.Statement statement =conn.createStatement();
           java.sql.ResultSet resultSet = statement.executeQuery("select * from COMPOSITE where id='"+id+"'");

           while (resultSet.next()){
        	   if (resultSet.getString("type").equals("Circle"))
        	   {
        		System.out.println("l'element numero "+ i+" du composite est :");
        		circledao.AfficheThisCircle1(resultSet.getString("reference"));
        		
        	   }
        	  
        	   if (resultSet.getString("type").equals("Triangle"))
        	   {
        		   System.out.println("l'element numero "+ i+" du composite est :");
        		   triangledao.AfficheThisTriangle1(resultSet.getString("reference"));
        		   
        	   }
        	   
        	   if (resultSet.getString("type").equals("Square"))
        	   {
        		   System.out.println("l'element numero "+ i+" du composite est :");
        		   squaredao.AfficheThisSquare1(resultSet.getString("reference"));
        	   }
        	   
              i++; 
              
           }
           resultSet.close();
           statement.close();
			conn.close();
			
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
				resultSet.close();
				statement.close();
				conn.close();
				return true;
			}
			else 
			{	resultSet.close();
				statement.close();
				conn.close();
				return false;}
	        
		} catch (SQLException e) {
			//return false;
			e.printStackTrace();
			return false;
		}
		
	}
	
public CompositeShape getObjet(String id)
{
	CompositeShape compositeshape=new CompositeShape("co");
	CircleDAO circledao=new CircleDAO(this.url);
	TriangleDAO triangledao=new TriangleDAO(this.url);
	SquareDAO squaredao=new SquareDAO(this.url);
	int i=0;
	try {
		Connection conn=DriverManager.getConnection(this.url);
		java.sql.Statement statement =conn.createStatement();
		java.sql.ResultSet resultSet = statement.executeQuery("select * from COMPOSITE where id='"+id+"'");
	while (resultSet.next())
		{
			if(resultSet.getString("type").equals("Circle"))
			{
				compositeshape.add(circledao.getObjet(resultSet.getString("reference")));
			}
			if(resultSet.getString("type").equals("Triangle"))
			{
				compositeshape.add(triangledao.getObjet(resultSet.getString("reference")));
			}
			if(resultSet.getString("type").equals("Square"))
			{
				compositeshape.add(squaredao.getObjet(resultSet.getString("reference")));
			}
		
		}
	resultSet.close();
    statement.close();
    conn.close();
		return compositeshape; 
		
	} catch (SQLException e) {
		return compositeshape;
		}


}
	

}
