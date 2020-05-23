package uvsq.pglp_9_9;

import java.util.HashMap;

import uvsq.pglp_9_9.command.Command;

public class HistoryManager {
	
	private final HashMap<String, Command> commandMap = new HashMap<>();
	   //private List<Command> history = new ArrayList<Command>();
	   
	   public void register(String commandName, Command command) {
	        commandMap.put(commandName, command);
	   }
	   
	   public void execute(String cmdName) throws Exception {
	      Command command = commandMap.get(cmdName);
	      if (command == null) {
	            throw new IllegalStateException("no command registered for " + cmdName);
	      }
	      //this.history.add(command); // optional 
	      command.execute();        
	   }

}
