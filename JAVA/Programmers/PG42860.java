/*
문제 : 조이스틱
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42860
*/

public class PG42860 {
	public int solution(String name) {
		int answer = 0;
		int n = name.length();

		// 좌우로 이동하는 기본 횟수
		int move = n - 1;

		for (int i = 0; i < n; i++) {
			char c = name.charAt(i);

			// 상하 이동 중 최소 횟수
			answer += Math.min(c - 'A', 'Z' - c + 1);

			// 현재 위치 다음에 나오는 연속된 A 구간 건너뛰기
			int next = i + 1;

			while (next < n && name.charAt(next) == 'A') {
				next++;
			}

			// 오른쪽으로 갔다가 되돌아가는 경우
			move = Math.min(move, i * 2 + n - next);

			// 반대편을 먼저 방문한 뒤 돌아오는 경우
			move = Math.min(move, i + 2 * (n - next));
		}

		return answer + move;
	}
}
