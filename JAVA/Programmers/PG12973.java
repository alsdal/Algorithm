/*
문제 : 짝지어 제거하기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12973
*/

import java.util.Stack;

public class PG12973 {
	public static void main(String[] args) {
		System.out.println(solution("baabaa"));
	}

	public static int solution(String s) {
		int answer = -1;
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (!stack.isEmpty()) {
				// 짝지어 제거
				if (stack.peek() == c) {
					stack.pop();
					continue;
				}
			}
			// 가장 끝 글자 스택에 추가
			stack.push(c);
		}

		// 모두 제거 된 경우
		if (stack.isEmpty()) {
			answer = 1;
		} else {
			answer = 0;
		}

		return answer;
	}
}
