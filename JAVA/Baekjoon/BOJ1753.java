import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1753 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken()); // 정점의 수
		int E = Integer.parseInt(st.nextToken()); // 간선의 수
		int K = Integer.parseInt(br.readLine()); // 시작 정점
		
		// 인접 리스트 초기화
		ArrayList<ArrayList<Edge>> list = new ArrayList<>();		
		for (int i = 0; i <= V; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());	// 시작 노드
			int v = Integer.parseInt(st.nextToken());	// 도착 노드
			int w = Integer.parseInt(st.nextToken());	// 가중치
			list.get(u).add(new Edge(v,w));
		}
		// 최단 거리 배열 초기화
		int[] D = new int[V+1];
		for (int i = 0; i <= V; i++) {
			D[i] = Integer.MAX_VALUE;
		}
		// 시작 노드 초기화
		PriorityQueue<Edge> queue = new PriorityQueue<Edge>();	// 거리순 정렬
		queue.add(new Edge(K,0));
		D[K] = 0;
		boolean[] visited = new boolean[V+1]; // 방문 처리
		visited[K] = true;
		
		// 최단 거리 구하기 
		while(!queue.isEmpty()) {
			Edge cur = queue.poll();
			for (Edge next : list.get(cur.vertex)) {
					if(D[next.vertex] > D[cur.vertex] + next.weight) {
						D[next.vertex] = D[cur.vertex]+next.weight;	// 최소 거리 갱신
						visited[next.vertex] = true;
						queue.add(new Edge (next.vertex,D[next.vertex]));						
				}
			}
		}
		// 결과 출력
		for (int i = 1; i <= V; i++) {
			if(visited[i])
				System.out.println(D[i]);
			else
				System.out.println("INF");
		}
	}
}

class Edge implements Comparable<Edge>{
	int vertex, weight;

	Edge(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
	public int compareTo(Edge e) {
		return this.weight-e.weight;
	}
}