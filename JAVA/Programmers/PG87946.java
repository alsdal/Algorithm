/*
문제 : 피로도
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */

public class PG87946 {
	public static void main(String[] args) {
		System.out.println(solution(80, new int[][] { { 80, 20 }, { 50, 40 }, { 30, 10 } }));
	}

	static boolean[] visited;
	static int answer = 0;

	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];
		dfs(k, dungeons, 0);

		return answer;
	}

	public static void dfs(int k, int[][] dungeons, int cnt) {
		answer = Math.max(answer, cnt);
		for (int i = 0; i < dungeons.length; i++) {
			if (!visited[i] && k >= dungeons[i][0]) {
				visited[i] = true;
				dfs(k - dungeons[i][1], dungeons, cnt + 1);
				visited[i] = false;
			}
		}
	}
}
