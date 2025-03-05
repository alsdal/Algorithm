import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class BOJ2251 {
	static int[] waterLimit;
	static int[] Sender = { 0, 0, 1, 1, 2, 2 };
	static int[] Receiver = { 1, 2, 0, 1, 2, 0 };
	static boolean[][] visited;
	static TreeSet<Integer> result;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		// 물통 정보 초기화
		waterLimit = new int[3];
		for (int i = 0; i < 3; i++) {
			waterLimit[i] = Integer.parseInt(st.nextToken());
		}
		visited = new boolean[201][201];
		result = new TreeSet<>();	// C의 결과값 중복 없이 오름차순 저장
		result.add(waterLimit[2]);	// 초기 C의 물통 상태 저장
		// bfs 수행
		bfs(0,0);

		for (int i : result) {
			System.out.print(i+ " ");
		}
	}

	public static void bfs(int a, int b) {
		Queue<int[]> q = new LinkedList<>();
		q.add(new int[] { a, b });
		visited[0][0] = true;
		while (!q.isEmpty()) {
			int[] node = q.poll();
			int A = node[0];
			int B = node[1]; 
			int C = waterLimit[2] - A - B;

			// 물을 옮길 수 있는 6가지 경우
			for (int i = 0; i < 6; i++) {
				int[] water = new int[3];
				// 남아있는 물의 양 초기화
				water[0] = A;
				water[1] = B;
				water[2] = C;

				// 물 이동
				water[Receiver[i]] += water[Sender[i]];
				water[Sender[i]] = 0;
				// 물이 넘칠 경우
				if (water[Receiver[i]] > waterLimit[Receiver[i]]) {
					water[Sender[i]] += water[Receiver[i]] - waterLimit[Receiver[i]];
					water[Receiver[i]] = waterLimit[Receiver[i]];
				}
				// 동일한 물의 양 아닐 경우 큐에 저장
				if (!visited[water[0]][water[1]]) {
					visited[water[0]][water[1]] = true;
					q.add(new int[] { water[0], water[1] });
					// A가 비었을 때 C에 남아있는 물의 양 저장
					if(water[0]== 0)
						result.add(water[2]);
				}
			}
		}
	}
}
