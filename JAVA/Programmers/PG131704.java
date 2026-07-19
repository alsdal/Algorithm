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

		for (int target : order) {
			// 컨베이어 벨트에 실어야할 상자가 있는 경우
			while (conveyIdx < target) {
				stack.push(conveyIdx++);
			}

			// 트럭에 바로 싣기
			if (conveyIdx == target) {
				truckIdx++;
				conveyIdx++;
			}
			// 보조 벨트에서 싣기
			else if (!stack.isEmpty() && stack.peek() == target) {
				stack.pop();
				truckIdx++;
			}
			// 실을 상자가 없을 경우
			else {
				break;
			}
		}
		return truckIdx;
	}
}
