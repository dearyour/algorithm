package Array4;
import java.util.Scanner;

public class Main_기지국4 {

    public static void main(String[] args) {
//        char ch = 'C';
//        int num = ch - 'A';
//        System.out.println(num);
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        for(int t = 1; t <= TC ; t++) {
            
            //입력
            int n = sc.nextInt();
            char[][] map = new char[n][n];
            for(int i =0; i < n; i++) {
                String str = sc.next(); // XAXXXABXX
                for(int j = 0; j < n; j++) {
                    map[i][j] = str.charAt(j);
                }
            }
            //시물레이션 => 기지국 체크  H => X
            for(int i = 0 ; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] != 'X' && map[i][j] != 'H' ) { //기지국이면
                        
//                        map[i][j] -'C' => 0, 1, 2
                        
                        for(int k = 1; k < map[i][j] -'A' + 2; k++) { // A,B,C 반복회수
                            //동 서 남 북  기지국
                            //동쪽에 집이 있으면 보호처리 하기 (갈 수 있으면)
                            if(j+k < n && map[i][j+k] == 'H') {
                                map[i][j+k] = 'X';
                            }
                            //서쪽에 집이 있으면 보호처리 하기 (갈 수 있으면)
                            if(j-k >=0 && map[i][j-k] == 'H') {
                                map[i][j-k] = 'X';
                            }
                            //남쪽에 집이 있으면 보호처리 하기 (갈 수 있으면)
                            if(i+k < n && map[i+k][j] == 'H') {
                                map[i+k][j] = 'X';
                            }
                            //북쪽에 집이 있으면 보호처리 하기 (갈 수 있으면)
                            if(i-k >= 0 && map[i-k][j] == 'H') {
                                map[i-k][j] = 'X';
                            }
                        }
                    }
                }
            }
            //남은 집수 세기
            int res = 0;
            for(int i = 0 ; i < n; i++) {
                for(int j = 0; j < n; j++) {
                    if(map[i][j] == 'H') {
                        res++;
                    }
                }
            }
            System.out.println("#" + t + " " + res);
        }

    }

}