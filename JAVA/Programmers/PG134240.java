/*
문제 : 푸드 파이트 대회
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/134240
*/

import java.util.Stack;

public class PG134240 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 4, 6 }));
		System.out.println(solution(new int[] { 1, 7, 1, 2 }));
	}

	public static String solution(int[] food) {
		StringBuilder sb = new StringBuilder();

		Stack<Integer> stack = new Stack<>();

		for (int i = 1; i < food.length; i++) {
			// 음식 개수 저장
			int n = food[i] / 2;

			// 왼쪽 음식 배치하고 스택에 저장
			for (int j = 0; j < n; j++) {
				sb.append(i);
				stack.add(i);
			}
		}

		// 물 배치
		sb.append(0);

		// 오른쪽 음식 배치
		while (!stack.isEmpty()) {
			sb.append(stack.pop());
		}

		return sb.toString();
	}
}
