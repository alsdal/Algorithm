import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ18352 {
	public static ArrayList<Integer>[] list;
	public static int N, M, K, X, depth;
	public static int[] distance;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		list = new ArrayList[N + 1];	// 도시간 연결 도로 정보
		distance = new int[N + 1];		// 출발지로부터 거리 정보
        Arrays.fill(distance, -1);		// 방문하지 않은 도시 초기화
        
        // 도로 정보 입력
		for (int i = 1; i <= N; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			list[start].add(end);
		}
		// 최단거리 K인 도시 찾는 bfs 수행
		bfs(X);

	}

	public static void bfs(int v) {
		Queue<Integer> queue = new LinkedList<>();
		ArrayList<Integer> result = new ArrayList<>();
		boolean isPath = false;
		
		queue.add(v);
		distance[v] = 0;
		
		while (!queue.isEmpty()) {
			int node = queue.poll();
			for (int i : list[node]) {
				if (distance[i]==-1) {	// 방문하지 않은 도시
					distance[i] = distance[node] + 1;	// 거리 1 추가
					queue.add(i);
					// 거리 == K이면
					if (distance[i] == K) {
						result.add(i);
						isPath = true;
					}
					
				}
			}
		}
		// 최단 거리 == K 존재한다면
		if(isPath) {
			Collections.sort(result);
			for(int i : result) {
				System.out.println(i);
			}
		}
		// 최단 거리 == K 존재하지 않으면
		else {			
			System.out.println(-1);
		}
	}
}
