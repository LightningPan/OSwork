package OS3;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		System.out.println("���������������ŵ�����ÿ�ŵ���Ϊ�����¼��:");
		Scanner sc=new Scanner(System.in);
		int x=sc.nextInt();
		int y=sc.nextInt();
		int z=sc.nextInt();
		Service service=new Service(x,y,z);
		while(true) {
			int temp=0;
			System.out.println("\n��ѡ�����");
			System.out.println("1:����   2:����   3:��ʾ   4:�˳�");
			int n=0;
			n=sc.nextInt();
			switch(n) {
			case 1:{
				System.out.println("�������С");
				int input=sc.nextInt();
				service.malloc(input);
				break;
			}
			case 2:{
				System.out.println("�����������ַ������ţ��ŵ��ţ������¼�ţ�");
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
