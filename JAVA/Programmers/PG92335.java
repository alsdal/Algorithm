/*
문제 : k진수에서 소수 개수 구하기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/92335
*/

public class PG92335 {
	public static void main(String[] args) {
		System.out.println(solution(437674, 3));
		System.out.println(solution(110011, 10));
	}

	public static int solution(int n, int k) {
		int answer = 0;

		// n -> k진수로 변환
		String s = Integer.toString(n, k);

		// 0 기준 문자열 분리
		String[] arr = s.split("0+");

		// 소수 판별
		for (String str : arr) {
			if (str.isEmpty())
				continue;
			long p = Long.parseLong(str);
			if (isPrime(p)) {
				answer++;
			}
		}
		return answer;
	}

	public static boolean isPrime(long n) {
		if (n <= 1) {
			return false;
		}

		for (long i = 2; i * i <= n; i++) {
			if (n % i == 0) {
				return false;
			}
		}
		return true;
	}
}
