/*
문제 : 이웃한 칸
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/250125
*/

public class PG250125 {
	public static void main(String[] args) {
		System.out
				.println(
						solution(
								new String[][] { { "blue", "red", "orange", "red" }, { "red", "red", "blue", "orange" },
										{ "blue", "orange", "red", "red" }, { "orange", "orange", "red", "blue" } },
								1, 1));

		System.out.println(solution(new String[][] { { "yellow", "green", "blue" }, { "blue", "green", "yellow" },
				{ "yellow", "blue", "blue" } }, 0, 1));
	}

	public static int solution(String[][] board, int h, int w) {
		int n = board.length;
		int cnt = 0;
		String color = board[h][w]; // 현재 칸의 색

		// 방향 벡터
		int[] dw = { 0, 1, 0, -1 };
		int[] dh = { -1, 0, 1, 0 };

		for (int i = 0; i < 4; i++) {
			int nw = w + dw[i];
			int nh = h + dh[i];

			if (nw >= 0 && nw < n && nh >= 0 && nh < n) {
				if (board[nh][nw].equals(color)) {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
