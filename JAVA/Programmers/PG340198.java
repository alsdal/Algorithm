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
		// 크기 오름차순 정렬
		Arrays.sort(mats);

		// 돗자리 크기 큰 순서로 역순으로 탐색
		for (int i = mats.length - 1; i >= 0; i--) {
			int size = mats[i];
			// 돗자리의 왼쪽상단 끝점 기준으로 돗자리 크기만큼 완전탐색
			for (int r = 0; r < park.length - size + 1; r++) {
				for (int c = 0; c < park[0].length - size + 1; c++) {
					if (canPlace(r, c, size, park)) {
						return size;
					}
				}
			}
		}

		return -1;
	}

	// 다른 돗자리가 자리에 있다면 false
	public static boolean canPlace(int r, int c, int size, String[][] park) {
		for (int i = r; i < r + size; i++) {
			for (int j = c; j < c + size; j++) {
				if (!park[i][j].equals("-1")) {
					return false;
				}
			}
		}
		return true;
	}
}
