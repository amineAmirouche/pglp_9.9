package uvsq.pglp_9_9;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class DrawingTUI {
	Scanner in;
	String tab[];
	
	public DrawingTUI(Scanner i)
	{
		this.in=i;
		tab=new String[7];
		tab[0]="[A-Z|a-z]+[1-9]*=Circle\\(\\(\\d+,\\d+\\),\\d+\\)";
		tab[1]="moveCircle\\([a-z|A-Z]+[1-9]*,\\(\\d+,\\d+\\)\\)";
		tab[2]="dessin\\d+\\(([a-z|A-Z]+[0-9]+\\,)+[a-z|A-Z]+[0-9]+;(Circle,|Triangle,|Square,)+(Circle\\)|Triangle\\)|Square\\))";
		tab[3]="[a-z|A-Z]+\\d+=Triangle\\(\\d+,\\d+;\\d+,\\d+;\\d+,\\d+\\)";
		tab[4]="moveTriangle\\([a-z|A-Z]+[1-9]*,\\(\\d+,\\d+\\)\\)";
		tab[5]="[a-z|A-Z]+\\d+=Square\\(\\d+,\\d+;\\d+,\\d+\\)";
		tab[6]="moveSquare\\([a-z|A-Z]+[1-9]*,\\(\\d+,\\d+\\)\\)";
		
	}
	
	
	public Command NextCommand() throws Exception
	{
		Command cf=null;
		  System.out.print("Enter your name: ");  
		String f=in.nextLine();
		if (f.equals("exit"))
		{
			System.out.println("vous quittez le programme");
			System.exit(0);
		}
		String[] array=parsingCircle(f);
		int situation=checkSituation(f);
		
		if (situation==1)
			
		{
			System.out.println("creation cercle");
			String[] elements=new String[parsingCircle(f).length];
			elements=parsingCircle(f);
			AfficheElements(elements);
			Command cd= new CreateCircleCommand(elements[0],constructPoint(elements[3],elements[4]),Integer.parseInt(elements[6]));
			return cd;
			
		}
		
		else if (situation==2)
		{
			System.out.println("move du cercle");
			String[] elements=new String[parsingMove(f).length];
			elements=parsingMove(f);
			AfficheElements(elements);
			Command cd=new MoveCircleCommand(elements[1],constructPoint(elements[3],elements[4]));
			return cd;
			
		}
		else if (situation==3)
		{
			System.out.println("le composite");
			//AfficheElements(SplitFirstCompositeElem(f));
			//SplitFirstCompositeElem(f);
			System.out.println("le second element");
			//AfficheElements(SplitSecondCompositeElem(f));
			Command cd=new CreateCompositeCommand(IdCompositeElem(f),SplitSecondCompositeElem(f),SplitFirstCompositeElem(f));
			return cd;
		}
		
		else if (situation==4)
		{
			//throw new ErrorSyntaxeException("erreur de Syntaxe");
			System.out.print("je suis le triangle");
			//AfficheElements(parsingTriangle(f));
			String[] myElems=parsingTriangleSquare(f);
			Point p1=ConstructPoint1(myElems[0]);
			Point p2=ConstructPoint1(myElems[1]);
			Point p3=ConstructPoint1(myElems[2]);
			Command cd=new CreateTriangleCommand(idTriangleSquare(f),p1,p2,p3);
			return cd;
		}
		
		else if (situation==5)
		{
			System.out.println("move du Triangle..");
			String[] elements=new String[parsingMove(f).length];
			elements=parsingMove(f);
			Command cd=new MoveTriangleCommand(elements[1],constructPoint(elements[3],elements[4]));
			return cd;
			
		}
		
		else if (situation==6)
		{
			System.out.println("je suis le carré");
			String[] myElems=parsingTriangleSquare(f);
			Point p1=ConstructPoint1(myElems[0]);
			Point p2=ConstructPoint1(myElems[1]);
			Command cd=new CreateSquareCommand(idTriangleSquare(f),p1,p2);
			return cd;
			
		}
		else if (situation==7)
		{
			String[] elements=new String[parsingMove(f).length];
			elements=parsingMove(f);
			Command cd=new MoveSquareCommand(elements[1],constructPoint(elements[3],elements[4]));
			return cd;
		}	
		return cf;
		}
	

public String[] parsingCircle(String s)
{
	
	 String[] arrOfStr = s.split("[=(),]");  
	 return arrOfStr; 

}

public String idTriangleSquare(String s)
{
	
	 String[] arrOfStr = s.split("=");  
	 return arrOfStr[0]; 

}



public String[] parsingTriangleSquare(String s)
{
	String[] arrOfStr=s.split("\\(");
	String f=arrOfStr[1].replace(")", "");
	return (f.split(";"));
}

public String[] parsingMove(String s)
{
	
	 String[] arrOfStr = s.split("[ ( ) ,]");  
	 return arrOfStr; 

}

public String[] SplitFirstCompositeElem(String s)
{
	
	 String[] arrOfStr = s.split(";"); 
	 //AfficheElements(arrOfStr);
	 String [] arrOfStr2=arrOfStr[0].split("\\(");
	 //AfficheElements(arrOfStr2);
	 //AfficheElements(arrOfStr);
	 return (arrOfStr2[1].split(","));

}

public String IdCompositeElem(String s)
{
	
	 String[] arrOfStr = s.split(";"); 
	 //AfficheElements(arrOfStr);
	 String [] arrOfStr2=arrOfStr[0].split("\\(");
	 //AfficheElements(arrOfStr2);
	 //AfficheElements(arrOfStr);
	 return (arrOfStr2[0]);

}

public String[] SplitSecondCompositeElem(String s)
{
	
	 String[] arrOfStr = s.split(";");  
	 String[] arrOfStr2=arrOfStr[1].split("\\)");
	 return (arrOfStr2[0].split(","));

}

public int checkSituation(String s)
{
	Pattern[] pattern=new Pattern[this.tab.length];
	pattern=fill();
	for (int i=0;i<this.tab.length;i++)
	{
		Matcher matcher=pattern[i].matcher(s);
		if (matcher.matches()==true) {return i+1;};
	}
	return this.tab.length+1;
}


public Pattern[] fill()
{
	
	Pattern[] pattern=new Pattern[this.tab.length];
	for (int i=0;i<this.tab.length;i++)
	{
		pattern[i]=Pattern.compile(this.tab[i]);
	}
	return pattern;
	}

public void AfficheElements(String [] tab)
{
	for (int i=0;i<tab.length;i++)
	{
		System.out.println(tab[i]);
	}
}

public Point constructPoint(String first,String second)
{
	float x=Float.parseFloat(first);
	float y=Float.parseFloat(second);
	Point point=new Point(x,y);
	return point;
}


public Point ConstructPoint1(String f)
{
	String[] arrOfStr=f.split(",");
	float x=Float.parseFloat(arrOfStr[0]);
	float y=Float.parseFloat(arrOfStr[1]);
	Point point=new Point(x,y);
	return point;
}

}
