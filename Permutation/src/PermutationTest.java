import java.util.Arrays;

//1,2,3 순열
public class PermutationTest {

	static int N=3,R=3; 
	static int[] numbers;
	static boolean[] isSelected;
	
	public static void main(String[] args) {

		numbers = new int[R];		//저장되서 마지막 출력되는 배열값
		isSelected = new boolean[N+1];  // 인덱스랑 똑같이 쓰려고 +1 해준것이다 
	
		permutation(0);
	}
	
	private static void permutation(int cnt) {	// cnt 는 결국 R(뽑는횟수)이다//cnt는 for문 사용횟수 
		if(cnt == R) {  //3중 for문 사용하고 싶을때 cnt도 0 , 1 , 2  이렇게 3번 돌아가고 // 4번째for문인 cnt=3일때 탈출
			System.out.println(Arrays.toString(numbers));
			return;
		}
		// 가능한 모든 수 시도
		for (int i = 1; i <= N; i++) { //i는 뽑히는 원소수 , cnt는 배열 인덱스 (for문 사용횟수)
			if(isSelected[i]) continue; // 사용중인 수면 다음 수로. //해당배열값을(인덱스말고)number배열에 중복시키지않기하기위해 사용
			
			numbers[cnt] = i;
			isSelected[i] = true;
			
			// 다음 자리순열 뽑으로 gogo
			permutation(cnt+1);  		// [1,2,3]  첫번째 순열 뽑아낸후 
			isSelected[i] = false;		// cnt+1 이 3이되면 (R이 3까지니까) 재귀가 끝나고 
		}								// 그러면 단계적으로 cnt=2 일때 셀렉티는 펄스 
										// cnt = 1 일떄 셀렉티는 펄스
	}									// cnt = 0 일때 셀릭티는 펄스 순서 해서 하노이처럼 노드그려서 연상 
	
			//permutation(cnt+1);  	28~35줄 여기까지만 for문돌듯 돌다가 cnt가 for문횟수에 맞춰진다면 탈출 
			//permutation(cnt+1); 끝날때는 이번 cnt번째에 i를 넣는 모든경우를 이미 다 고려했을때
			//isSelected[i] = false; 탈출된후 가장 최근for문부터 false 초기화시키며 스택에쌓인 재귀들 풀어냄 
			// 다풀어진다면 그후 첫번째 인덱스인 i를 1에서 ->2로 증가시킴 그후 다시 for문돌듯 돈다  

}
