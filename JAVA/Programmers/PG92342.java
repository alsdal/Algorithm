/*
문제 : 양궁대회
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92342
*/

public class PG92342 {
	public static void main(String[] args) {
		int[] arr = solution(5, new int[] { 2, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(1, new int[] { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(9, new int[] { 0, 0, 1, 2, 0, 1, 1, 1, 1, 1, 1 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(10, new int[] { 0, 0, 0, 0, 0, 0, 0, 0, 3, 4, 3 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	static int maxDiff;
	static int[] answer;

	public static int[] solution(int n, int[] info) {
		answer = new int[] { -1 };
		maxDiff = 0;

		dfs(0, n, info, new int[11]);
		return answer;
	}

	public static void dfs(int idx, int remain, int[] apeach, int[] lion) {
		// 모든 점수 결정된 경우
		if (idx == 11) {
			// 남은 화살 0점 처리
			lion[10] += remain;

			// 점수 계산
			int lionScore = 0;
			int apeachScore = 0;
			for (int i = 0; i < 11; i++) {
				if (lion[i] == 0 && apeach[i] == 0) {
					continue;
				}

				if (lion[i] > apeach[i]) {
					lionScore += 10 - i;
				} else {
					apeachScore += 10 - i;
				}
			}

			int diff = lionScore - apeachScore;
			// 이긴 경우
			if (diff > 0) {
				// 최대 점수 차 계산
				if (diff > maxDiff) {
					maxDiff = diff;
					answer = lion.clone();
				}
				// 낮은 점수를 더 많이 맞힌 경우 선택
				else if (diff == maxDiff) {
					for (int i = 10; i >= 0; i--) {
						if (lion[i] > answer[i]) {
							answer = lion.clone();
							break;
						} else if (lion[i] < answer[i]) {
							break;
						}
					}
				}
			}
			lion[10] -= remain;
			return;
		}

		// 현재 점수에 대해 이기는 경우 백트래킹
		if (remain > apeach[idx]) {
			lion[idx] = apeach[idx] + 1;
			dfs(idx + 1, remain - lion[idx], apeach, lion);
			lion[idx] = 0;
		}

		// 현재 점수 포기
		dfs(idx + 1, remain, apeach, lion);
	}
}
