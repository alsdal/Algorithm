/*
문제 : 등굣길
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42898
 */

public class PG42898 {
	public static void main(String[] args) {
		System.out.println(solution(4, 3, new int[][] { { 2, 2 } }));
	}

	public static int solution(int m, int n, int[][] puddles) {
		long dp[][] = new long[n + 1][m + 1];
		dp[1][1] = 1;

		for (int[] puddle : puddles) {
			dp[puddle[1]][puddle[0]] = -1;
		}

		for (int y = 1; y <= n; y++) {
			for (int x = 1; x <= m; x++) {
				if (y == 1 && x == 1) {
					continue;
				}

				if (dp[y][x] == -1) {
					dp[y][x] = 0;
					continue;
				}
				dp[y][x] = (dp[y - 1][x] + dp[y][x - 1]) % 1000000007;
			}
		}
		return (int) dp[n][m];
	}
}
