/*
문제 : 피로도
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/87946
 */

public class PG87946 {
	public static void main(String[] args) {
		System.out.println(solution(80, new int[][] { { 80, 20 }, { 50, 40 }, { 30, 10 } }));
	}

	static int answer = 0;
	static boolean[] visited;

	public static int solution(int k, int[][] dungeons) {
		visited = new boolean[dungeons.length];

		dfs(k, 0, dungeons);

		return answer;
	}

	public static void dfs(int k, int depth, int[][] dungeons) {
		answer = Math.max(answer, depth);

		for (int i = 0; i < dungeons.length; i++) {
			if (k >= dungeons[i][0] && !visited[i]) {
				visited[i] = true;
				dfs(k - dungeons[i][1], depth + 1, dungeons);
				visited[i] = false;
			}
		}
	}
}
