//第一题
package OS2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Memory memory=new Memory();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n请选择号码");
			System.out.println("1:申请   2:回收   3:显示   4:退出");
			int n=0;
			n=sc.nextInt();
			switch(n) {
			case 1:{
				System.out.println("请输入申请大小");
				double temp=sc.nextDouble();
				memory.malloc(temp);
				break;
			}
			case 2:{
				System.out.println("请输入要回收的分区号");
				int temp=sc.nextInt();
				if(temp>=memory.mallocedList.size()) {
					System.out.println("输入有误");
					break;
				}
				memory.unMalloc(temp-1);
				break;
			}
			case 3:{
				memory.display();
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
