import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ1854 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken()); // 도시의 수
		int m = Integer.parseInt(st.nextToken()); // 도로의 수
		int k = Integer.parseInt(st.nextToken()); // k번째

		// 인접 리스트 초기화
		ArrayList<ArrayList<nNode>> list = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()); // 출발 도시
			int b = Integer.parseInt(st.nextToken()); // 도착 도시
			int c = Integer.parseInt(st.nextToken()); // 시간
			list.get(a).add(new nNode(b, c));
		}
		
		// 최단 경로 초기화
		PriorityQueue<Integer>[] dist = new PriorityQueue[n + 1]; // 각 도시까지 거리 저장
		for (int i = 0; i < n + 1; i++) {
			dist[i] = new PriorityQueue<Integer>(Collections.reverseOrder()); // k번째 꺼내기 쉽게 역순으로
		}

		// 다익스트라 최단 경로 구하기
		PriorityQueue<nNode> queue = new PriorityQueue<>();
		queue.add(new nNode(1, 0));
		dist[1].add(0);

		while (!queue.isEmpty()) {
			nNode cur = queue.poll();
			for (nNode next : list.get(cur.city)) {
				if (dist[next.city].size()<k) {	// K개까지 저장
					dist[next.city].add(cur.time + next.time);
					queue.add(new nNode(next.city, cur.time + next.time));
				}
				else if (dist[next.city].peek() > cur.time + next.time) { // 배열이 가득 찼다면 가장 큰 값을 작은 값으로 교체.
					dist[next.city].poll(); // 큰 값 삭제
					dist[next.city].add(cur.time + next.time); // 다음으로 작은 값 추가
					queue.add(new nNode(next.city, cur.time + next.time));
				}
			}
		}

		// 결과 출력
		for (int i = 1; i <= n; i++) {
			if(dist[i].size()==k) {
				System.out.println(dist[i].peek());
			}
			else {
				System.out.println(-1);
			}
		}
	}
}

class nNode implements Comparable<nNode> {
	int city, time;

	nNode(int city, int time) {
		this.city = city;
		this.time = time;
	}

	public int compareTo(nNode node) {
		return this.time - node.time;
	}
}