import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1948 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine()); // 도시의 수
		int m = Integer.parseInt(br.readLine()); // 도로의 수

		// 진입차수배열, 인접리스트 초기화
		int[] inDegree = new int[n + 1]; // 진입 차수 배열
		ArrayList<ArrayList<int[]>> list = new ArrayList<>(); // 인접 리스트
		ArrayList<ArrayList<int[]>> revList = new ArrayList<>(); // 역방향 인접 리스트
		for (int i = 0; i <= n; i++) {
			list.add(new ArrayList<>());
			revList.add(new ArrayList<>());
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken()); // 도로 시작
			int e = Integer.parseInt(st.nextToken()); // 도로 끝
			int t = Integer.parseInt(st.nextToken()); // 걸리는 시간
			list.get(s).add(new int[] { e, t });
			revList.get(e).add(new int[] { s, t });
			inDegree[e]++;
		}

		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken()); // 출발 도시
		int end = Integer.parseInt(st.nextToken()); // 도착 도시

		// 위상 정렬 -> 임계 경로 배열 채우기
		int[] crtPath = new int[n + 1]; // 임계 경로
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int[] next : list.get(cur)) {
				inDegree[next[0]]--;
				crtPath[next[0]] = Math.max(crtPath[next[0]], crtPath[cur] + next[1]);
				if (inDegree[next[0]] == 0) {
					queue.add(next[0]);
				}
			}
		}

		// 쉬지 않고 달려야 하는 도로의 수 구하기
		int roadCnt = 0;
		boolean[] visited = new boolean[n + 1];
		queue = new LinkedList<>();
		queue.add(end);
		while (!queue.isEmpty()) {
			int cur = queue.poll();
			for (int[] next : revList.get(cur)) {
				if (crtPath[cur] == crtPath[next[0]] + next[1]) {	// 임계 경로일 경우
					roadCnt++;
					if (!visited[next[0]]) {	// 방문 노드 제외
						queue.add(next[0]);
						visited[next[0]] = true;
					}
				}

			}
		}
		System.out.println(crtPath[end]);
		System.out.println(roadCnt);
	}
}