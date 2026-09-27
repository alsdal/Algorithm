/*
문제 : n진수 게임
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17687
*/

public class PG17687 {
	public static void main(String[] args) {
		System.out.println(solution(2, 4, 2, 1));
		System.out.println(solution(16, 16, 2, 2));
	}

	public static String solution(int n, int t, int m, int p) {
		StringBuilder sequence = new StringBuilder();
		StringBuilder answer = new StringBuilder();

		int num = 0;
		while (sequence.length() < t * m) {
			sequence.append(Integer.toString(num, n));
			num++;
		}

		for (int i = 0; i < t; i++) {
			int idx = i * m + p - 1;
			answer.append(sequence.charAt(idx));
		}

		return answer.toString().toUpperCase();
	}
}
