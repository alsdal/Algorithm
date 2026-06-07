/*
문제 : 공원 산책
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/172928
*/

import java.util.StringTokenizer;

public class PG172928 {
	public static void main(String[] args) {
//		int[] arr = solution(new String[] { "SOO", "OOO", "OOO" }, new String[] { "E 2", "S 2", "W 1" });
//		int[] arr = solution(new String[] { "SOO", "OXX", "OOO" }, new String[] { "E 2", "S 2", "W 1" });
		int[] arr = solution(new String[] { "OSO", "OOO", "OXO", "OOO" }, new String[] { "E 2", "S 3", "W 1" });

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

	public static int[] solution(String[] park, String[] routes) {
		int maxX = park[0].length();
		int maxY = park.length;

		// 현재 좌표
		int x = 0;
		int y = 0;

		// 시작 위치 저장
		for (int i = 0; i < maxY; i++) {
			for (int j = 0; j < maxX; j++) {
				if (park[i].charAt(j) == 'S') {
					x = j;
					y = i;
				}
			}
		}

		// 산책 구현
		for (String route : routes) {
			StringTokenizer st = new StringTokenizer(route);
			String dir = st.nextToken();
			int dist = Integer.parseInt(st.nextToken());

			// 방향벡터 저장
			int dx = 0;
			int dy = 0;
			switch (dir) {
			case "N":
				dy = -1;
				break;
			case "S":
				dy = 1;
				break;
			case "W":
				dx = -1;
				break;
			case "E":
				dx = 1;
				break;
			}

			int nx = x;
			int ny = y;
			boolean possible = true;

			// 한 칸씩 이동하며 유효성 검사
			for (int i = 0; i < dist; i++) {
				nx += dx;
				ny += dy;

				if (nx < 0 || nx >= maxX || ny < 0 || ny >= maxY) {
					possible = false;
					break;
				}

				if (park[ny].charAt(nx) == 'X') {
					possible = false;
					break;
				}
			}
			// 이동 가능할 경우 현재 좌표 갱신
			if (possible) {
				x = nx;
				y = ny;
			}
		}

		return new int[] { y, x };
	}
}
