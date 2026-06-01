/*
문제 : 추억 점수
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/176963
*/

import java.util.HashMap;
import java.util.Map;

public class PG176963 {
	public static void main(String[] args) {
		int[] arr = solution(new String[] { "may", "kein", "kain", "radi" }, new int[] { 5, 10, 1, 3 },
				new String[][] { { "may", "kein", "kain", "radi" }, { "may", "kein", "brin", "deny" },
						{ "kon", "kain", "may", "coni" } });
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];

		// 사람별 그리움 점수 입력
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < name.length; i++) {
			map.put(name[i], yearning[i]);
		}

		// 사진 그리움 점수 계산
		for (int i = 0; i < photo.length; i++) {
			int score = 0;
			for (String person : photo[i]) {
				if (map.containsKey(person)) {
					score += map.get(person);
				}
			}
			answer[i] = score;
		}

		return answer;
	}
}
