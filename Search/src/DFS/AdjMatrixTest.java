package DFS;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

//재귀호출은 cnt 카운팅을 통해 for문의 횟수를 결정한다 
public class AdjMatrixTest {

	static int N; // 정점 개수
	static boolean[][] adjMatrix; // 인접행렬 (가중치 없음) 
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		adjMatrix = new boolean[N][N];
		int C = Integer.parseInt(in.readLine()); // 간선 개수
		for (int i = 0; i < C; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			adjMatrix[to][from] = adjMatrix[from][to] = true; // 인접했으면 트루 //인접한 그래프정보 저장
		}
		System.out.println("=============bfs==================");
		bfs(); 
		System.out.println("=============dfs==================");
		boolean[] visited = new boolean[N];
		dfs(0,visited);   // dfs(v) v: 탐색정점  // dfs 0부터 방문시작
	}
/*
 BFS (G ,V )  // 그래프 G , 탐색시작정점 v 
 	큐 생성 
 	시작정점 v를 큐에 삽입 
 	정점 v를 방문한 것으로 표시 
 	while(큐가 비어 있지 않은 경우) { 
 	 		t <- 큐의 첫 번쨰 원소 반환  
 	 		for ( t와 연결된 모든 간선에 대해 ) {
 	 				u <- t의 인접 정점
 	 				if (u가 방문 되지 않은 곳이면),
 	 				u를 큐에 넣고 , 방문한것으로 표시 
 	 				}
 	 			}	
 */
	//큐에 삽입했다면 방문처리 하라 한쌍으로 생각해야해 queue.offer() 와  visited[i]는 같이 다닌다 
	private static void bfs() {  //큐 , visited 불린1차원 배열  , 입력정보인 2차원배열
		
		Queue<Integer> queue = new LinkedList<Integer>();  //큐 생성 
		boolean[] visited = new boolean[N];  //정점의 갯수만큼 만든다 
		
		queue.offer(0);			// 시작정점 v를 큐에 삽입 
		visited[0] = true;		// 정점 v를 방문한 것으로 표시     //bfs는 visited 체크부터해야 오류안남
		
		while(!queue.isEmpty()) {   // 큐가 비어 있지 않은 경우
			int current = queue.poll();   // 큐의 첫 번쨰 원소 반환 //시작정점
			System.out.println((char)(current+65));
			
			for (int i = 0; i < N; i++) {	//모든 정점을 들여다보자// current 와 연결된 모든 간선에 대해 
				if(!visited[i] && adjMatrix[current][i]) { //current의 인접정점이 방문 되지 않은 곳이면
				// 미방문 ==false 	// 인접정점  		//이 for문의 i 는 위에 설명의 u와 같다
								//현재 탐색을하고있는 정점에서 그 정점으로 갈수있는지 보자
					queue.offer(i);		// current의 인접정점을 큐에 넣고 
					visited[i] = true;  //방문한것으로 표시 
				}
			}
		}
	}
	
	
	//dfs 부르면 그 정점 방문체크하고~ 방문안한 인접정점 바라본다 
	// 그 인접정점 방문하고~ 다시 방문안한 인접정점 바라본다 
	// 방문 다했고 인접정점이 없을때 재귀에서 탈출된다
	private static void dfs(int current,boolean[] visited) { //인접한 그래프 adjMatrix(고정값) 따라 visited(변화값)를 업데이트해나간다 
//current현재탐색 정점, 재귀를 호출이들어오면  탐색정점 결정, dfs재귀호출자체가 bfs의 int current = queue.poll(); 와같다
		// 		dfs(0,visited) 가 메인함수에서 넘어왔다 
		//		dfs(current) current: 탐색정점           //  현재 이곳에서  current = 0
		
		visited[current] = true;  //현재 current 를 방문처리 함   즉 0을 방문처리함,이 dfs메소드 타고오면 방문체크
		System.out.println((char)(current+65)); //탐색정점이 결정되면 일단 위치찍어
		  
//ex	// myGraph[x] <- x에 인접해있는 노드의갯수 //현재 연결된노드 갯수 // [1,3,4] 현재 정점에는 1,3,4가 연결되어있다면
		// for(int i=0; i<myGraph[x].size(); i++ {
		// int y = myGraph[x][i];  // x와 y가 연결되어있다 
		//}
		// if(visited[y] == false) {
		// dfs(y);  // y를 부르고 나는자고있다 
		// }
		// 1 -- 3 -- 4 --7   1 3 4 7 방문처리하고 다시 1로돌아가서 
//ex	// | -- 6 -- 8     6 8 를 방문한다 
		
		for (int i = 0; i < N; i++) { //current 현재 나의 인접한 이웃들을 본다는 의미로 for문이 들어감// 
									 //current= 1, i는 3일때 재귀로인해 다시 current=3, i=4가 된다 쭉 이렇게한후 더이상 연결안됬다면
									// 다시 7에서 부터 1로 돌아와서 for문의 i++를 해줘서 다음 current=6이고 연결된 i는 6과연결인노드 타고들어간다
			if(!visited[i] && adjMatrix[current][i]) {  //방문하지 않고 인접정점이면   //   visited[i] == false일떄~
				dfs(i, visited);					//다시 그 i를 방문처리함 즉 i가 1이되고 2가되고
													//N은 정점의 갯수니까 i가 움직임 
			}  //탐색이안됬으면 타고가는거고 탐색이 됬으면 안타고 
		}		//모든 정점이 방문처리됬으면 for문이 아무리 돌아봤자 dfs재귀를 태울수없어서
	}			//모든 정점이 방문처리가 기저조건 

}







