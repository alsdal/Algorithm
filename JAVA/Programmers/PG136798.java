/*
문제 : 기사단원의 무기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/136798
*/

public class PG136798 {
	public static void main(String[] args) {
		System.out.println(solution(5, 3, 2));
		System.out.println(solution(10, 3, 2));
	}

	public static int solution(int number, int limit, int power) {
		int answer = 0;

		for (int i = 1; i <= number; i++) {
			int cnt = 0;

			for (int j = 1; j <= i; j++) {
				if (i % j == 0) {
					cnt++;
				}
			}

			if (cnt > limit) {
				answer += power;
			} else {
				answer += cnt;
			}
		}
		return answer;
	}
}
