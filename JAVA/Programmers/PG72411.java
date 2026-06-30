/*
문제 : 메뉴 리뉴얼
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/72411
*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG72411 {
	public static void main(String[] args) {
		String[] arr = solution(new String[] { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" }, new int[] { 2, 3, 4 });
		for (String s : arr) {
			System.out.println(s);
		}
	}

	static Map<String, Integer> map;
	static StringBuilder sb;

	public static String[] solution(String[] orders, int[] course) {
		List<String> answer = new ArrayList<>();

		for (int n : course) {
			map = new HashMap<>();
			for (String order : orders) {
				// 사전순 정렬해서 중복 방지
				char[] arr = order.toCharArray();
				Arrays.sort(arr);

				// 조합 구해서 map에 개수 저장
				sb = new StringBuilder();
				dfs(arr, n, 0, 0);
			}

			// 두 명 이상 주문한 메뉴중 가장 많이 주문된 메뉴 추가
			int max = 0;
			for (int cnt : map.values()) {
				if (cnt >= 2) {
					max = Math.max(max, cnt);
				}
			}
			for (String key : map.keySet()) {
				if (map.get(key) == max && max >= 2) {
					answer.add(key);
				}
			}
		}
		Collections.sort(answer);
		return answer.toArray(new String[0]);
	}

	public static void dfs(char[] arr, int n, int idx, int depth) {
		// 백트래킹
		if (depth == n) {
			String menu = sb.toString();
			map.put(menu, map.getOrDefault(menu, 0) + 1);
			return;
		}
		for (int i = idx; i < arr.length; i++) {
			sb.append(arr[i]);
			dfs(arr, n, i + 1, depth + 1);
			sb.deleteCharAt(sb.length() - 1);
		}
	}
}
