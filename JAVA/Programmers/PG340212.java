/*
문제 : 퍼즐 게임 챌린지
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/340212
*/

public class PG340212 {
	public int solution(int[] diffs, int[] times, long limit) {
		int answer = 0;

		// 숙련도 최소, 최대
		long left = 1;
		long right = 0;
		for (int diff : diffs) {
			right = Math.max(right, diff);
		}

		// 숙련도 기준 이분탐색
		while (left <= right) {
			long mid = (left + right) / 2;
			long time = 0;

			// 첫번째 퍼즐 시간 계산
			time = times[0];

			// 나머지 퍼즐 시간 계산
			for (int i = 1; i < diffs.length; i++) {
				long repeat = diffs[i] - mid;
				time += times[i] + (times[i] + times[i - 1]) * (Math.max(0, repeat));
			}

			// 이분탐색 범위 조정
			if (time <= limit) {
				answer = (int) mid;
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return answer;
	}
}
