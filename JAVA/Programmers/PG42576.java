/*
문제 : 완주하지 못한 선수
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42576
*/

import java.util.HashMap;
import java.util.Map;

public class PG42576 {
	public static void main(String[] args) {
//		System.out.println(solution(new String[] { "leo", "kiki", "eden" }, new String[] { "eden", "kiki" }));
		System.out.println(solution(new String[] { "mislav", "stanko", "mislav", "ana" },
				new String[] { "stanko", "ana", "mislav" }));
	}

	public static String solution(String[] participant, String[] completion) {
		Map<String, Integer> map = new HashMap<>();
		// 이름 개수 카운팅
		for (String name : participant) {
			map.put(name, map.getOrDefault(name, 0) + 1);
		}

		// 완주한 이름 제거
		for (String name : completion) {
			map.put(name, map.get(name) - 1);
		}

		// 남은 이름 저장
		String answer = "";
		for (String key : map.keySet()) {
			if (map.get(key) == 1) {
				answer = key;
			}
		}
		return answer;
	}
}
