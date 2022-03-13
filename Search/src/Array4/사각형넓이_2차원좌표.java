
package Array4;

import java.util.Scanner;

public class 사각형넓이_2차원좌표 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T =sc.nextInt();
		
		for (int tc=1; tc<=T; tc++) {
			int N =sc.nextInt();
			int[][] arr = new int[N][N];
			
			
			
			
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr.length; j++) {
					arr[i][j]=sc.nextInt();
					
				}
			}
			

			
			int max=0;
			int cnt=1;
			for (int a=0; a<N; a++) {
				for(int b=0; b<N; b++) {
					int x = 0;
					int y = 0;
					int sum=0;
					for (int c=a; c<N; c++) {
						for(int d=b; d<N; d++) {
							if (arr[a][b] == arr[c][d]) {
							
								
								x =c-a+1;
								y =d-b+1;
								sum =x * y;
							}
							
						}
					}
					if(max<sum) {
						max=sum;
						cnt =1;
					} else if(max ==sum ) {
							cnt++;
					}
					
				
//					max =Math.max(max, sum);
//					cnt++;
				}
			}
			System.out.println("#"+tc+" " + cnt);
			cnt=0;
			
			
			

			
			
		}

	}
}


/*
1
5
8 7 9 5 8
4 8 5 3 5
2 4 0 5 9
0 9 7 4 3
0 6 6 7 9

#1 2
*/