/*
문제 : 나머지가 1이 되는 수 찾기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87389
 */

public class PG87389 {
	public static void main(String[] args) {
		System.out.println(solution(10));
	}

	public static int solution(int n) {
		for (int x = 1; x < n; x++) {
			if (n % x == 1) {
				return x;
			}
		}
		return 0;
	}
}
