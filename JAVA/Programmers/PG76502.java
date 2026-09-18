/*
문제 : 괄호 회전하기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/76502
*/

import java.util.Stack;

public class PG76502 {
	public static int solution(String s) {
		int answer = 0;

		for (int i = 0; i < s.length(); i++) {
			String rotated = s.substring(i) + s.substring(0, i);
			if (isValid(rotated)) {
				answer++;
			}
		}
		return answer;
	}

	public static boolean isValid(String s) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (c == '(' || c == '[' || c == '{') {
				stack.push(c);
			} else {
				if (stack.isEmpty()) {
					return false;
				}
				char top = stack.pop();
				if (c == ')' && top != '(') {
					return false;
				}
				if (c == ']' && top != '[') {
					return false;
				}
				if (c == '}' && top != '{') {
					return false;
				}
			}
		}
		return stack.isEmpty();
	}
}
