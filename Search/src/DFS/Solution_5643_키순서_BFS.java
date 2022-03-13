package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution_5643_키순서_BFS {
	
	static int N,M,adj[][];
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
				if(gtBFS(i)+ltBFS(i) == N-1) ++ans;
			}
			System.out.println("#"+tc+" "+ans);
			
		}
		
	}
	//자신보다 큰 학생 따라 탐색
	private static int gtBFS(int start) {
		Queue<Integer> queue = new LinkedList<Integer>();
		boolean[] visited = new boolean[N+1];
		
		queue.offer(start);
		visited[start] = true;
		
		int cnt =0;
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			
			for (int i = 1; i <= N; i++) {  //학생수 들여다보자 
				if(!visited[i] && adj[cur][i]==1) { //탐색하지않았고 자기에서 그 학생수와의 관계중 학생이 더 크다고 알려져있다면
					// cur 행고정  열 증가  -> 가로로 체크 
					queue.offer(i);  //그 학생따라서 탐색해야하기 때문에 큐에 넣어주고
					visited[i] = true;
					++cnt; //visited를 트루로 할떄마다 카운트를 센다 
				}
			}
		}
		return cnt;
	}
	
	//자신보다 작은 학생 따라 탐색
		private static int ltBFS(int start) {
			Queue<Integer> queue = new LinkedList<Integer>();
			boolean[] visited = new boolean[N+1];
			
			queue.offer(start);
			visited[start] = true;
			
			int cnt =0;
			while(!queue.isEmpty()) {
				int cur = queue.poll();
				
				for (int i = 1; i <= N; i++) {  //학생수 들여다보자 
					if(!visited[i] && adj[i][cur]==1) { //탐색하지않았고 자기에서 그 학생수와의 관계중 학생이 더 크다고 알려져있다면
						// cur 열고정  행 증가  -> 세로로 체크 
						queue.offer(i);  //그 학생따라서 탐색해야하기 때문에 큐에 넣어주고
						visited[i] = true;
						++cnt; //visited를 트루로 할떄마다 카운트를 센다 
					}
				}
			}
			return cnt;
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