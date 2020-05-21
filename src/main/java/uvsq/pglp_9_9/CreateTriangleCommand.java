package uvsq.pglp_9_9;

public class CreateTriangleCommand implements Command {
	String id;
	Point p1;
	Point p2;
	Point p3;
	
	public CreateTriangleCommand(String id,Point p1,Point p2,Point p3)
	{
		this.id=id;
		this.p1=p1;
		this.p2=p2;
		this.p3=p3;
		
	}
	@Override
	public void execute() throws Exception {
		String url="jdbc:derby:Bdpglp";
		Triangle triangle=new Triangle(this.id,this.p1,this.p2,this.p3);
		TriangleDAO triangledao=new TriangleDAO(url);
		triangledao.saveTriangle(triangle);
		
		System.out.println("le triangle a bien ete sauvegardé dans la bd");
		
	}

}
