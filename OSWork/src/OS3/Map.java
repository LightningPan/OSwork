package OS3;

public class Map {
	public int i; //���ֽ���
	public int j; //��λ��
	int map[][];
	public Map(int x,int y,int z) {  //�ֱ�Ϊ���������ŵ�����ÿ�ŵ���Ϊ�����¼��
		i=x;
		j=(y-1)*4+z;
		map=new int[i][];
		for(int n=0;n<i;n++) {
			map[n]=new int[j];
		}
	}
	
}
