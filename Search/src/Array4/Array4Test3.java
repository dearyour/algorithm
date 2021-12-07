package Array4;

public class Array4Test3 {

	public static void main(String[] args) {
		int[][] a= {
				{1,2,3}, 
				{4,5,6}, 
				{7,8,9}
				};
		
		  //4방탐색: 상우하좌:2684
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a.length; j++) {
                if(a[i][j]==5) {
                    System.out.println(a[i-1][j+0]);//상
                    System.out.println(a[i+0][j+1]);//우
                    System.out.println(a[i+1][j+0]);//하
                    System.out.println(a[i+0][j-1]);//좌
                    
                    int[] di={-1,0,1,0};//상우하좌
                    int[] dj={0,1,0,-1};
                    for (int d = 0; d < 4; d++) {
                        int ni=i+di[d];
                        int nj=j+dj[d];
                        System.out.println(a[ni][nj]);
                    }
                }
            }
        }
	}
	

}
