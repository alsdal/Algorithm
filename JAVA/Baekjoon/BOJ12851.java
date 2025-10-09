import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ12851 {
	static int N, K;
	static int minTime = Integer.MAX_VALUE;
	static int cnt= 0;
	static int[] time = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken()); // 수빈 위치
		K = Integer.parseInt(st.nextToken()); // 동생 위치

		bfs(N);
		System.out.println(minTime);
		System.out.println(cnt);

	}

	public static void bfs(int x) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] { x, 0 });

		while (!queue.isEmpty()) {
			int[] cur = queue.poll();
			int cx = cur[0];
			int depth = cur[1];
			
			if (cx == K) {
				if (minTime > depth) {
					minTime = depth;
					cnt = 1;
				} else if(minTime == depth) {
					cnt++;
				}
			}

			for (int i = 0; i < 3; i++) {
				int nx;
				if (i == 0) {
					nx = cx - 1;

				} else if (i == 1) {
					nx = cx + 1;

				} else {
					nx = cx * 2;
				}
				if (nx >= 0 && nx <= 100000) {
					// 처음 방문하거나 재방문
					if(time[nx] == 0 || time[nx]==depth+1) {
						queue.add(new int[] { nx, depth + 1 });
						time[nx] = depth+1;
						
					}
				}
			}

		}
	}
}