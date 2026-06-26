/*
문제 : 주식가격
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42584
*/

import java.util.Stack;

public class PG42584 {
	public static void main(String[] args) {
		int[] arr = solution(new int[] { 1, 2, 3, 2, 3 });
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] prices) {
		int n = prices.length;
		int[] answer = new int[n];
		Stack<Integer> stack = new Stack<>();

		for (int i = 0; i < n; i++) {
			// 가격이 떨어진 경우
			while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
				int prev = stack.pop();
				answer[prev] = i - prev;
			}
			stack.push(i);
		}
		// 가격이 끝까지 떨어지지 않은 경우
		while (!stack.isEmpty()) {
			int idx = stack.pop();
			answer[idx] = n - 1 - idx;
		}

		return answer;
	}
}
