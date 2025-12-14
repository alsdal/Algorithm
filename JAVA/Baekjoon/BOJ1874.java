import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/*
문제 : 스택 수열
유형 : 자료구조, 스택
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/1874
*/

public class BOJ1874 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int top = 1;
		Stack<Integer> stack = new Stack<>();

		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			int input = Integer.parseInt(br.readLine());
			while(input >= top) {
				stack.push(top++);
				sb.append("+\n");
			}
			if(stack.peek()!=input) {
				System.out.println("NO");
				return;
			}
			stack.pop();
			sb.append("-\n");				
		}
		System.out.println(sb);
	}
}