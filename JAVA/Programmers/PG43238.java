/*
문제 : 입국심사
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43238
*/

import java.util.Arrays;

public class PG43238 {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] { 7, 10 }));
	}

	public static long solution(int n, int[] times) {
		// 심사 시간순 정렬
		Arrays.sort(times);

		long left = times[0];
		long right = (long) times[times.length - 1] * n;

		// 시간 기준 이분탐색
		while (left < right) {
			long mid = (left + right) / 2;
			long cnt = 0;

			// 심사할 수 있는 사람의 수 계산
			for (int time : times) {
				cnt += mid / time;
			}

			// lower bound 이분탐색
			if (cnt >= n) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}
}
