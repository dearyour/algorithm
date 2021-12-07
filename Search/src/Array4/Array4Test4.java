package Array4;

public class Array4Test4 {

	public static void main(String[] args) {
		int[][] a= {
				{1,2,3}, 
				{4,5,6}, 
				{7,8,9}
				};
		
		//4방 탐색 : 상우하좌 :2684
		for (int i=0 ; i<a.length; i++) {
			for (int j=0; j<a.length; j++) {
				if(a[i][j]==5) {
					System.out.println(a[i-1][j+0]);
					System.out.println(a[i+1][j-0]);
					
					int[] di= {-1, 1}; //상하
					int[] dj= {0, 0};
					
					for (int d = 0; d < 2; d++) {   //이 코드는 계속 가만히 있는다 .  위에 ㅗ 코드만 바뀐다 
						int ni = i + di[d];
						int nj = j + dj[d];
						System.out.println(a[ni][nj]);
					}
					
				}
			}
		}
	}
	

}
