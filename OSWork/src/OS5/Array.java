package OS5;

public class Array {
	public static int[] addArray(int a[],int b[]) {
		int c[]=new int[a.length];
		for(int i=0;i<a.length;i++)	{
			c[i]=a[i]+b[i];
		}
		return c;
	}
	
	public static int[] substractArray(int a[],int b[]) {
		int c[]=new int[a.length];
		for(int i=0;i<a.length;i++)	{
			c[i]=a[i]-b[i];
		}
		return c;
	}
	
	public static boolean isLessOrEqual(int a[],int b[]) {
		for(int i=0;i<a.length;i++)	{
			if((a[i]-b[i])>0)return false;
		}
		return true;
	}

	
}
