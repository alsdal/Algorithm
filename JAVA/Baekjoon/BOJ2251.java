/*
문제 : 물통
유형 : 그래프, DFS, BFS
난이도 : 골드4
링크 : https://www.acmicpc.net/problem/2251
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ2251 {
	static int[] waterLimit = new int[3];
	static int[] sender = { 0, 0, 1, 1, 2, 2 };
	static int[] receiver = { 1, 2, 0, 2, 0, 1 };
	static boolean[][] visited;
	static TreeSet<Integer> result = new TreeSet<>(); // C의 결과값을 오름차순으로 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			waterLimit[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[201][201];
		result.add(waterLimit[2]); // 초기 C의 물통 상태

		bfs(0, 0); // 물의 양을 기준으로 bfs 수행

		for (int i : result) {
			sb.append(i).append(" ");
		}
		System.out.println(sb);
	}

	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { a, b });
		visited[0][0] = true;

		while (!q.isEmpty()) {
			int[] node = q.poll();
			int A = node[0];
			int B = node[1];
			int C = waterLimit[2] - A - B; // 전체 물의 양에서 A, B 물의 양 뺀 값

			// 물을 옮길 수 있는 6가지 경우의 수
			for (int i = 0; i < 6; i++) {
				int[] water = new int[3];
				water[0] = A;
				water[1] = B;
				water[2] = C;

				// 물 이동시키기
				water[receiver[i]] += water[sender[i]];
				water[sender[i]] = 0;

				// 물이 넘치는 경우
				if (water[receiver[i]] > waterLimit[receiver[i]]) {
					water[sender[i]] += water[receiver[i]] - waterLimit[receiver[i]];
					water[receiver[i]] = waterLimit[receiver[i]];
				}
				
				// 가능한 물의 양 중복 처리하여 큐에 저장
				if (!visited[water[0]][water[1]]) {
					visited[water[0]][water[1]] = true;
					q.add(new int[] { water[0], water[1] });
					// A가 비어있을 경우 결과값 저장
					if (water[0] == 0)
						result.add(water[2]);
				}
			}
		}
	}
}
