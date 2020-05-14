package OS1;

public class PCBCreator {
	public static int name=1;
	public PCB CreatPCB(int priority,int time) {
		return new PCB("p"+String.valueOf(name++),time,priority,true);
	}
}
