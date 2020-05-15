package OS5;



public class Process implements Cloneable {
	public int Allocation[];
	public int Max[];
	public int Need[];
	public Process(int m) {
		Allocation=new int[m];
		Max=new int[m];
		Need=new int[m];
	}
	public Object clone() {
		Process a=null;
		try {
			a=(Process)super.clone();
		}catch(CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return a;
		
		
	}
	
}
