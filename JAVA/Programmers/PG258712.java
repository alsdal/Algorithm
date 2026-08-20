/*
문제 : 가장 많이 받은 선물
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/258712
*/

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class PG258712 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] { "muzi", "ryan", "frodo", "neo" }, new String[] { "muzi frodo",
				"muzi frodo", "ryan muzi", "ryan muzi", "ryan muzi", "frodo muzi", "frodo ryan", "neo muzi" }));
	}

	public static int solution(String[] friends, String[] gifts) {
		// 이름 -> 인덱스 저장
		Map<String, Integer> map = new HashMap<>();
		for (int i = 0; i < friends.length; i++) {
			map.put(friends[i], i);
		}

		// 선물 주고 받은 내역, 선물 지수 저장
		int[][] give = new int[friends.length][friends.length];
		int[] giftIdx = new int[friends.length];

		for (int i = 0; i < gifts.length; i++) {
			StringTokenizer st = new StringTokenizer(gifts[i]);

			int from = map.get(st.nextToken());
			int to = map.get(st.nextToken());

			// 준 선물 개수 추가
			give[from][to]++;

			// 선물 지수 계산
			giftIdx[from]++;
			giftIdx[to]--;
		}

		// 받을 선물 개수 계산
		int[] recieve = new int[friends.length];
		for (int i = 0; i < friends.length; i++) {
			for (int j = i + 1; j < friends.length; j++) {
				// 준 선물 개수 비교
				if (give[i][j] > give[j][i]) {
					recieve[i]++;
				} else if (give[i][j] < give[j][i]) {
					recieve[j]++;
				}

				// 주고 받은 선물 개수가 같은 경우 선물 지수 비교
				else {
					if (giftIdx[i] > giftIdx[j]) {
						recieve[i]++;
					} else if (giftIdx[i] < giftIdx[j]) {
						recieve[j]++;
					}
				}

			}
		}

		int answer = 0;

		for (int cnt : recieve) {
			answer = Math.max(answer, cnt);
		}

		return answer;
	}
}
