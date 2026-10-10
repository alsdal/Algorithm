/*
문제 : 조이스틱
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42860
*/

public class PG42860 {
	public int solution(String name) {
		int answer = 0;
		int n = name.length();

		// 좌우 이동 횟수
		int move = n - 1;

		for (int i = 0; i < n; i++) {
			char c = name.charAt(i);

			// 상하 이동 최소 횟수
			answer += Math.min(c - 'A', 'Z' - c + 1);

			// A 건너뛰기
			int next = i + 1;
			while (next < n && name.charAt(next) == 'A') {
				next++;
			}

			// 오른쪽 갔다가 되돌아 오는 경우
			move = Math.min(move, i * 2 + n - next);
			// 반대편 먼저 방문
			move = Math.min(move, i + 2 * (n - next));
		}
		return answer + move;
	}
}
