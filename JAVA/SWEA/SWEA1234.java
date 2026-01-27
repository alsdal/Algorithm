/*
문제 : 비밀번호
난이도 : D3
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14_DEKAJcCFAYD
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class SWEA1234 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			String s = st.nextToken();
			for (int i = 0; i < s.length(); i++) {
				if (!stack.isEmpty() && stack.peek() == s.charAt(i)) {
					stack.pop();
				} else {
					stack.push(s.charAt(i));
				}
			}
			sb.append("#").append(test_case).append(" ");
			System.out.print(sb);
			sb = new StringBuilder();
			while (!stack.isEmpty()) {
				sb.append(stack.pop());
			}
			System.out.println(sb.reverse());
		}
	}
}