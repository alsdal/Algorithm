/*
문제 : 짝지어 제거하기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12973
*/

import java.util.Stack;

public class PG12973 {
	public static void main(String[] args) {

	}

	public int solution(String s) {
		int answer = -1;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!stack.isEmpty()) {
				if (stack.peek() == c) {
					stack.pop();
					continue;
				}
			}
			
			stack.push(c);
		}

		if (stack.isEmpty()) {
			answer = 1;
		} else {
			answer = 0;
		}

		return answer;
	}
}
