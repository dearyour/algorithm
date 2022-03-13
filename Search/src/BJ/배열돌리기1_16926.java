package BJ;
import java.util.Scanner;

public class 배열돌리기1_16926 {
	public static void main(String[] args) {
		
// 돌려줘야할 사각형 레이어의 갯수 찾고 
// 처음꺼 temp에 넣고 나머지꺼 밀고 마지막에 temp 넣기  
		Scanner sc =new Scanner(System.in);
		
		int N = sc.nextInt();	//행
		int M = sc.nextInt();	//렬
		int R = sc.nextInt();	//시행횟수 
		int[][] map= new int[N][M];
		
		for(int i=0; i<N ; i++){
			for(int j=0; j<M; j++) {
				map[i][j]= sc.nextInt();
			}
		}
		
		// 시작점 , 끝점 
		// 순환   i 증가  , j 감소  
		
//		Top:  [시작점][i] 11 , 12 , 13
//		Right: [i][끝점]
//		Bottom: [끝점][j] 31 32 33  옮기는순서 오른쪽부터니까 
//		LefT: [j][시작점]
		
		
//루프 2개돔 하나는 레이어 단위 시작점 끝점 
		// 시작은 ++ 끝은 --
		// 배열 루프돌땐  i를 시작에서 끝
		//			  j를 끝에서 시작 
		// 위 -오른- 아래- 왼  순으로 돌리기 
		
		int rayer = ((N>M)? M/2 : N/2);	//사각형이 직사각형일경우 행렬 두개중에 더 짧은 것이 레이어 횟수를 결정한다 

		for(int test_case=0; test_case<R; test_case++) {			//R시행횟수만큼 
			for (int start=0; start< rayer ; start++) {  			//레이어의 횟수만큼  start커질수록 사각형 안으로 들어감 
				int rowEnd = N - start -1;		//  배열길이-1하고  레이어  한바퀴 돌떄  레이어 안으로 들어갈수록 시작점은 하나 증가하고 끝점은 하나씩 감소한다  
				int colEnd = M - start -1;		//   
			
				int temp = map[start][start];		//가장 처음 0,0의 원소정보 저장 
				
				for (int i =start; i < colEnd ; i++) {		//첫째수 temp로 임시보관  하나 없애고 열끝까지해서 왼쪽으로 밀자 
					map[start][i] = map [start][i+1];
					} //top ,  왼쪽으로 밀기
				for (int i =start; i < rowEnd ; i++) {
					map[i][colEnd] = map [i+1][colEnd];
					} // right , 위로 밀기 
				for (int i =colEnd; i > start ; i--) {
					map[rowEnd][i] = map [rowEnd][i-1];
					} // bottom , 오른쪽으로 밀기 
				for (int i =rowEnd; i > start ; i--) {
					map[i][start] = map [i-1][start];
					} // left ,  아래로 밀기 
				
				map[start+1][start]=temp;     			//가장 처음 0,0  1,1   2,2 ... 저장한 원소를 가장 마지막의 원소저장한다 . 
		}												// 항상 start 에서 행하나를 더해준 위치에 마지막꺼 들어가게 됨 
	}
	
		
		for (int i =0; i<N; i++) {
			for (int j=0; j<M; j++ ) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		
	}
}
