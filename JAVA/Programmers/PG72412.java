/*
문제 : 순위 검색
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72412
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG72412 {
	public static void main(String[] args) {
		int[] arr = solution(
				new String[] { "java backend junior pizza 150", "python frontend senior chicken 210",
						"python frontend senior chicken 150", "cpp backend senior pizza 260",
						"java backend junior chicken 80", "python backend senior chicken 50" },
				new String[] { "java and backend and junior and pizza 100",
						"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
						"- and backend and senior and - 150", "- and - and - and chicken 100",
						"- and - and - and - 150" });
		for (int i : arr) {
			System.out.println(i);
		}
	}

	static Map<String, List<Integer>> map;

	public static int[] solution(String[] info, String[] query) {
		map = new HashMap<>();
		int[] answer = new int[query.length];

		// 지원자 정보 파싱 후 키 생성
		for (String s : info) {
			String[] arr = s.split(" ");
			makeKey(arr, 0, "");
		}

		// 점수 오름차순 정렬
		for (List<Integer> list : map.values()) {
			Collections.sort(list);
		}

		// 조건 탐색
		for (int i = 0; i < query.length; i++) {
			// 쿼리 조건 추출
			String[] q = query[i].replaceAll(" and ", " ").split(" ");
			String key = q[0] + q[1] + q[2] + q[3];
			int score = Integer.parseInt(q[4]);

			// 조건 만족하는 지원자 없는 경우 예외 처리
			if (!map.containsKey(key)) {
				answer[i] = 0;
				continue;
			}

			// lower bound 이분탐색
			List<Integer> list = map.get(key);
			answer[i] = list.size() - lowerBoundIdx(list, score);
		}

		return answer;
	}

	// dfs로 키 생성
	public static void makeKey(String[] arr, int depth, String key) {
		// 키별 점수 저장
		if (depth == 4) {
			int score = Integer.parseInt(arr[4]);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList<>());
			}
			map.get(key).add(score);
			return;
		}
		makeKey(arr, depth + 1, key + arr[depth]);
		makeKey(arr, depth + 1, key + "-");
	}

	public static int lowerBoundIdx(List<Integer> list, int score) {
		// 리스트 인덱스 최소, 최대
		int left = 0;
		int right = list.size();

		while (left < right) {
			int mid = (left + right) / 2;
			if (list.get(mid) >= score) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}
