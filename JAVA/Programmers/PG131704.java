/*
문제 : 택배 상자
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131704
*/

import java.util.Stack;

public class PG131704 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 4, 3, 1, 2, 5 }));
		System.out.println(solution(new int[] { 5, 4, 3, 2, 1 }));
	}

	public static int solution(int[] order) {
		Stack<Integer> stack = new Stack<>();
		int truckIdx = 0;
		int conveyIdx = 1;

		while (conveyIdx <= order.length) {
			if (!stack.isEmpty()) {
				if (order[truckIdx] == stack.peek()) {
					stack.pop();
					truckIdx++;
				}
			}

			if (order[truckIdx] == conveyIdx) {
				truckIdx++;
				conveyIdx++;
			} else {
				stack.add(conveyIdx++);
			}
		}

		while (!stack.isEmpty()) {
			if (order[truckIdx] == stack.peek()) {
				stack.pop();
				truckIdx++;
			} else {
				break;
			}
		}

		return truckIdx;
	}
}
