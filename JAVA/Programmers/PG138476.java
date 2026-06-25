/*
문제 : 귤 고르기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/138476
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PG138476 {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 }));
		System.out.println(solution(4, new int[] { 1, 3, 2, 5, 4, 5, 2, 3 }));
		System.out.println(solution(2, new int[] { 1, 1, 1, 1, 2, 2, 2, 3 }));
	}

	public static int solution(int k, int[] tangerine) {
		Map<Integer, Integer> map = new HashMap<>();

		// 크기별 개수 세기
		for (int i : tangerine) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}

		// 개수 저장하여 내림차순 정렬
		List<Integer> list = new ArrayList<>(map.values());
		list.sort(Collections.reverseOrder());

		// 종류의 수 계산
		int answer = 0;
		int sum = 0;
		for (int n : list) {
			sum += n;
			answer++;

			if (sum >= k) {
				break;
			}
		}

		return answer;
	}
}
