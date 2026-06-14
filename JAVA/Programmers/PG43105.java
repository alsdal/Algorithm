/*
문제 : 정수 삼각형
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43105
 */

public class PG43105 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } }));
	}

	public static int solution(int[][] triangle) {
		int n = triangle.length;
		int[][] dp = new int[n][n];
		dp[0][0] = triangle[0][0];

		// 숫자 합 최대 계산
		for (int i = 1; i < n; i++) {
			// 삼각형 양쪽 끝 초기화
			dp[i][0] = dp[i - 1][0] + triangle[i][0];
			dp[i][i] = dp[i - 1][i - 1] + triangle[i][i];

			// 나머지 합 계산
			for (int j = 1; j < i; j++) {
				dp[i][j] = Math.max(dp[i - 1][j - 1], dp[i - 1][j]) + triangle[i][j];
			}
		}

		// 최대 합 계산
		int answer = 0;
		for (int num : dp[n - 1]) {
			answer = Math.max(answer, num);
		}

		return answer;
	}
}
