

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ1759 {
	public static char[] letters;
	public static char[] password;
	public static boolean[] visited;
	public static int L, C;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		password = new char[L];
		letters = new char[C];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < C; i++) {
			letters[i] = st.nextToken().charAt(0);
		}

		visited = new boolean[C];
		Arrays.sort(letters);
		dfs(0, 0);	// 조합 생성

	}

	public static void dfs(int start, int depth) {
		int a = 0;
		int b = 0;
		if (depth == L) {
			// 자음 모음 개수 세기
			for (char c : password) {
				if(c == 'a' || c == 'e' || c=='i' || c== 'o' || c=='u') {
					a++;
				}
				else {
					b++;
				}
			}
			// 조건 충족 확인 후 출력
			if(a>=1 && b>=2) {
				for (char c : password) {
					System.out.print(c);
				}
				System.out.println();			
			}
			return;
		}
		// 백트래킹
		for (int i = start; i < C; i++) {
			if (!visited[i]) {
				visited[i] = true;
				password[depth] = letters[i];
				dfs(i+1, depth+1);
				visited[i] = false;
			}
		}
	}
}