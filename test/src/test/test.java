package test;

import java.awt.desktop.PrintFilesEvent;

public class test {

	public static void main(String[] args) {
		int a[][];
		a=new int[9][];
		for(int i=0;i<9;i++) {
			a[i]=new int[8];
		}
		a[8][7]=1;
		System.out.print(a[0][1]);

	}

}
