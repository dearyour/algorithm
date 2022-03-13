package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서_DFS2 {
	
	static int N,M,adj[][],radj[][];
	static int cnt;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int TC =Integer.parseInt(in.readLine());
		for(int tc=1; tc<=TC; tc++) {
			N=Integer.parseInt(in.readLine());  //학생수
			M=Integer.parseInt(in.readLine());  // 간선정보수 
			adj = new int[N+1][N+1];
			radj = new int[N+1][N+1];
			
			StringTokenizer st =null;
			for (int m = 0; m < M; m++) {
				st = new StringTokenizer(in.readLine(), " ");
				int from =Integer.parseInt(st.nextToken());
				int to =Integer.parseInt(st.nextToken());
				radj[to][from]=adj[from][to]=1 ; //from 보다 to가 크다 
			}  //역 인접행렬
			
			int ans=0;
			for (int i = 0; i < N; i++) {
				cnt = 0;  //학생들마다 다시 카운트를 새로해야 한다 
				dfs(i,adj, new boolean[N+1]); // 자신보다 큰 학생 탐색
				dfs(i,radj, new boolean[N+1]); //자신보다 작은 학생 탐색
				if(cnt == N-1) ++ans;  //cnt를 N(노드)숫자 -1 (자기자신안들어가니까) 탐색하면 자신의 키를 알수있는 학생들이 늘어남
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		
	}   
	
	
	//자신보다 큰, 작은 학생 따라 탐색		
		private static void dfs(int cur, int[][] adj, boolean[] visited ) { //탐색을해야하는 인접행렬을 매개변수로받아온다 
									//adj에 큰애를 주면 큰애로 따라감 , adj에 작은애를주면 작은애를 따라감 
			visited[cur]= true; 
			for (int i = 1; i <= N; i++) { 
				if(!visited[i] && adj[cur][i]==1) {  //인접행렬은 열을 긁어야 하니까 i값을 row위치에 넣는다 
					++cnt; 
					dfs(i,adj, visited); 
				}
			}
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