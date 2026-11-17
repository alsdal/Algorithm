/*
문제 : 대충 만든 자판
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/160586
*/

import java.util.HashMap;
import java.util.Map;

public class PG160586 {
	public static void main(String[] args) {
		int[] arr = solution(new String[] { "ABACD", "BCEFD" }, new String[] { "ABCD", "AABB" });
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(String[] keymap, String[] targets) {
		// 문자별 최소 눌러야하는 횟수 저장
		Map<Character, Integer> map = new HashMap<>();
		for (String key : keymap) {
			for (int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);
				// 이미 더 적은 횟수로 입력 가능한 경우
				if (map.containsKey(c)) {
					if (map.get(c) <= i + 1) {
						continue;
					}
				}

				map.put(c, i + 1);
			}
		}

		// 눌러야하는 횟수 계산
		int[] answer = new int[targets.length];
		for (int i = 0; i < targets.length; i++) {
			int cnt = 0; // 입력 횟수
			for (int j = 0; j < targets[i].length(); j++) {
				char c = targets[i].charAt(j);
				// 입력할 수 없는 경우 예외 처리
				if (!map.containsKey(c)) {
					cnt = -1;
					break;
				}
				// 누르는 횟수 더하기
				cnt += map.get(c);
			}
			answer[i] = cnt;
		}

		return answer;
	}
}
