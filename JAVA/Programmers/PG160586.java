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
		int[] answer = new int[targets.length];

		// 자판 키 해싱
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < keymap.length; i++) {
			for (int j = 0; j < keymap[i].length(); j++) {
				char c = keymap[i].charAt(j);
				// 최소 눌러야하는 횟수 저장
				if (!map.containsKey(c)) {
					map.put(c, j + 1);
				} else {
					map.put(c, Math.min(map.get(c), j + 1));
				}
			}
		}

		// 자판 눌러야하는 횟수 계산
		for (int i = 0; i < targets.length; i++) {
			int cnt = 0;

			for (int j = 0; j < targets[i].length(); j++) {
				char c = targets[i].charAt(j);

				// 문자열 만들 수 없는 경우
				if (!map.containsKey(c)) {
					cnt = -1;
					break;
				}

				// 문자 입력 횟수 계산
				cnt += map.get(c);
			}

			answer[i] = cnt;
		}

		return answer;
	}
}
