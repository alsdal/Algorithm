/*
문제 : 뉴스 클러스터링
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17677
*/

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class PG17677 {
	public static void main(String[] args) {
		System.out.println(solution("FRANCE", "french"));
		System.out.println(solution("handshake", "shake hands"));
		System.out.println(solution("aa1+aa2", "AAAA12"));
		System.out.println(solution("E=M*C^2", "e=m*c^2"));
	}

	public static int solution(String str1, String str2) {
		// 두 글자 다중집합 만들어 저장
		Map<String, Integer> map1 = makeMap(str1.toLowerCase());
		Map<String, Integer> map2 = makeMap(str2.toLowerCase());

		// 집합 크기 구하기
		Set<String> keys = new HashSet<>();
		keys.addAll(map1.keySet());
		keys.addAll(map2.keySet());

		int intersection = 0; // 교집합 크기
		int union = 0; // 합집합 크기

		for (String key : keys) {
			int cnt1 = map1.getOrDefault(key, 0);
			int cnt2 = map2.getOrDefault(key, 0);

			intersection += Math.min(cnt1, cnt2);
			union += Math.max(cnt1, cnt2);
		}

		// 공집합 예외처리
		if (union == 0) {
			return 65536;
		}

		// 유사도 계산
		return (int) ((double) intersection / union * 65536);
	}

	public static Map<String, Integer> makeMap(String str) {
		Map<String, Integer> map = new HashMap<>();

		for (int i = 0; i < str.length() - 1; i++) {
			char c1 = str.charAt(i);
			char c2 = str.charAt(i + 1);

			// 영문자인 경우만 추가
			if (Character.isLetter(c1) && Character.isLetter(c2)) {
				String key = str.substring(i, i + 2);
				map.put(key, map.getOrDefault(key, 0) + 1);
			}
		}

		return map;
	}
}
