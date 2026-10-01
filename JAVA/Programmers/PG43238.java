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
		long answer = 0;

		Arrays.sort(times);

		// 최소 시간과 최대 시간
		long left = times[0];
		long right = (long) times[times.length - 1] * n;

		while (left <= right) {
			long mid = (left + right) / 2;
			long people = 0;

			for (int time : times) {
				people += mid / time;
			}

			// 범위 조정
			if (people >= n) {
				answer = mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}
}
