
/*
문제 : ABCDE
유형 : 그래프, DFS, 백트래킹
난이도 : 골드5
링크 : https://www.acmicpc.net/problem/13023
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ13023 {
	static int N;
	static int M;
	static ArrayList<Integer>[] list;
	static boolean[] visited;
	static boolean result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		list = new ArrayList[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			list[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		for (int i = 0; i < N; i++) {
			dfs(i, 1);
		}

		if (result) {
			System.out.println(1);
		} else {
			System.out.println(0);
		}
	}

	public static void dfs(int v, int depth) {
		visited[v] = true;
		if (depth == 5) {
			result = true;
			return;
		}

		for (int i : list[v]) {
			if (!visited[i]) {
				dfs(i, depth + 1);
			}
		}
		visited[v] = false;
	}
}