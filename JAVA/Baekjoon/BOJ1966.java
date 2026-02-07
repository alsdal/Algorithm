/*
문제 : 프린터 큐
유형 : 구현, 자료구조, 큐
난이도 : 실버3
링크 : https://www.acmicpc.net/problem/1966
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ1966 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

		for (int t = 0; t < T; t++) {

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 문서의 개수
			int M = Integer.parseInt(st.nextToken()); // 몇번째 문서

			st = new StringTokenizer(br.readLine());
			LinkedList<int[]> q = new LinkedList<>(); // { 문서 번호, 문서의 중요도 }
			for (int i = 0; i < N; i++) {
				q.offer(new int[] { i, Integer.parseInt(st.nextToken()) });
			}

			int cnt = 0; // 출력 횟수
			while (!q.isEmpty()) {
				int[] first = q.poll();
				boolean isMax = true; // 중요도 가장 높은지

				for (int i = 0; i < q.size(); i++) { // 나머지 문서와 중요도 비교
					if (first[1] < q.get(i)[1]) {
						isMax = false;
						q.offer(first); // 중요도 낮으면 뒤로 보내기
						break;
					}
				}

				if (isMax) { // 중요도 가장 높은 문서라면 출력
					cnt++;
					if (first[0] == M) {
						sb.append(cnt).append('\n');
						break;
					}
				}
			}
		}
		System.out.println(sb);
	}
}
