/*
문제 : 나무 자르기
유형 : 이분탐색
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/2805
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2805 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken()); // 나무의 수
		int M = Integer.parseInt(st.nextToken()); // 가져갈 나무 길이
		int[] trees = new int[N];
		int highestTree = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			trees[i] = Integer.parseInt(st.nextToken());
			highestTree = Math.max(highestTree, trees[i]); // 가장 높은 나무의 높이
		}

		int s = 0;
		int e = highestTree;
		int res = 0;

		while (s <= e) {
			int m = (s + e) / 2;
			long sumTree = 0; // 자른 나무 길이의 합
			for (int i = 0; i < N; i++) {
				sumTree += Math.max(0, trees[i] - m);
			}

			if (sumTree >= M) {
				res = m;
				s = m + 1;
			} else {
				e = m - 1;
			}
		}
		System.out.println(res);
	}
}
