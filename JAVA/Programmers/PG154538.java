/*
문제 : 숫자 변환하기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154538
*/

import java.util.Arrays;

public class PG154538 {
	public static void main(String[] args) {
		System.out.println(solution(10, 40, 5));
		System.out.println(solution(10, 40, 30));
		System.out.println(solution(2, 5, 4));
	}

	public static int solution(int x, int y, int n) {
		int[] dp = new int[y + 1];
		Arrays.fill(dp, 1000001);

		dp[x] = 0;

		for (int i = x + 1; i <= y; i++) {
			if (i - n >= x) {
				dp[i] = Math.min(dp[i], dp[i - n] + 1);
			}
			if (i % 2 == 0 && i / 2 >= x) {
				dp[i] = Math.min(dp[i], dp[i / 2] + 1);
			}
			if (i % 3 == 0 && i / 3 >= x) {
				dp[i] = Math.min(dp[i], dp[i / 3] + 1);
			}
		}

		return dp[y] == 1000001 ? -1 : dp[y];
	}
}
