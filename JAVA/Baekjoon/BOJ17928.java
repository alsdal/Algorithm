/*
문제 : 오큰수
유형 : 자료구조, 스택
난이도 : 골드4
링크 : https://www.acmicpc.net/problem/17298
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ17928 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		Stack<Integer> stack = new Stack<>();
		
		int N = Integer.parseInt(br.readLine()); // 수열 A의 크기
		int[] arr = new int[N]; // 수열 A
		int[] ans = new int[N]; // 정답 배열
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 0; i < N; i++) {
			while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) { // 스택탑에 담긴 인덱스의 수보다 입력 받은 수가 큰 경우
				ans[stack.pop()] = arr[i]; // 오큰수 저장
			}
			stack.push(i);
		}
		
		while(!stack.isEmpty()) { // 스택에 남은 인덱스의 수 -1 처리
			ans[stack.pop()] = -1;
		}
		
		// 정답 출력
		for (int i = 0; i < N; i++) {
			sb.append(ans[i]+" ");
		}
		System.out.println(sb);
	}
}
