/*
문제 : N으로 표현
난이도 : 3
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42895
*/

import java.util.HashSet;
import java.util.Set;

public class PG42895 {
	public static void main(String[] args) {
		System.out.println(solution(5, 12));
		System.out.println(solution(2, 11));
	}

	public static int solution(int N, int number) {
		Set<Integer>[] dp = new HashSet[9];
		for (int i = 1; i < dp.length; i++) {
			dp[i] = new HashSet<>();
		}

		for (int i = 1; i < dp.length; i++) {
			// 이어 붙인 수
			dp[i].add(Integer.parseInt(String.valueOf(N).repeat(i)));

			// 조합 경우의 수 계산
			for (int j = 1; j < i; j++) {
				for (int a : dp[j]) {
					for (int b : dp[i - j]) {
						dp[i].add(a + b);
						dp[i].add(a - b);
						dp[i].add(a * b);
						if (b != 0) {
							dp[i].add(a / b);
						}
					}
				}
			}

			// 정답 있으면 종료
			if (dp[i].contains(number)) {
				return i;
			}
		}
		return -1;
	}
}
