package Array4;

import java.util.Arrays;
import java.util.Scanner;

public class Main_기지국 {
	static int[] di={-1,0,1,0};//상우하좌
	static int[] dj={0,1,0,-1};
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();	
		
		for (int tc=1; tc<=T; tc++) {
			int N=sc.nextInt();
			char[][] a= new char[N][N];
			for (int i=0; i<N ; i++) {
				String s= sc.next();
				for (int j=0; j<N; j++) {
					a[i][j]=s.charAt(j);
				}
			}
			for(char[] b:a) System.out.println(Arrays.toString(b));
		}
	}
}
