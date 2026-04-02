/*
문제 : 효율적인 해킹
유형 : 그래프, DFS, BFS
난이도 : 실버1
링크 : https://www.acmicpc.net/problem/1325
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325 {
	static int N, M;
	static List<Integer>[] list;
	static int[] numHacked;

	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
		M = Integer.parseInt(st.nextToken()); // 관계 수

		list = new ArrayList[N + 1]; // 컴퓨터 연결 정보
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		numHacked = new int[N + 1]; // 최대 해킹 가능한 컴퓨터 수

		// 캄퓨터 연결 정보 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[B].add(A);
		}

		// bfs 수행해서 해킹 가능한 컴퓨터수, 최대 해킹 가능 수 구하기
		int maxHacked = 0;
		for (int i = 1; i <= N; i++) {
			numHacked[i] = bfs(i);
			maxHacked = Math.max(maxHacked, numHacked[i]);
		}
		
		// 정답 출력
		for (int i = 1; i <= N; i++) {
			if(numHacked[i] == maxHacked) {
				sb.append(i + " ");
			}
		}
		System.out.println(sb);
	}

	public static int bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(v);

		boolean[] visited = new boolean[N + 1];
		visited[v] = true;

		int cnt = 1; // 해킹 가능한 컴퓨터 수
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int next : list[cur]) {
				if (!visited[next]) {
					queue.add(next);
					visited[next] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
