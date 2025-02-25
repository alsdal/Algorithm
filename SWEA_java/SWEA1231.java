import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA1231 {
	static int N;
	static char[] tree;
	static StringBuilder sb;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		for (int test_case = 1; test_case <= 10; test_case++) {
			sb = new StringBuilder();
			N = Integer.parseInt(br.readLine());
			// 트리 입력
			tree = new char[N + 1];
			for (int i = 1; i < N + 1; i++) {
				st = new StringTokenizer(br.readLine());
				int T = Integer.parseInt(st.nextToken());
				tree[i] = st.nextToken().charAt(0);
			}
			inOrder(1);
			System.out.println("#" + test_case + " " + sb);
		}
	}
	// 중위 순회
	public static void inOrder(int i) {
		if (i > N) {
			return;
		}
		inOrder(2 * i);
		sb.append(tree[i]);
		inOrder(2 * i + 1);
	}
}
