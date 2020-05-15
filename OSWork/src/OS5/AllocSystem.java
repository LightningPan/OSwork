package OS5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class AllocSystem {
	public int m; //资源类数
	public List<Process> process=new ArrayList<Process>();
	public int[] available;
	
	public AllocSystem(int m) {
		this.m=m;
		available=new int[m];
	}
	
	
	
	public void display() {
		System.out.println("系统剩余:");
		for(int i=0;i<m;i++) {
			System.out.print("R"+(i+1)+":"+available[i]+"  ");
		}
		System.out.println("\n    Max   Allocation   Need");
		for(int i=0;i<process.size();i++) {
			System.out.print("P"+(i+1));
			for(int j=0;j<m;j++) {
				System.out.print(" "+process.get(i).Max[j]);
			}
			System.out.print("   ");
			for(int j=0;j<m;j++) {
				System.out.print(" "+process.get(i).Allocation[j]);
			}
			System.out.print("    ");
			for(int j=0;j<m;j++) {
				System.out.print(" "+process.get(i).Need[j]);
			}
			System.out.println();
		}
	}
	
	public void alloc(int x,int request[]) {	//Px进程请求
		x--;
		if(!(Array.isLessOrEqual(request, process.get(x).Need))) {
			System.out.println("申请失败");
			return;
		}
		if(!Array.isLessOrEqual(request, available)) {
			System.out.println("申请失败");
			return;
		}
		int availableTemp[]=Array.substractArray(available, request);
		int allocationTemp[]=Array.addArray(process.get(x).Allocation, request);
		int needTemp[]=Array.substractArray(process.get(x).Need, request);
		if(CheckSecurity(availableTemp, allocationTemp, needTemp, x)) {
			available=availableTemp;
			process.get(x).Allocation=allocationTemp;
			process.get(x).Need=needTemp;
			System.out.println("申请成功");
		}
		else {
			System.out.println("申请失败");
		}
		
	}
	
	
	public boolean CheckSecurity(int availableTemp[],int allocationTemp[],int needTemp[],int x) {
		List<Process> tempProcesses=new ArrayList<Process>();
		int work[]=availableTemp;
		for(int i=0;i<process.size();i++) {
			tempProcesses.add((Process)process.get(i).clone());
		}
		tempProcesses.get(x).Allocation=allocationTemp;
		tempProcesses.get(x).Need=needTemp;
		while(!tempProcesses.isEmpty()) {
			for(int i=0;i<=tempProcesses.size();i++) {
				if(tempProcesses.size()==0) return true;
				if(i==tempProcesses.size()&&i!=0) return false;
				if(Array.isLessOrEqual(tempProcesses.get(i).Need, work)) {
					work=Array.addArray(work, tempProcesses.get(i).Allocation);
					tempProcesses.remove(i);
					i=-1;
				}	
			}
		}
		return true;
		
	}

	
}
