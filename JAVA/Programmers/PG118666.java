/*
문제 : 성격 유형 검사하기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/118666
*/

import java.util.HashMap;
import java.util.Map;

public class PG118666 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "AN", "CF", "MJ", "RT", "NA" }, new int[] { 5, 3, 2, 7, 5 }));
		System.out.println(solution(new String[] { "TR", "RT", "TR" }, new int[] { 7, 1, 3 }));
	}

	public static String solution(String[] survey, int[] choices) {
		String answer = "";

		// 성격 유형 입력
		Map<Character, Integer> map = new HashMap<>();
		map.put('R', 0);
		map.put('T', 0);
		map.put('C', 0);
		map.put('F', 0);
		map.put('J', 0);
		map.put('M', 0);
		map.put('A', 0);
		map.put('N', 0);

		// 성격 유형 점수 계산
		for (int i = 0; i < survey.length; i++) {
			char front = survey[i].charAt(0);
			char back = survey[i].charAt(1);

			int score = choices[i] - 4;
			if (score < 0) {
				map.put(front, map.get(front) - score);
			} else if (score > 0) {
				map.put(back, map.get(back) + score);
			}

		}
		System.out.println(map.entrySet());

		// 성격 유형 판단
		StringBuilder sb = new StringBuilder();

		// RT
		if (map.get('R') >= map.get('T')) {
			sb.append("R");
		} else {
			sb.append("T");
		}

		// CF
		if (map.get('C') >= map.get('F')) {
			sb.append("C");
		} else {
			sb.append("F");
		}

		// JM
		if (map.get('J') >= map.get('M')) {
			sb.append("J");
		} else {
			sb.append("M");
		}

		// AN
		if (map.get('A') >= map.get('N')) {
			sb.append("A");
		} else {
			sb.append("N");
		}

		return sb.toString();
	}
}
