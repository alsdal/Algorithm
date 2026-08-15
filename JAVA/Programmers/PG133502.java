/*
문제 : 햄버거 만들기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/133502
*/

import java.util.Stack;

public class PG133502 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 2, 1, 1, 2, 3, 1, 2, 3, 1 }));
	}

	public static int solution(int[] ingredient) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		for (int n : ingredient) {
			stack.push(n);

			int size = stack.size();

			// 햄버거를 만들 수 있는 경우
			if (stack.size() >= 4 && stack.get(stack.size() - 4) == 1 && stack.get(stack.size() - 3) == 2
					&& stack.get(stack.size() - 2) == 3 && stack.get(stack.size() - 1) == 1) {
				
				// 스택에서 제거
				for (int i = 0; i < 4; i++) {
					stack.pop();
				}

				answer++;
			}

		}

		return answer;
	}
}
