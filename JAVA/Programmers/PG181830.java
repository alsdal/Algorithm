/*
문제 : 정사각형으로 만들기
난이도 : 0
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/181830
 */

public class PG181830 {
	public static void main(String[] args) {
		int[][] result = solution(
				new int[][] { { 572, 22, 37 }, { 287, 726, 384 }, { 85, 137, 292 }, { 487, 13, 876 } });

		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static int[][] solution(int[][] arr) {
		int colLength = arr.length;
		int rowLength = arr[0].length;

		int maxLength = Math.max(colLength, rowLength);
		int[][] answer = new int[maxLength][maxLength];

		for (int i = 0; i < colLength; i++) {
			for (int j = 0; j < rowLength; j++) {
				answer[i][j] = arr[i][j];
			}
		}
		return answer;
	}
}
