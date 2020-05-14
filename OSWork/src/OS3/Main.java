package OS3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("请输入柱面数，磁道数，每磁道分为物理记录数:");
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int z=sc.nextInt();
		Service service=new Service(x,y,z);
		while(true) {
			int temp=0;
			System.out.println("\n请选择号码");
			System.out.println("1:申请   2:回收   3:显示   4:退出");
			int n=0;
			n=sc.nextInt();
			switch(n) {
			case 1:{
				System.out.println("请输入大小");
				int input=sc.nextInt();
				service.malloc(input);
				break;
			}
			case 2:{
				System.out.println("请输入物理地址（柱面号，磁道号，物理记录号）");
				int input1=sc.nextInt();
				int input2=sc.nextInt();
				int input3=sc.nextInt();
				service.unmalloc(input1,input2,input3);
				break;
			}
			case 3:{
				service.display();
				break;
			}
			case 4:{
				sc.close();
				return;
			}
			}
			
		}
	}

}
