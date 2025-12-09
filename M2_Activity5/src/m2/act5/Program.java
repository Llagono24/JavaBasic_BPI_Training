package m2.act5;

public abstract class Program {
	
	private String name;
	private boolean isRunning = false;
	
	public Program() {
		
	}
	
	public Program(String name) {
		this.name = name;
	}
	
	abstract void run();
	abstract void stop();
   
   public void setName(String name) {
	   this.name = name;
   }
   
   public void setIsRunning(boolean isRunning) {
	   this.isRunning = isRunning;
   }
   
   
   public String getName() {
	   return this.name;
   }

   public boolean getIsRunning() {
	   return this.isRunning;
   }
	
	
	
}
