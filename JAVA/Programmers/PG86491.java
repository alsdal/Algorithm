/*
문제 : 최소직사각형
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/86491
 */

public class PG86491 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 60, 50 }, { 30, 70 }, { 60, 30 }, { 80, 40 } }));
	}

	public static int solution(int[][] sizes) {
		int maxW = 0;
		int maxH = 0;

		for (int[] card : sizes) {
			int w = Math.max(card[0], card[1]); // 더 긴 변의 길이를 가로 길이로
			int h = Math.min(card[0], card[1]); // 두번째로 긴 변의 길이를 세로 길이로

			maxW = Math.max(maxW, w);
			maxH = Math.max(maxH, h);
		}
		return maxW * maxH;
	}
}
