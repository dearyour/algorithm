package Array4;

public class Array4Test5 {

	public static void main(String[] args) {
		int[] di={-1,0,1,0};//상우하좌
		int[] dj={0,1,0,-1};
		int[][] a= {
				{1,2,3}, 
				{4,5,6}, 
				{7,8,9}
				};
		int N=3;
		int M=3;
		
		  //4방탐색: 상우하좌:2684
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i][j]==9) {
                    for (int d = 0; d < 4; d++) {
                        int ni=i+di[d];
                        int nj=j+dj[d];
                        if(0<=ni && ni <N && 0<=nj && nj<M) {
                        	System.out.println(a[ni][nj]);
                        }
                    }
                }
            }
        }
	}
	

}
