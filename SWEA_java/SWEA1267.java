import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class SWEA1267 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		for (int test_case = 1; test_case <= 10; test_case++) {
			StringBuilder sb = new StringBuilder();			
			StringTokenizer st = new StringTokenizer(br.readLine());
			int V = Integer.parseInt(st.nextToken());
			int E = Integer.parseInt(st.nextToken());
			st = new StringTokenizer(br.readLine());
			// 진입차수배열, 인접리스트 초기화
			int[] inDegree = new int[V + 1];
			ArrayList<Integer>[] list = new ArrayList[V + 1];
			for (int i = 0; i < V+1; i++) {
				list[i] = new ArrayList<>();
			}
			for (int i = 0; i < E; i++) {
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				list[a].add(b);
				inDegree[b]++;
			}
			// 위상 정렬
			Queue<Integer> queue = new LinkedList<>();
			for (int i = 1; i < V+1; i++) {
				if(inDegree[i]==0) {
					queue.add(i);
				}
			}
			while (!queue.isEmpty()) {
				int cur = queue.poll();
				sb.append(cur).append(" ");
				for (int i : list[cur]) {
					inDegree[i]--;
					if (inDegree[i] == 0) {
						queue.add(i);
					}
				}
			}
			System.out.println("#" + test_case + " "+ sb);
		}
	}
}