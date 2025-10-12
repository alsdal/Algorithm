import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11724 {
	static int[][] graph;
	static boolean[] visited;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		graph = new int[N+1][N+1];
		visited = new boolean[N+1];
		
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			graph[u][v] = graph[v][u] = 1;
		}
		
		int count = 0;
		for (int i = 1; i <= N; i++) {
			if(!visited[i]) {
				dfs(i);
				count++;
			}
		}
		System.out.println(count);
	}
	
	public static void dfs(int v) {
		visited[v] = true;
		for (int i = 1; i < graph.length; i++) {
			if(graph[v][i] == 1 && !visited[i]) {
				dfs(i);
			}
		}
	}
}

/*
1-2
|/
5
3-4-6
*/