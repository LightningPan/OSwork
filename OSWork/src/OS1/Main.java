package OS1;


import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		PCBCreator pcbCreator=new PCBCreator();
		Service service=new Service();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\nPlease choose number");
			System.out.println("1:creat new process   2:run   3:display all process   4:exit");
			int n=0;
			n=sc.nextInt();			
			switch (n) {
			case 1: {
				System.out.println("\nPlease enter priority and cost time");
				int priority,costTime;
				priority=sc.nextInt();
				costTime=sc.nextInt();
				service.ReadyList.add(pcbCreator.CreatPCB(priority, costTime));
				service.sort();
				break;
			}
			case 2:{
				service.run();
				break;
			}
			case 3:{
				for(PCB pcb : service.ReadyList) {
					pcb.display();
				}
				break;
			}
			case 4:{
				sc.close();
				return;
			}
			default:
				System.out.println("illegal input");
			}
			
			
			
		}

	}

}
