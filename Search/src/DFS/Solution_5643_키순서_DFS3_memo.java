package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서_DFS3_memo {
	
	static int N,M,adj[][];
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC =Integer.parseInt(in.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N=Integer.parseInt(in.readLine());  //학생수
			M=Integer.parseInt(in.readLine());  // 간선정보수 
			adj = new int[N+1][N+1];
			
			StringTokenizer st =null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine(), " ");
				int from =Integer.parseInt(st.nextToken());
				int to =Integer.parseInt(st.nextToken());
				adj[from][to]=1 ; //from 보다 to가 크다 
			}  //역 인접행렬
			
			for (int i = 1; i <= N; i++) {
				adj[i][0]= -1;  //모든행의 0열을 -1로 한다 .  // 그게 -1 이면 탐색전이고 -1아니면 탐색을한것
				
			}
			int ans=0;
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] == -1)dfs(i); // 자신보다 큰 학생 탐색 (아직 탐색이 안된 학생만)
			}
			
			// 위에서 탐색된 결과를 토대로 자신보다 작은 학생수 카운팅ㄴ
			for (int i = 1; i <= N; i++) {
				for (int j = 1; j <= N; j++) {
					adj[0][j] += adj[i][j];
				}
			}
			
			for (int i = 1; i <= N; i++) {
				if(adj[i][0] + adj[0][i] == N-1) ++ans;
			}
			
			System.out.println("#"+tc+" "+ans);
			
		} 
		
	}   
	
	
	//자신보다 큰, 작은 학생 따라 탐색		
		private static void dfs(int cur) { //탐색을해야하는 인접행렬을 매개변수로받아온다
			
			for (int i = 1; i <= N; i++) { 
				if(adj[cur][i]==1) { //자신보다 큰 학새이면
					if(adj[i][0]== -1) {//탐색전 
						dfs(i);
					}
					//자신보다 큰 학생을 탐색을 완료한 상태 (메모가 되어있으면 탐색안하고 바로 내려옴)
					if(adj[i][0]>0) { // i보다 큰 학생이 존재 
						// i의 인접행렬의 상태를 cur에 반영
						for (int j = 1; j <=N; j++) {
							if(adj[i][j]==1) adj[cur][j]=1;
	 					}
					}
				}
			}
			
			int cnt =0;
			for (int j = 0; j < N; j++) {
				cnt += adj[cur][j];
			}
			adj[cur][0]=cnt;
			
			
			
			
		}

}

/*
1
6
6
1 5
3 4
5 4
4 2
4 6
5 2
*/