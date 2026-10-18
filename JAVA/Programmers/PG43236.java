
/*
문제 : 징검다리
난이도 : 4 
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43236
*/

import java.util.Arrays;

public class PG43236 {
	public int solution(int distance, int[] rocks, int n) {
		int answer = 0;

		Arrays.sort(rocks);

		int left = 1;
		int right = distance;

		while (left <= right) {
			int mid = (left + right) / 2;

			int removed = 0; // 제거한 바위 수
			int prev = 0; // 이전 바위 위치

			// 거리가 mid보다 작으면 바위 제거
			for (int rock : rocks) {
				if (rock - prev < mid) {
					removed++;
				} else {
					prev = rock;
				}
			}

			// 마지막 바위와 도착점 사이 거리 확인
			if (distance - prev < mid) {
				removed++;
			}

			// mid 조정
			if (removed <= n) {
				answer = mid;
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return answer;
	}
}
