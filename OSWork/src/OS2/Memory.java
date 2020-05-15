package OS2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;


public class Memory {
	List<Partition> mallocedList=new ArrayList<Partition>();
	List<Partition> notMallocedList=new ArrayList<Partition>();
	List<Partition> allList=new ArrayList<Partition>();
	double len=128;
	
	public Memory() {
		Partition partition=new Partition(0, 128, false);
		notMallocedList.add(partition);
		
	}
	
	public void malloc(double len) {
		int i=0;
		for(;i<notMallocedList.size();i++) {
			if(notMallocedList.get(i).len>=len) break;
		}
		if(i==notMallocedList.size()) {
			System.out.println("分配失败");
		}
		else if(notMallocedList.get(i).len==len) {
			notMallocedList.get(i).isMalloc=true;
			mallocedList.add(notMallocedList.get(i));
			mallocedListSort();
			notMallocedList.remove(i);
		}
		else if(notMallocedList.get(i).len>len){
			mallocedList.add(new Partition(notMallocedList.get(i).addr,len,true));
			mallocedListSort();
			notMallocedList.get(i).addr+=len;
			notMallocedList.get(i).len-=len;
		}
	}
	
	public void unMalloc(int i) {
		mallocedList.get(i).isMalloc=false;
		notMallocedList.add(mallocedList.get(i));
		nmallocedListSort();
		mergeNotMallocedPartition(mallocedList.get(i).addr);
		mallocedList.remove(i);
	}
	

	
	public void display() {
		allList.clear();
		allList.addAll(mallocedList); 
		allList.addAll(notMallocedList);
		Collections.sort(allList, new Comparator<Partition>() {
			public int compare(Partition a, Partition b) {
				if(a.addr-b.addr>0) return 1;
				else if(a.addr-b.addr==0) return 0;
				else return -1;
			}
		});
		int j=1;
		for(int i=0;i<allList.size();i++) {
			if(allList.get(i).isMalloc) {
				System.out.println("分区号: "+j+" 大小: "+allList.get(i).len+"KB "+"起始地址: "+allList.get(i).addr+" 状态: 占用");
				j++;
			}
			else {
				System.out.println("分区号:  "+" 大小: "+allList.get(i).len+"KB "+"起始地址: "+allList.get(i).addr+" 状态: 空闲");
				
			}
		}
		
	}
	
	private void mallocedListSort() {
		Collections.sort(mallocedList, new Comparator<Partition>() {
			public int compare(Partition a, Partition b) {
				if(a.addr-b.addr>0) return 1;
				else if(a.addr-b.addr==0) return 0;
				else return -1;
			}
		});
	}
	private void nmallocedListSort() {
		Collections.sort(notMallocedList, new Comparator<Partition>() {
			public int compare(Partition a, Partition b) {
				if(a.addr-b.addr>0) return 1;
				else if(a.addr-b.addr==0) return 0;
				else return -1;
			}
		});
	}
	
	private void mergeNotMallocedPartition(double address) {
		int i=0;
		for (;i<notMallocedList.size();i++) {
			if(address==notMallocedList.get(i).addr) break;
		}
		if(i==notMallocedList.size()||notMallocedList.size()<=1) {return;}
		else if(i==0) {
			if(notMallocedList.get(0).addr+notMallocedList.get(0).len==notMallocedList.get(1).addr) {
				notMallocedList.get(0).len+=notMallocedList.get(1).len;
				notMallocedList.remove(1);
			}
		}
		else if(i==(notMallocedList.size()-1)) {
			if(notMallocedList.get(i-1).addr+notMallocedList.get(i-1).len==notMallocedList.get(i).addr) {
				notMallocedList.get(i-1).len+=notMallocedList.get(i).len;
				notMallocedList.remove(i);
			}
		}
		else {
			if(notMallocedList.get(i-1).addr+notMallocedList.get(i-1).len+notMallocedList.get(i).len==notMallocedList.get(i+1).addr) {
				notMallocedList.get(i-1).len=notMallocedList.get(i-1).len+notMallocedList.get(i).len+notMallocedList.get(i+1).len;
				notMallocedList.remove(i+1);
				notMallocedList.remove(i);
			}
			else if(notMallocedList.get(i-1).addr+notMallocedList.get(i-1).len==notMallocedList.get(i).addr) {
				notMallocedList.get(i-1).len+=notMallocedList.get(i).len;
				notMallocedList.remove(i);
			}
			else if(notMallocedList.get(i).addr+notMallocedList.get(i).len==notMallocedList.get(i+1).addr) {
				notMallocedList.get(i).len+=notMallocedList.get(i+1).len;
				notMallocedList.remove(i+1);
			}
		}
		
	}
	
	
	
}
