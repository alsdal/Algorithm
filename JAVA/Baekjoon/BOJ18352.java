/*
문제 : 특정 거리의 도시 찾기
유형 : 그래프, 최단 경로, BFS, 다익스트라
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/18352
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18352 {
	static int N, M, K, X;
	static ArrayList<Integer>[] list;
	static int[] visited;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		// 변수 입력 및 초기화
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());

		list = new ArrayList[N + 1];
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		visited = new int[N + 1];

		// 단방향 도로 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[A].add(B);
		}

		// 거리 -1 초기화
		for (int i = 1; i <= N; i++) {
			visited[i] = -1;
		}

		bfs(X);

		// 정답 출력
		boolean isAnswer = false;
		for (int i = 0; i <= N; i++) {
			if (visited[i] == K) {
				isAnswer = true;
				System.out.println(i);
			}
		}
		if (!isAnswer) {
			System.out.println(-1);
		}
	}

	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(v);
		visited[v]++;

		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i : list[node]) {
				if (visited[i] == -1) {
					visited[i] = visited[node] + 1;
					queue.add(i);
				}
			}
		}
	}
}
