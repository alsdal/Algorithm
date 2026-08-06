/*
문제 : 요격 시스템
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/181188
*/

import java.util.Arrays;
import java.util.Comparator;

public class PG181188 {
	public static void main(String[] args) {
		System.out.println(
				solution(new int[][] { { 4, 5 }, { 4, 8 }, { 10, 14 }, { 11, 13 }, { 5, 12 }, { 3, 7 }, { 1, 4 } }));
	}

	public static int solution(int[][] targets) {
		int answer = 0;

		// 끝나느 시간 순 정렬
		Arrays.sort(targets, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[1] - b[1];
			}
		});

		int last = -1;

		// 오른쪽 끝에 맞춰 요격
		for (int[] target : targets) {
			int start = target[0];
			int end = target[1];
			if (start >= last) {
				last = end;
				answer++;
			}
		}

		return answer;
	}
}
