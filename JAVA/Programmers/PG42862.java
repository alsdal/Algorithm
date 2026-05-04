/*
문제 : 체육복
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42862?language=java
 */

import java.util.Arrays;

public class PG42862 {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] { 2, 4 }, new int[] { 1, 3, 5 }));
	}

	public static int solution(int n, int[] lost, int[] reserve) {
		int[] clothes = new int[n + 2]; // 체육복 개수 담을 배열

		// 체육복 개수 초기화
		Arrays.fill(clothes, 1);
		for (int i : lost) {
			clothes[i]--;
		}
		for (int i : reserve) {
			clothes[i]++;
		}

		
		// 앞번호 먼저 여분 체육복 빌려주기
		for (int i = 1; i <= n; i++) {
			if (clothes[i] == 0) {
				if (clothes[i - 1] == 2) {
					clothes[i - 1]--;
					clothes[i]++;
				} else if (clothes[i + 1] == 2) {
					clothes[i + 1]--;
					clothes[i]++;
				}
			}
		}

		// 정답 출력
		int answer = 0;
		for (int i = 1; i <= n; i++) {
			if (clothes[i] >= 1) {
				answer++;
			}
		}
		return answer;
	}
}