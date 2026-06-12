/*
문제 : 소수 찾기
난이도 : 실버2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42839
 */

import java.util.HashSet;
import java.util.Set;

public class PG42839 {
	public static void main(String[] args) {
		System.out.println(solution("17"));
		System.out.println(solution("011"));
	}

	static Set<Integer> set = new HashSet<>();

	public static int solution(String numbers) {
		int answer = 0;

		boolean[] visited = new boolean[numbers.length()];

		// 만들 수 있는 숫자 구하기
		dfs(numbers, "", visited);

		// 만든 숫자가 소수이면 개수 세기
		for (int num : set) {
			if (isPrime(num)) {
				answer++;
			}
		}

		return answer;
	}

	public static void dfs(String numbers, String cur, boolean[] visited) {
		if (!cur.isEmpty()) {
			set.add(Integer.parseInt(cur));
		}

		for (int i = 0; i < numbers.length(); i++) {
			if (!visited[i]) {
				visited[i] = true;
				dfs(numbers, cur + numbers.charAt(i), visited);
				visited[i] = false;
			}
		}
	}

	// 소수 판별
	public static boolean isPrime(int n) {
		if (n < 2) {
			return false;
		}

		for (int i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}

		return true;
	}
}
