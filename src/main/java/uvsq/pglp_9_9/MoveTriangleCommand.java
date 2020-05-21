package uvsq.pglp_9_9;

public class MoveTriangleCommand implements Command {
	String id;
	Point decalage;
	
	public MoveTriangleCommand(String id,Point decalage)
	{
		this.id=id;
		this.decalage=decalage;
	}
	@Override
	public void execute() throws Exception {
			String url="jdbc:derby:Bdpglp";
			TriangleDAO triangledao=new TriangleDAO(url);
			
			try {
				if (triangledao.existTuple1(this.id))
				{
					Triangle triangle=triangledao.getObjet(this.id);
					triangle.move(this.decalage);
					triangledao.updateTriangle(triangle);
					 }
				
				else throw new TupleNotExistException(this.id + "que vous voulez deplacer n'existe pas dans la bd");
			} catch (TupleNotExistException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
		
	

}
