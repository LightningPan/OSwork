package OS5;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in); 
		System.out.println("请输入系统资源种类数:");
		int m=scanner.nextInt();
		AllocSystem sys=new AllocSystem(m);
		System.out.println("请为每类资源设定初始可利用资源量:");
		for(int i=0;i<m;i++) {
			sys.available[i]=scanner.nextInt();			
		}
		while(true) {
			int status=0;
			System.out.println("请选择:");
			System.out.println("1:添加进程"+"  2:申请资源"+"  3:显示"+"  4:安全性检测"+"  5:退出");
			status=scanner.nextInt();
			switch(status){
				case 1:{
					System.out.println("请输入最大需求:");
					Process process=new Process(m);
					for(int i=0;i<m;i++) {
						process.Max[i]=scanner.nextInt();
					}
					System.out.println("请输入已分配:");
					for(int i=0;i<m;i++) {
						process.Allocation[i]=scanner.nextInt();
						process.Need[i]=process.Max[i]-process.Allocation[i];
					}
					sys.process.add(process);
					break;
				}
				case 2:{
					System.out.println("请输入申请资源的进程号及每种资源的申请量");
					int request[]=new int[m];
					int num=scanner.nextInt();
					for(int i=0;i<m;i++) {
						request[i]=scanner.nextInt();
					}
					if(num>sys.process.size()) {
						System.out.println("没有这样的进程!");
						break;
					}
					sys.alloc(num, request);
					break;
					
				}
				case 3:{
					sys.display();
					break;
				}
				case 4:{
					if(sys.CheckSecurity(sys.available, sys.process.get(0).Allocation, sys.process.get(0).Need, 0)) {
						System.out.println("安全");
					}
					else {
						System.out.println("不安全");
					}
					break;
				}
				case 5:{
					scanner.close();
					return;
				}
			}
			
			
		}
	}

}
