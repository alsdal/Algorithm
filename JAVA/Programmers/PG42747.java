/*
문제 : H-Index
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42747
*/

import java.util.Arrays;

public class PG42747 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 3, 0, 6, 1, 5 }));
	}

	public static int solution(int[] citations) {
		int answer = 0;

		int n = citations.length;
		Arrays.sort(citations);

		for (int i = 0; i < n; i++) {
			int h = n - i;

			if (citations[i] >= h) {
				answer = h;
				break;
			}
		}

		return answer;
	}
}
