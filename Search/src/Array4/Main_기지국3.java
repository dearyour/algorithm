package Array4;
import java.util.Arrays;
import java.util.Scanner;

public class Main_기지국3 {
    static int[] di={-1,0,1,0};//상우하좌
    static int[] dj={0,1,0,-1};
    
    public static void main(String[] args) throws Exception{
        //System.setIn(new FileInputStream("res/input_im_기지국.txt"));
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        
        for (int tc=1; tc<=T; tc++) {
            int N=sc.nextInt();
            char[][] a=new char[N][N];
            for (int i = 0; i < N; i++) {
                a[i]=sc.next().toCharArray();
            }
            //for (int i = 0; i < N; i++) {
            //    String s=sc.next();
            //    for (int j = 0; j < N; j++) {
            //        a[i][j]=s.charAt(j);
            //    }
            //}
            for(char[] b:a) System.out.println(Arrays.toString(b)); System.out.println();
            
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(a[i][j]=='A' || a[i][j]=='B' || a[i][j]=='C') {
                        for(int k=1; k<=(a[i][j]-'A'+1); k++) {
                            for (int d = 0; d < 4; d++) {
                                int ni=i+di[d]*k;
                                int nj=j+dj[d]*k;
                                		if(0<=ni&&ni<N && 0<=nj&&nj<N && a[ni][nj]=='H') {
                                            a[ni][nj]='X';
                                        }
                                    }
                                }
                            }
                        }
                    }
                    for(char[] b:a) System.out.println(Arrays.toString(b)); System.out.println();
                    
                    int cnt=0;
                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            if(a[i][j]=='H') cnt++;
                        }
                    }
                    System.out.println("#"+tc+" "+cnt);
                }
                sc.close();
            }
        }