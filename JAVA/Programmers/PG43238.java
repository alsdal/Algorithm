/*
문제 : 입국심사
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43238
*/

public class PG43238 {
	public static void main(String[] args) {
		System.out.println(solution(6, new int[] { 7, 10 }));
	}

	public static long solution(int n, int[] times) {
		long answer = 0;
		long maxTime = 0;

		for (int t : times) {
			maxTime = Math.max(t, maxTime);
		}

		long left = 0;
		long right = (long) n * maxTime;

		while (left < right) {
			long mid = (left + right) / 2;
			long people = 0;

			for (int t : times) {
				people += mid / t;
			}

			if (people >= n) {
				answer = mid;
				right = mid;
			} else {
				left = mid + 1;
			}
		}

		return answer;
	}
}
