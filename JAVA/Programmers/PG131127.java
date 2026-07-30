/*
문제 : 할인 행사
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131127
*/

import java.util.HashMap;
import java.util.Map;

public class PG131127 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "banana", "apple", "rice", "pork", "pot" },
				new int[] { 3, 2, 2, 2, 1 }, new String[] { "chicken", "apple", "apple", "banana", "rice", "apple",
						"pork", "banana", "pork", "rice", "pot", "banana", "apple", "banana" }));
	}

	public static int solution(String[] want, int[] number, String[] discount) {
		int answer = 0;

		Map<String, Integer> wantMap = new HashMap<>();
		Map<String, Integer> dcMap = new HashMap<>();

		// 원하는 물품
		for (int i = 0; i < want.length; i++) {
			wantMap.put(want[i], number[i]);
		}
		// 할인 물품
		for (int i = 0; i < 10; i++) {
			dcMap.put(discount[i], dcMap.getOrDefault(discount[i], 0) + 1);
		}

		if (wantMap.equals(dcMap)) {
			answer++;
		}

		// 슬라이딩 윈도우
		for (int i = 10; i < discount.length; i++) {
			// 상품 제거
			String remove = discount[i - 10];
			dcMap.put(remove, dcMap.get(remove) - 1);
			if (dcMap.get(remove) == 0) {
				dcMap.remove(remove);
			}

			// 상품 추가
			String add = discount[i];
			dcMap.put(add, dcMap.getOrDefault(add, 0) + 1);

			if (wantMap.equals(dcMap)) {
				answer++;
			}
		}

		return answer;
	}
}
