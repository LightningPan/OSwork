package OS1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import java.util.List;

public class Service {
	public List<PCB> ReadyList=new LinkedList<PCB>();
	
	public void run() {
		if(ReadyList.isEmpty()) return;
		ReadyList.get(0).priority--;
		ReadyList.get(0).costTime--;
		if(ReadyList.get(0).costTime==0) {
			ReadyList.get(0).isReady=false;
			ReadyList.remove(0);
		}
		else {
			sort();
		}
		
	}
	
	public void sort() {
		
		Collections.sort(ReadyList, new Comparator<PCB>() {
			public int compare(PCB a, PCB b) {
				return -(a.priority-b.priority);
			}
		});
		
		
	}
	
	
}
