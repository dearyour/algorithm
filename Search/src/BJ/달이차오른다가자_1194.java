package BJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;


// 소문자 방문해야지 대문자 방문 가능
// 소문자 기존것 + 새롭게갱신 
public class 달이차오른다가자_1194 {
	static int[] dr = {-1, 1 , 0 , 0};
	static int[] dc = { 0, 0, -1 , 1};
	static char[][] arr;
	
	static int R, C, FinalMinCnt;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokens = new StringTokenizer(br.readLine());
		R=Integer.parseInt(tokens.nextToken());
		C=Integer.parseInt(tokens.nextToken());
		
		arr = new char[R][C];
		Point start = null;
		FinalMinCnt = Integer.MAX_VALUE;
		
		for (int r =0; r<R; r++) {
			arr[r]=br.readLine().toCharArray();
			for (int c=0; c <C; c++) {
				if (arr[r][c] =='0'){  //민식이 현재시점 저장 ,0은 오직한개,  사방탐색 최솟값 = BFS
						start = new Point(0,r,c,0);
				}
			}
		}
		
		
		bfs(start);
		
		if (FinalMinCnt == Integer.MAX_VALUE) { //마지막cnt값이 초기화값 그대로라면 탈출불가능 
			System.out.println(-1);
		}else {
			System.out.println(FinalMinCnt);
		}
	} 
	
	
	static void bfs(Point start) {
		Queue<Point> q = new LinkedList<>();
		q.offer(start);
		
		boolean[][][] visited = new boolean[1<<6][R][C]; //a~f소문자 6개의 원소로 만들수있는 부분집합의 개수 1<<6  , 2^6=64
		
		visited[start.keys][start.row][start.col] = true; //원숭이때처럼 3차원, r,c에서 외에 키의 상태값도 파악해야하니까 3차원
		
		while(!q.isEmpty()) {
			Point qu = q.poll();
			
			if(arr[qu.row][qu.col] =='1') { //bfs끝조건  //1 출구 민식 최종도착지  //출구는 여러개있을수있다.
				FinalMinCnt = qu.cnt;
				return;
			}
			
			for (int d = 0; d < 4; d++) {
				int nr = qu.row + dr[d];
				int nc = qu.col + dc[d];
				
				if (0<=nr && nr<R && 0<=nc && nc<C    && !visited[qu.keys][nr][nc]) { //범위안, 방문안한곳
					if(arr[nr][nc] =='#') continue;  //벽이면 다음 
					if(arr[nr][nc] >= 'A' && arr[nr][nc] <= 'F' && !qu.iskey(arr[nr][nc])) continue;
					//소문자 키(key)를 가지고있지 않고서는   대문자(door) 통과 불가능
					
					
					visited[qu.keys][nr][nc]=true; //keys 'a'~'f'
					
					Point newPoint =new Point(qu.keys, nr, nc, qu.cnt+1);  //새로운이동, cnt 이동횟수 +1추가
					
					if (arr[nr][nc] >= 'a' && arr[nr][nc] <= 'f') { //새로운키 만났을시 | 연산으로 point의 keys값 업데이트
						newPoint.newKey(arr[nr][nc]);
					}
					
					q.offer(newPoint);
				}
			} //사방끝
			
			
			
		}//while
	}
	
	static class Point{
		int keys, row, col, cnt;
		
		public Point(int keys, int row, int col, int cnt) {
			this.keys = keys;
			this.row = row;
			this.col = col;
			this.cnt = cnt;
		}
		
		public boolean iskey(char door) {   // &는 있는지없는지 체크할때
			return (keys & 	(1 << door -'A')) > 0;
		}
		
		public int newKey(char key) {
			return keys = keys | (1 << key -'a');
			//현재 가지고있는키에 또다른 새로운 keys를 추가시려면 |
			// 010001 a,e키를 가지고있을떄
			// 000010 b키 를 새롭게 먹었다면
			//|010011 a,e,b 셋 다 가지고있는 keys값갱신 
		}

		
		// door를 'C'를 먹엇을떄 door-'A' = 2이다 
		// 000100   //현재보유 keys값                 'a'~'f'
	//&    000100   //문열려고하는 door값 	 'A'~'F'
		// 000100     >0  크면 트루    
		
		
		//어떤요소가 내가만든 부분집합에 들어가냐 안들어가냐 사용한 연산자 비트연산자 
		//  a : 0 0 0 0 0 1
		//	b : 0 0 0 0 1 0    'b'-'a' = 1   	-> 1<<1  	-> 10 
		//  c : 0 0 0 1 0 0
		//  d : 0 0 1 0 0 0 
		//  e : 0 1 0 0 0 0 
		//  f : 1 0 0 0 0 0
		
	}
}


/*
7 8
a#c#eF.1
.#.#.#..
.#B#D###
0....F.1
C#E#A###
.#.#.#..
d#f#bF.1
*/
