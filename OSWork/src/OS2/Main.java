//��һ��
package OS2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Memory memory=new Memory();
		Scanner sc=new Scanner(System.in);
		while(true) {
			System.out.println("\n��ѡ�����");
			System.out.println("1:����   2:����   3:��ʾ   4:�˳�");
			int n=0;
			n=sc.nextInt();
			switch(n) {
			case 1:{
				System.out.println("�����������С");
				double temp=sc.nextDouble();
				memory.malloc(temp);
				break;
			}
			case 2:{
				System.out.println("������Ҫ���յķ�����");
				int temp=sc.nextInt();
				if(temp>=memory.mallocedList.size()) {
					System.out.println("��������");
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
