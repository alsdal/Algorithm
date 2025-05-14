package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1325 {
	public static ArrayList<Integer>[] list;
	public static int[] numHacked;
	public static int maxCnt = 0;
	public static int N,M;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken()); // 컴퓨터 수
		M = Integer.parseInt(st.nextToken()); // 관계 수

		list = new ArrayList[N + 1];	// 컴퓨터간 연결 정보
		numHacked = new int[N + 1];		// 한 번에 해킹할 수 있는 컴퓨터 수

		// 인접 리스트 초기화
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			list[B].add(A);
		}
		// 각 컴퓨터마다 bfs 수행
		for (int i = 1; i <= N; i++) {
			numHacked[i] = bfs(i);
			maxCnt = Math.max(numHacked[i], maxCnt);	// 최대 해킹 수 저장
		}
		// 최대 해킹 컴퓨터 번호 저장
		for (int i = 1; i <= N; i++) {
			if (numHacked[i] == maxCnt) {
				sb.append(i).append(" ");
			}
		}
		System.out.println(sb);
	}
	
	public static int bfs(int v) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[N + 1];
		int cnt = 0;	// 해킹 가능 컴퓨터 수
		q.add(v);
		visited[v] = true;
		while(!q.isEmpty()) {
			int node = q.poll();
			for (int i : list[node]) {
				if(!visited[i]) {
					q.add(i);
					visited[i] = true;
					cnt++;
				}
			}
		}
		return cnt;
	}
}
