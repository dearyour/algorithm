package BJ;

import java.util.Scanner;

public class 색종이_2630 {
		static int blue;
		static int white;
		static int[][] map;
		public static void main(String[] args) {
			Scanner sc = new Scanner(System.in);
			int N = sc.nextInt();
			white=0;
			blue=0;
			map = new int[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++)
					map[i][j] = sc.nextInt();
			}
			divide(0,0, N);
			System.out.println(white);
			System.out.println(blue);
			
		}
		
		//r,c에서 시작해서 size크기안의 배열들이 단일색상인지 찾자
	
		static void divide(int r, int c, int size) {
			//첫번째 색깔을 저장후 for문에서 추후 다른색과 달라서 펄스나옴 재귀로 짜르자
			int color = map[r][c];
			
			//색깔 계속동일하게 나오면 계속 배열 칸이동시켜서 찾는다 
			//저장된 색깔이랑 다르면 한변의 크기를 반으로된 네개 사각형으로 재귀태우자
			for(int i=r; i<r+size; i++) {
				for(int j=c; j<c+size; j++) {
					if(map[i][j] != color) {
						divide(r, c , size/2);					//2
						divide(r + size/2 , c , size/2);		//3
						divide( r, c + size/2, size/2);			//1
						divide( r+ size/2, c+size/2, size/2);	//4 
						return;
					}
				}
			}				//배열 값이 1이면 블루 카운트 
			if(color == 1) {
				blue++;
			}
			if(color == 0) {
				white++;
			}
		}
	}

/*
8
1 1 0 0 0 0 1 1
1 1 0 0 0 0 1 1
0 0 0 0 1 1 0 0
0 0 0 0 1 1 0 0
1 0 0 0 1 1 1 1
0 1 0 0 1 1 1 1
0 0 1 1 1 1 1 1
0 0 1 1 1 1 1 1
*/
