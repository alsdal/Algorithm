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
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18352 {
	static int N, M, K, X;
	static List<Integer>[] list;
	static int[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken()); // 도시의 개수
		M = Integer.parseInt(st.nextToken()); // 도로의 개수
		K = Integer.parseInt(st.nextToken()); // 거리 정보
		X = Integer.parseInt(st.nextToken()); // 출발 도시 번호
		
		list = new ArrayList[N + 1];
		visited = new int[N + 1];
		
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<>();
		}
		Arrays.fill(visited, -1); // 거리 -1로 초기화

		// 도로 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()); // 출발 도시
			int B = Integer.parseInt(st.nextToken()); // 도착 도시
			list[A].add(B);
		}
		
		bfs(X);
		
		// 정답 출력
		boolean pathExists = false;
		for (int i = 1; i <= N; i++) {
			if(visited[i] == K) {
				pathExists = true;
				System.out.println(i);
			}
		}
		if(!pathExists) {
			System.out.println(-1);
		}
	}
	
	public static void bfs(int X) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(X);
		visited[X]++;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			for (int i : list[cur]) {
				if(visited[i] == -1) {
					queue.add(i);
					visited[i] = visited[cur] + 1;
				}
			}
		}		
	}
}
