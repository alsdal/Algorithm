/*
문제 : 큰 수 만들기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42883
*/

import java.util.Stack;

public class PG42883 {
	public static void main(String[] args) {
		System.out.println(solution("1924", 2));
		System.out.println(solution("1231234", 3));
		System.out.println(solution("4177252841", 4));
	}

	public static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();
		Stack<Character> stack = new Stack<>();

		for (char num : number.toCharArray()) {
			while (k > 0 && !stack.isEmpty() && stack.peek() < num) {
				stack.pop();
				k--;
			}

			stack.push(num);
		}

		// 제거해야하는 숫자 남은 경우 뒤에서 제거
		while (k > 0) {
			stack.pop();
			k--;
		}

		for (char c : stack) {
			sb.append(c);
		}

		return sb.toString();
	}
}
