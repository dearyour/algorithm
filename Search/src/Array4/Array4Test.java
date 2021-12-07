package Array4;

public class Array4Test {

	public static void main(String[] args) {
		int[][] a= {
				{1,2,3}, 
				{4,5,6}, 
				{7,8,9}
				};
		
		//1방 탐색 :5
		for (int i=0 ; i<a.length; i++) {
			for (int j=0; j<a.length; j++) {
				if(a[i][j]==5) {
					System.out.println(a[i+0][j+0]);
					
					int[] di= {0};
					int[] dj= {0};
					
					for (int d = 0; d < 1; d++) {
						int ni = i + di[d];
						int nj = j + dj[d];
						System.out.println(a[ni][nj]);
					}
					
				}
			}
		}
	}
	

}
