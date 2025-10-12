import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
문제 : 연결 요소의 개수
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/11724
 */

public class BOJ11724 {
    static List<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
        	graph[i] = new ArrayList<>();
        }
        visited = new boolean[N + 1];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            graph[u].add(v);
            graph[v].add(u);
        }

        int count = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        System.out.println(count);
    }

    static void dfs(int start) {
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(start);
        visited[start] = true;

        while (!stack.isEmpty()) {
            int v = stack.pop();
            for (int next : graph[v]) {
                if (!visited[next]) {
                    visited[next] = true;
                    stack.push(next);
                }
            }
        }
    }
	
	
	
	
	
	
	
	
//	static int[][] graph;
//	static boolean[] visited;
	
//	public static void main(String[] args) throws IOException {
//		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		
//		int N = Integer.parseInt(st.nextToken());
//		int M = Integer.parseInt(st.nextToken());
//		
//		graph = new int[N+1][N+1];
//		visited = new boolean[N+1];
//		
//		for (int i = 0; i < M; i++) {
//			st = new StringTokenizer(br.readLine());
//			int u = Integer.parseInt(st.nextToken());
//			int v = Integer.parseInt(st.nextToken());
//			graph[u][v] = graph[v][u] = 1;
//		}
//		
//		int count = 0;
//		for (int i = 1; i <= N; i++) {
//			if(!visited[i]) {
//				dfs(i);
//				count++;
//			}
//		}
//		System.out.println(count);
//	}
//	
//	public static void dfs(int v) {
//		visited[v] = true;
//		for (int i = 1; i < graph.length; i++) {
//			if(graph[v][i] == 1 && !visited[i]) {
//				dfs(i);
//			}
//		}
//	}
}