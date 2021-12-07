package Array4;

import java.util.Arrays;

public class Array4Test6 {

	public static void main(String[] args) {
		int[] di={-1,0,1,0};//상우하좌
		int[] dj={0,1,0,-1};
		int[][] a= {
				{0,0,0,0,0,0,0,0,0}, 
				{0,0,0,0,0,0,0,0,0}, 
				{0,0,0,0,0,0,0,0,0}, 
				{0,0,0,0,0,0,0,0,0}, 
				{0,0,0,0,9,0,0,0,0}, 
				{0,0,0,0,0,0,0,0,0}, 
				{0,0,0,0,0,0,0,0,0}, 
				{0,0,0,0,0,0,0,0,0}, 
				{0,0,0,0,0,0,0,0,0}
				};
		int N=9;
		int M=9;
		
		  //4방탐색: 상우하좌:2684
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i][j]==9) {
                    for (int d = 0; d < 4; d++) {
                        int ni=i+di[d]*3;
                        int nj=j+dj[d]*3;
                        if(0<=ni && ni <N && 0<=nj && nj<M) {
                        	a[ni][nj]=3;
                        	
                        }
                    }
                }
            }
	}
	for(int[] b:a) System.out.println(Arrays.toString(b));
	}
}
