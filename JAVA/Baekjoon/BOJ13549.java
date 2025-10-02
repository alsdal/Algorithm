import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
 * 숨바꼭질3
 */

public class BOJ13549 {
	static int N, K;
	static int[] time = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		Arrays.fill(time, Integer.MAX_VALUE); // time 배열 초기화
		bfs();
		System.out.println(time[K]);
	}

	public static void bfs() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		time[N] = 0;

		while (!queue.isEmpty()) {
			int cx = queue.poll();
			if (cx * 2 <= 100000 && time[cx * 2] > time[cx]) {
				int nx = cx * 2;
				time[nx] = time[cx];
				queue.add(nx);
			}
			if (cx + 1 <= 100000 && time[cx + 1] > time[cx] + 1) {
				int nx = cx + 1;
				time[nx] = time[cx] + 1;
				queue.add(nx);
			}
			if (cx - 1 >= 0 && time[cx - 1] > time[cx] + 1) {
				int nx = cx - 1;
				time[nx] = time[cx] + 1;
				queue.add(nx);
			}
		}
	}
}
