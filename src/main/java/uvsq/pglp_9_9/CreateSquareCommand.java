package uvsq.pglp_9_9;

public class CreateSquareCommand implements Command {
	String id;
	Point p1;
	Point p2;
	
	public CreateSquareCommand (String id,Point p1,Point p2)
	{
		this.id=id;
		this.p1=p1;
		this.p2=p2;
	}
	
	@Override
	public void execute() throws Exception {
		//String url="jdbc:derby:Bdpglp;";
		String url="jdbc:derby:Bdpglp";
		Square square=new Square(this.id,this.p1,this.p2);
		SquareDAO squaredao=new SquareDAO(url);
		squaredao.saveSquare(square);
		squaredao.AfficheThisSquare(square);
	}
	

}
