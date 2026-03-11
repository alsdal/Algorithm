/*
문제 : 스택 수열
유형 : 자료구조, 스택
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/1874
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int n = Integer.parseInt(br.readLine());
		Stack<Integer> stack = new Stack<>();
		int top = 1;

		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			// 입력된 수까지 push 하기
			while (input >= top) {
				stack.push(top++);
				sb.append("+\n");
			}
			
			// 출력해야하는 수가 스택의 top 보다 작을 경우
			if (stack.peek() != input) {
				System.out.println("NO");
				return;
			}
			
			// 입력된 수까지 push 했다면 pop
			stack.pop();
			sb.append("-\n");
		}
		System.out.println(sb);
	}
}