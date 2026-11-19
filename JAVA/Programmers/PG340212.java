/*
문제 : 퍼즐 게임 챌린지
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/340212
*/

public class PG340212 {
	public int solution(int[] diffs, int[] times, long limit) {
		// 가장 어려운 난이도 구하기
		int maxDiff = 0;
		for (int diff : diffs) {
			maxDiff = Math.max(maxDiff, diff);
		}

		// 최소, 최대 숙련도
		int left = 1;
		int right = maxDiff;

		// 이분탐색
		while (left < right) {
			int mid = (left + right) / 2;

			// 총 소요 시간 계산
			long time = times[0];
			for (int i = 1; i < diffs.length; i++) {
				int repeat = diffs[i] - mid;
				// 숙련도가 난이도와 같거나 높은 경우
				if (repeat <= 0) {
					time += times[i];
				}
				// 숙련도가 난이도 보다 낮은 경우
				else {
					time += repeat * (times[i - 1] + times[i]) + times[i];
				}
			}

			// lower bound
			if (time <= limit) {
				right = mid;
			} else {
				left = mid + 1;
			}
		}
		return right;
	}
}
