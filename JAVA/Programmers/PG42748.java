/*
문제 : K번째수
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42748
 */

import java.util.Arrays;

public class PG42748 {
	public static void main(String[] args) {
		int[] arr = solution(new int[] { 1, 5, 2, 6, 3, 7, 4 }, new int[][] { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } });
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int m = 0; m < commands.length; m++) {
			int i = commands[m][0];
			int j = commands[m][1];
			int k = commands[m][2];

			int[] newArr = Arrays.copyOfRange(array, i - 1, j);
			Arrays.sort(newArr);

			answer[m] = newArr[k - 1];
		}
		return answer;
	}
}
