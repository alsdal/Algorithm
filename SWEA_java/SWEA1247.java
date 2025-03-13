import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA1247 {
	public static int[][] houses;
	public static int[] arr;
	public static boolean[] visited;
	public static int N, beginX, beginY, endX, endY, distX, distY, dist;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine());

		for (int test_case = 1; test_case <= T; test_case++) {
			N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			beginX = Integer.parseInt(st.nextToken());
			beginY = Integer.parseInt(st.nextToken());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			houses = new int[N][N];
			for (int i = 0; i < N; i++) {
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				houses[i][0] = x;
				houses[i][1] = y;
			}
			// 순열 생성
			dist = Integer.MAX_VALUE;
			arr = new int[N];
			visited = new boolean[N];
			dfs(N, 0);
			System.out.println("#"+test_case+" "+dist);
		}
	}

	public static void dfs(int n, int depth) {
		if (depth == n) {
			distX = 0;
			distY = 0;
			// 거리 계산
			calDist(beginX, beginY, houses[arr[0]][0], houses[arr[0]][1]);
			for (int i = 1; i < N; i++) {
				calDist(houses[arr[i-1]][0], houses[arr[i-1]][1], houses[arr[i]][0], houses[arr[i]][1]);
			}
			calDist(houses[arr[N-1]][0], houses[arr[N-1]][1], endX, endY);
			dist = Math.min(dist, distX+distY);
			return;
		}
		for (int i = 0; i < n; i++) {
			if (!visited[i]) {
				visited[i] = true;
				arr[depth] = i;
				dfs(n, depth + 1);
				visited[i] = false;
			}
		}
	}

	public static int calDist(int startX, int startY, int destX, int destY) {
		distX += Math.abs(startX - destX);
		distY += Math.abs(startY - destY);
		return distX + distY;
	}
}