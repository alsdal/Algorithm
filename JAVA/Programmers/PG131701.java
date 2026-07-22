/*
문제 : 연속 부분 수열 합의 개수
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/131701
*/

import java.util.HashSet;
import java.util.Set;

public class PG131701 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 7, 9, 1, 1, 4 }));
	}
	public static int solution(int[] elements) {
		int n = elements.length;

		// 원형 배열 처리
		int[] arr = new int[2 * n];
		for (int i = 0; i < n; i++) {
			arr[i] = elements[i];
			arr[i + n] = elements[i];
		}

		// 누적합 저장
		int[] pfx = new int[n * 2 + 1];
		for (int i = 0; i < n * 2; i++) {
			pfx[i + 1] = pfx[i] + arr[i];
		}

		Set<Integer> set = new HashSet<>();

		// 길이별로 부분 수열 합 추가
		for (int len = 1; len <= n; len++) {
			for (int s = 0; s < n; s++) {
				int sum = pfx[s + len] - pfx[s];
				set.add(sum);
			}
		}

		return set.size();
	}
}
