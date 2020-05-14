package OS3;

public class Map {
	public int i; //总字节数
	public int j; //总位数
	int map[][];
	public Map(int x,int y,int z) {  //分别为柱面数，磁道数，每磁道分为物理记录数
		i=x;
		j=(y-1)*4+z;
		map=new int[i][];
		for(int n=0;n<i;n++) {
			map[n]=new int[j];
		}
	}
	
}
