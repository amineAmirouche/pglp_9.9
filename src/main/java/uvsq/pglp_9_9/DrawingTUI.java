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
		tab=new String[2];
		tab[0]="[A-Z|a-z]+[1-9]*=Circle\\(\\(\\d+,\\d+\\),\\d+\\)";
		tab[1]="move\\([a-z|A-Z]+[1-9]*,\\(\\d+,\\d+\\)\\)";
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
			throw new ErrorSyntaxeException("Erreur de syntaxe");
			
		}
		return cf;
		}
	

public String[] parsingCircle(String s)
{
	
	 String[] arrOfStr = s.split("[=(),]");  
	 return arrOfStr; 

}

public String[] parsingMove(String s)
{
	
	 String[] arrOfStr = s.split("[ ( ) ,]");  
	 return arrOfStr; 

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
	return 3;
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

}
