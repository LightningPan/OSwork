package OS1;

public class PCB {
	public String name;
	public int costTime;
	public int priority;
	public boolean isReady;
	public PCB(String name,int costTime,int priority,boolean isReady) {
		this.name=name;
		this.costTime=costTime;
		this.priority=priority;
		this.isReady=isReady;
	}
	public void display() {
		System.out.println("\nProcess Name: "+name+" Time: "+costTime+" Priority "+priority);
		
	}
	
}
