package OS5;

import java.util.Scanner;


public class Main {

	public static void main(String[] args) {

		Scanner scanner=new Scanner(System.in); 
		System.out.println("������ϵͳ��Դ������:");
		int m=scanner.nextInt();
		AllocSystem sys=new AllocSystem(m);
		System.out.println("��Ϊÿ����Դ�趨��ʼ��������Դ��:");
		for(int i=0;i<m;i++) {
			sys.available[i]=scanner.nextInt();			
		}
		while(true) {
			int status=0;
			System.out.println("��ѡ��:");
			System.out.println("1:��ӽ���"+"  2:������Դ"+"  3:��ʾ"+"  4:��ȫ�Լ��"+"  5:�˳�");
			status=scanner.nextInt();
			switch(status){
				case 1:{
					System.out.println("�������������:");
					Process process=new Process(m);
					for(int i=0;i<m;i++) {
						process.Max[i]=scanner.nextInt();
					}
					System.out.println("�������ѷ���:");
					for(int i=0;i<m;i++) {
						process.Allocation[i]=scanner.nextInt();
						process.Need[i]=process.Max[i]-process.Allocation[i];
					}
					sys.process.add(process);
					break;
				}
				case 2:{
					System.out.println("������������Դ�Ľ��̺ż�ÿ����Դ��������");
					int request[]=new int[m];
					int num=scanner.nextInt();
					for(int i=0;i<m;i++) {
						request[i]=scanner.nextInt();
					}
					if(num>sys.process.size()) {
						System.out.println("û�������Ľ���!");
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
						System.out.println("��ȫ");
					}
					else {
						System.out.println("����ȫ");
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
