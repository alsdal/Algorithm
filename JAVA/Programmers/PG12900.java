/*
문제 : 2 x n 타일링
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12900
*/

public class PG12900 {
	public static void main(String[] args) {
		System.out.println(solution(4));
	}

	public static int solution(int n) {
		int[] dp = new int[n + 1];

		dp[1] = 1;

		if (n >= 2) {
			dp[2] = 2;
		}

		for (int i = 3; i <= n; i++) {
			dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
		}

		return dp[n];
	}
}
