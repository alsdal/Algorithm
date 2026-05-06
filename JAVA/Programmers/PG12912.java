/*
문제 : 두 정수 사이의 합
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12912
 */

public class PG12912 {
	public static void main(String[] args) {
		System.out.println(solution(3, 5));
	}

	public static long solution(int a, int b) {
		long answer = 0;
		if (a > b) {
			for (int i = b; i <= a; i++) {
				answer += i;
			}
		} else {
			for (int i = a; i <= b; i++) {
				answer += i;
			}
		}
		return answer;
	}
}
