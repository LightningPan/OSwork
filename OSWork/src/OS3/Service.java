package OS3;

import java.util.Scanner;

public class Service {
	Map map;
	public Service(int x,int y,int z) {
		map=new Map(x, y, z);
	}
	
	public void malloc(int len) {
		int free=0;
		for(int i=0;i<map.i;i++) {
			for(int j=0;j<map.j;j++) {
				free++;
			}	
		}
		if(len<=free) {
			System.out.println("����ɹ���");
			System.out.println("����������ַΪ��");
			for(int i=0;i<map.i;i++) {
				for(int j=0;j<map.j;j++){
					if(len<=0)break;
					if(map.map[i][j]==0) {
						map.map[i][j]=1;
						System.out.println("�����:"+i+"  �ŵ���:"+j/4+"  �����¼��:"+j%4);
						len--;
					}
				}
			}
			
			
		}
		else {
			System.out.println("����ʧ�ܣ�");
		}
		display();
		
	}
	public void unmalloc(int x,int y,int z) {
		int i=x;		//�ֽں�
		int j=y*4+z;	//λ��
		if(i>=map.i || j>=map.j) {
			System.out.println("�����ַ����");
			return;
		}
		map.map[i][j]=0;
		System.out.println("���ճɹ���");
		System.out.println("�����ֽں�Ϊ:"+i+"  ���յ�λ��Ϊ:"+j);
		display();
	}
	public void display() {
		
		System.out.println("λʾͼ");
		for(int i=0;i<map.i;i++) {
			for(int j=0;j<map.j;j++) {
				System.out.print(map.map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
