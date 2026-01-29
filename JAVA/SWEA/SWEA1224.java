/*
문제 : 계산기3
난이도 : D4
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14tDX6AFgCFAYD
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

class SWEA1224 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Stack<Character> stack = new Stack<>();

		for (int test_case = 1; test_case <= 10; test_case++) {
			int N = Integer.parseInt(br.readLine());
			String s = br.readLine();
			StringBuilder postfix = new StringBuilder();

			// postfix 변환
			for (int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				// 숫자일 경우
				if (c <= '9' && c >= '0') {
					postfix.append(c);
				}
				// 연산자일 경우
				else {
					if (c == '(') {
						stack.push(c);
					}
					if (c == '+') {
						while (!stack.isEmpty() && stack.peek() != '(') {
							postfix.append(stack.pop());
						}
						stack.push(c);
					}
					if (c == '*') {
						stack.push(c);
					}
					if (c == ')') {
						while (!stack.isEmpty() && stack.peek() != '(') {
							postfix.append(stack.pop());
						}
						stack.pop();
					}
				}
			}
			while (!stack.isEmpty()) {
				postfix.append(stack.pop());
			}
			
			// 계산하기
			Stack<Integer> cal = new Stack<>();
			for (int i = 0; i < postfix.length(); i++) {
				char c = postfix.charAt(i);
				// 숫자
				if (c <= '9' && c >= '0') {
					int num = c - '0';
					cal.push(num);
				}
				// 연산자
				else {
					if (!cal.isEmpty() && c == '*') {
						cal.push(cal.pop() * cal.pop());
					} else if(!cal.isEmpty() && c == '+' ) {
						cal.push(cal.pop() + cal.pop());
					}
				}
			}
			System.out.println("#"+test_case+" "+cal.pop());
		}
	}
}