import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/*
문제 : 오큰수
유형 : 스택, 자료구조
난이도 : 골드4
링크 : https://www.acmicpc.net/problem/17298
 */


public class BOJ17928 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(st.nextToken());
		int[] A = new int[N];
		int[] ans = new int[N];		
		
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			// 오큰수인 경우
			while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
				ans[stack.pop()] = A[i];	// 정답 저장하고 스택 인덱스 제거
			}
			stack.push(i);	// 스택 인덱스 푸시
		}
		
		// 스택에 남아있는 인덱스 -1
		while(!stack.isEmpty()) {
			ans[stack.pop()] = -1;
		}

		// 정답 출력
		for (int i = 0; i < N; i++) {
			sb.append(ans[i]).append(" ");
		}
	
		System.out.println(sb);
	}
}
