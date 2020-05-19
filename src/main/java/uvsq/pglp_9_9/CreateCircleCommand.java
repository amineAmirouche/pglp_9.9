package uvsq.pglp_9_9;

public class CreateCircleCommand implements Command{

	String id;
	Point centre;
	int rayon;
	
	
	public CreateCircleCommand(String id,Point c,int r)
	{
		this.id=id;
		this.centre=c;
		this.rayon=r;
	}
	@Override
	public void execute() {
		String url="jdbc:derby:Bdpglp";
		Circle c1=new Circle(id,centre,rayon);
		CircleDAO circle=new CircleDAO(url);
		circle.AfficheCercles();
		circle.saveCircle(c1);
		System.out.println("le cercle a bien ete sauvegardé");
		
	}

}


//main: 
// History.Manager h
// while (not exist) { Command cf=DrawingTUI.next()  h.register() h.execute()                              }

//main : 
// c1=circle((0,0),50) le cercle est crée dans la bd et est enregistre dans h.register()( map<c1,Command> 
// move(c2,point) 
// History.manager h while (true ) { command cf=DrawuingTUI.next() h.register() h.execute(nom) )



//classe manager :
// map <string,command> commandMap
// methode register (string, command) { commandMap.put(string,command))}
// methode execute(string) { commandMap(string).execute()                              }

//c1=cercle((0,0),50) elle a retourné createCircleCommand avec id=c1  commandMap(c1,commandC1)
//move(c1,(0,2))   		je cherche si c1 existe dans commandMap si il existe jappel command.execute();

// la commande c soit une CreateCircleCommand qui contient id=c1 centre rayon , soit moveCircleCommand qui contient id =c1 


// c1=cercle(0,0),50) HistoryManager.register(c1,commandC1))
// execute();

// move() historyManager.register
//execute()

//main : DrawingApp
// DrawingApp run ()
// [{ while true ( drawingTUI.next().execute();                                    )
//c1 = Cercle((0, 0), 50)

// return CreateCircleCommand(c1,centre,50)
//dans app: 
//move(c1, (10, 20))
//if parser==move Return MoveCircleCommand(id,decalage);
		// drawingTUI: c1=cercle
		// t1= triangle
/// q=carré
//composite(c1,t1,q)
//