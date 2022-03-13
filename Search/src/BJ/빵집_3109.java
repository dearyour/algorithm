package BJ;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class 빵집_3109 {
	
	// 맵안의 한칸을 지나는 파이프 단 하나 
	// 행 0부터 시작이니까 파이프 우상 부터 간다음 아래로 가는게 이득
	
	    static int[] dx = {-1, 0, 1};  //우상 , 우 , 우하
	    static int[] dy = {1, 1, 1};
	    static int r, c;
	    static char[][] map;		//맵
	    static boolean[][] check;	//방문여부
	    
	    public static void main(String[] args) throws FileNotFoundException {
	    	System.setIn(new FileInputStream("plinovod.in.1.txt"));
	        Scanner sc = new Scanner(System.in);
	        
	        r = sc.nextInt();
	        c = sc.nextInt();
	        sc.nextLine();
	        
	        map = new char[r][c];    //맵 
	        for(int i = 0; i < r; i++) {
	            String str = sc.nextLine();
	            for(int j = 0; j < c; j++) {
	                map[i][j] = str.charAt(j);
	            }
	        }
	        
	        check = new boolean[r][c];  //방문여부 
	        int count = 0;
	        for(int i = 0; i < r; i++) {	//항상 가장 왼쪽 열에서 출발하니까 행을 순차적으로 증가  왼위가 첨가니까 우상,우,우하가 젤이득
	            if(dfs(i, 0)) count++;  // 경로찾자, 최종열 c-1 면 카운트
	        }
	        
	        System.out.println(count);
	    }
	    
	    public static boolean dfs(int x, int y) {
	        for(int i = 0; i < 3; i++) {
	            int nx = x + dx[i];			//우상 우 우하 순서로
	            int ny = y + dy[i];
	            
	            if(nx >= 0 && ny >= 0 && nx < r && ny < c) {    //가려는 좌표 맵안에있고
	                if(check[nx][ny] == false && map[nx][ny] == '.') {  //방문안했고 빈칸일떄 
	                    check[nx][ny] = true;							//그좌표로 가자 
	                    if(ny == c - 1) return true;  //움직인 그열이 최종 도착지점 열인지
	                    if(dfs(nx, ny)) return true;  
	                }
	            }
	        }
	        return false;
	    }    
	}

