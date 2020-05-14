package OS2;

public class Partition {

	double addr;
	double len;
	boolean isMalloc;
	public Partition(double addr,double len,boolean isMalloc) {
		this.addr=addr;
		this.len=len;
		this.isMalloc=isMalloc;
	}
	
}
