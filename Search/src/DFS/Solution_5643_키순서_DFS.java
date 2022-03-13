package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서_DFS {
	
	static int N,M,adj[][];
	static int gtCnt,ltCnt;
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
			}
			int ans=0;
			for (int i = 0; i < N; i++) {
				gtCnt = ltCnt = 0;  //학생들마다 다시 카운트를 새로해야 한다 
				gtDFS(i, new boolean[N+1]); //탐색할때 마다 배열을 새로 만든다 
				ltDFS(i, new boolean[N+1]); //탐색할때 마다 배열을 새로 만든다
				if(gtCnt + ltCnt == N-1) ++ans;  //cnt를 N(노드)숫자 -1 (자기자신안들어가니까) 탐색하면 자신의 키를 알수있는 학생들이 늘어남
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		
	}
	//자신보다 큰 학생 따라 탐색		//현재학생 cur , 여태까지 탐색의 방문이 누적된 배열을 받아온다 
	private static void gtDFS(int cur, boolean[] visited ) {//bfs의 start개념이아니라 현재탐색하고있는 개념인 current
										//현재 학생을 부르면 스택위에 쌓이고
										//bfs는 재귀사용안하고 하나의 메소드안에서 처리하니까 그메소드안에 불린형배열만듬 
										// dfs는 재귀로 함수를 가로질러서 방문호출을 공유해야한다

		
		//bfs는 인접한 배열을 while로 끝까지 다 관리하는것 
		//dfs는 나의 인접한 배열만 관리하면 되니까 for if비지티드 배열만 필요함 
		// 나와 직접적인 관계 만나면 그 만난애로 재귀가옮겨가서 걔자체로도 재귀타고감 
		
		visited[cur]= true;  //매게변수에 선언한거에 데이터주면 먹네  //현재학생 방문처리
		for (int i = 1; i <= N; i++) {  //학생수 들여다보자 
			if(!visited[i] && adj[cur][i]==1) { //탐색하지않았고, (자기보다 큰노드)= 자기에서 그 학생수와의 관계중 학생이 더 크다고 알려져있다면
				++gtCnt; // 모든 재귀호출을 가로질러서 공유가 되어야함 그래서 bfs와달리 메소드안에 안넣고 위에 스태틱 변수선언함 
			     		 // 큰학생 따라가는거니까 카운트 올려준다  
						 //for 위에안쓰는이유는 첫번째 초기노드까지 cnt를 세주니까 이동할때만 cnt 세주기 위해서
				gtDFS(i,visited); //그 학생을 따라가자 (재귀태워서 ) 
			}
		}
	}
	
	
	//자신보다 작은 학생 따라 탐색		
		private static void ltDFS(int cur, boolean[] visited ) {
			
			visited[cur]= true; 
			for (int i = 1; i <= N; i++) { 
				if(!visited[i] && adj[i][cur]==1) {  //인접행렬은 열ㅇ르 긁어야 하니까 i값을 row위치에 넣는다 
					++ltCnt; 
					ltDFS(i,visited); 
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