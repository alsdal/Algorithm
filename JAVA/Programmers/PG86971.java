
/*
문제 : 전력망을 둘로 나누기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/86971
*/
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PG86971 {
	public static void main(String[] args) {
		System.out.println(solution(9,
				new int[][] { { 1, 3 }, { 2, 3 }, { 3, 4 }, { 4, 5 }, { 4, 6 }, { 4, 7 }, { 7, 8 }, { 7, 9 } }));
	}

	public static int solution(int n, int[][] wires) {
		// 인접리스트 초기화
		List<List<Integer>> graph = new ArrayList<>();

		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		for (int[] wire : wires) {
			int a = wire[0];
			int b = wire[1];
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		int answer = n;

		// 전선 하나씩 끊어서 bfs

		for (int[] wire : wires) {
			int count = bfs(wire, graph, n);
			int diff = Math.abs(count - (n - count));
			answer = Math.min(answer, diff);
		}

		return answer;
	}

	public static int bfs(int[] cut, List<List<Integer>> graph, int n) {
		int a = cut[0];
		int b = cut[1];

		boolean[] visited = new boolean[n + 1];
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(a);
		visited[a] = true;
		int cnt = 0;

		while (!queue.isEmpty()) {
			int cur = queue.poll();
			cnt++;

			for (int next : graph.get(cur)) {
				if (cur == a && next == b || cur == b && next == a) {
					continue;
				}
				if (visited[next]) {
					continue;
				}
				visited[next] = true;
				queue.offer(next);
			}
		}
		return cnt;
	}
}
