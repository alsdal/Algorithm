import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SWEA7465 {
	public static ArrayList<Integer>[] list;
	public static boolean[] visited;
	public static int cnt;
	public static void main(String args[]) throws Exception {
		System.setIn(new FileInputStream("src/input5.txt"));

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for (int test_case = 1; test_case <= T; test_case++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			list = new ArrayList[N+1];
			for (int i = 0; i < N+1; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				list[b].add(a);
			}
			visited = new boolean[N+1];
			cnt = 0;
			for (int i = 1; i <= N; i++) {
				if(!visited[i]) {
					bfs(i);
					cnt++;
				}
			}
			System.out.println("#" + test_case + " " + cnt);
		}
		
	}
	public static void bfs(int i) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(i);
		visited[i] = true;
		while(!queue.isEmpty()) {
			int node = queue.poll();
			for (int next : list[node]) {
				if(!visited[next]) {
					queue.add(next);
					visited[next] = true;
				}
			}
		}
	}
}