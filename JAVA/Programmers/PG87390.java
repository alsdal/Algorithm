/*
문제 : n^2 배열 자르기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87390
*/

public class PG87390 {
	public static void main(String[] args) {
		int[] arr = solution(2, 2, 5);
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(int n, long left, long right) {
		int size = (int) (right - left + 1); // 결과 배열 크기
		int[] answer = new int[size];

		for (int i = 0; i < size; i++) {
			long idx = left + i; // 1차원 배옇의 인덱스

			// 2차원 배열에서 행과 열의 위치
			long row = idx / n;
			long col = idx % n;

			// 2차원 배열 값 계산
			answer[i] = (int) (Math.max(row, col) + 1);
		}
		return answer;
	}
}
