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
			System.out.println("分配成功！");
			System.out.println("分配的物理地址为：");
			for(int i=0;i<map.i;i++) {
				for(int j=0;j<map.j;j++){
					if(len<=0)break;
					if(map.map[i][j]==0) {
						map.map[i][j]=1;
						System.out.println("柱面号:"+i+"  磁道号:"+j/4+"  物理记录号:"+j%4);
						len--;
					}
				}
			}
			
			
		}
		else {
			System.out.println("分配失败！");
		}
		display();
		
	}
	public void unmalloc(int x,int y,int z) {
		int i=x;		//字节号
		int j=y*4+z;	//位号
		if(i>=map.i || j>=map.j) {
			System.out.println("物理地址有误！");
			return;
		}
		map.map[i][j]=0;
		System.out.println("回收成功！");
		System.out.println("回收字节号为:"+i+"  回收的位号为:"+j);
		display();
	}
	public void display() {
		
		System.out.println("位示图");
		for(int i=0;i<map.i;i++) {
			for(int j=0;j<map.j;j++) {
				System.out.print(map.map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
}
