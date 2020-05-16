package OS1;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

import java.util.List;

public class Service {
	public List<PCB> ReadyList=new LinkedList<PCB>();
	
	public void run() {
		while(true) {
		if(ReadyList.isEmpty()) return;
		display();
		System.out.println();
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
		
	}
	
	private void display() {
		System.out.println("Runnnig:"+ReadyList.get(0).name);
		for(int i=1;i<ReadyList.size();i++) {
			ReadyList.get(i).display();
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
