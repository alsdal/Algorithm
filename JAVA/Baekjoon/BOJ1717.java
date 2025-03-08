package BOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1717 {
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		arr = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			arr[i] = i;
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int op = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());

			// union
			if (op == 0) {
				union(a, b);
			}
			// find
			if (op == 1) {
				if (find(a) == find(b)) {
					System.out.println("YES");
				} else {
					System.out.println("NO");
				}
			}
		}
	}

	// 대표 노드끼리 연결
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		// 대표 노드 연결
		if (x != y) {
			arr[y] = x;
		}
	}

	// 대표 노드 찾아서 값 갱신하고 저장
	public static int find(int x) {
		// 대표 노드일 경우
		if (x == arr[x]) {
			return x;
		}
		// 대표 노드 아닐 경우
		else {
			arr[x] = find(arr[x]);
			return arr[x];
		}
	}
}
