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

	static Map<String, List<Integer>> map = new HashMap<>();

	public static int[] solution(String[] info, String[] query) {
		int[] answer = new int[query.length];

		// 지원자 정보 입력
		for (String s : info) {
			String[] arr = s.split(" ");
			makeKey(arr, 0, "");
		}

		// 점수 기준 오름차순 정렬
		for (List<Integer> list : map.values()) {
			Collections.sort(list);
		}

		// query 이분탐색
		for (int i = 0; i < query.length; i++) {
			String[] q = query[i].replaceAll(" and ", " ").split(" ");
			String key = q[0] + q[1] + q[2] + q[3];
			int score = Integer.parseInt(q[4]);

			// 조건 만족하는 지원자 없는 경우
			if (!map.containsKey(key)) {
				answer[i] = 0;
				continue;
			}

			// 조건 만족하는 지원자 수 구하기
			List<Integer> list = map.get(key);
			int idx = lowerBound(list, score);
			answer[i] = list.size() - idx;
		}

		return answer;
	}

	// 입력된 지원자 정보로 16가지 경우에 대한 key 생성
	public static void makeKey(String[] arr, int depth, String key) {
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

	// lowerBound 이분탐색하여 idx 반환
	public static int lowerBound(List<Integer> list, int score) {
		int left = 0;
		int right = list.size() - 1;
		int idx = list.size();

		while (left <= right) {
			int mid = (left + right) / 2;
			if (list.get(mid) >= score) {
				idx = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return idx;
	}
}
