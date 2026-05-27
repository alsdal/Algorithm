/*
문제 : 키패드 누르기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/67256
*/

import java.util.HashMap;
import java.util.Map;

public class PG67256 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 }, "right"));
	}

	public static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();

		// 키패드 좌표 초기화
		Map<Integer, int[]> keypad = new HashMap<>();
		keypad.put(1, new int[] { 0, 0 });
		keypad.put(2, new int[] { 0, 1 });
		keypad.put(3, new int[] { 0, 2 });

		keypad.put(4, new int[] { 1, 0 });
		keypad.put(5, new int[] { 1, 1 });
		keypad.put(6, new int[] { 1, 2 });

		keypad.put(7, new int[] { 2, 0 });
		keypad.put(8, new int[] { 2, 1 });
		keypad.put(9, new int[] { 2, 2 });

		keypad.put(0, new int[] { 3, 1 });

		// 현재 손가락 위치
		int[] left = { 3, 0 };
		int[] right = { 3, 2 };

		// 손가락 이동
		for (int i : numbers) {
			int[] next = keypad.get(i);

			// 왼쪽 열
			if (i == 1 || i == 4 || i == 7) {
				answer.append("L");
				left = next;
			}
			// 오른쪽 열
			else if (i == 3 || i == 6 || i == 9) {
				answer.append("R");
				right = next;
			}
			// 가운데 열
			else if (i == 2 || i == 5 || i == 8 || i == 0) {
				// 손가락 거리 계산
				int leftDist = Math.abs(left[0] - next[0]) + Math.abs(left[1] - next[1]);
				int rightDist = Math.abs(right[0] - next[0]) + Math.abs(right[1] - next[1]);

				// 왼손이 가까운 경우
				if (leftDist < rightDist) {
					answer.append("L");
					left = next;
				}
				// 오른손이 가까운 경우
				else if (leftDist > rightDist) {
					answer.append("R");
					right = next;
				}
				// 거리 같은 경우
				else if (leftDist == rightDist) {
					if (hand.equals("left")) {
						answer.append("L");
						left = next;
					}
					else if (hand.equals("right")) {
						answer.append("R");
						right = next;
					}
				}
			}
		}
		return answer.toString();
	}
}
