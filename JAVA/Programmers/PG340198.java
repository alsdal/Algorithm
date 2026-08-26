/*
문제 : 공원
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/340198
*/

import java.util.Arrays;

public class PG340198 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 5, 3, 2 }, new String[][] {
				{ "A", "A", "-1", "B", "B", "B", "B", "-1" }, { "A", "A", "-1", "B", "B", "B", "B", "-1" },
				{ "-1", "-1", "-1", "-1", "-1", "-1", "-1", "-1" }, { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" },
				{ "D", "D", "-1", "-1", "-1", "-1", "-1", "F" }, { "D", "D", "-1", "-1", "-1", "-1", "E", "-1" } }));

	}

	public static int solution(int[] mats, String[][] park) {
		// 돗자리 크기 정렬
		Arrays.sort(mats);

		// 가장 큰 돗자리부터 역순으로 확인
		for (int i = mats.length - 1; i >= 0; i--) {
			int size = mats[i];
			// 돗자리의 시작 위치
			for (int x = 0; x <= park.length - size; x++) {
				for (int y = 0; y <= park[0].length - size; y++) {

					if (canPlace(x, y, size, park)) {
						return size;
					}
				}
			}
		}

		return -1;
	}

	public static boolean canPlace(int x, int y, int size, String[][] park) {
		for (int i = x; i < x + size; i++) {
			for (int j = y; j < y + size; j++) {
				if (!park[i][j].equals("-1")) {
					return false;
				}
			}
		}

		return true;
	}
}
