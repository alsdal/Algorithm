/*
문제 : 스택
유형 : 자료구조, 스택, 구현
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/10828
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10828 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] stack = new int[N];
		int size = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String s = st.nextToken();

			switch (s) {
			case "push":
				stack[size++] = Integer.parseInt(st.nextToken());
				break;
			case "pop":
				if (size > 0) {
					System.out.println(stack[--size]);
				} else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(size);
				break;
			case "empty":
				if (size == 0) {
					System.out.println(1);
				} else {
					System.out.println(0);
				}
				break;
			case "top":
				if (size != 0) {
					System.out.println(stack[size-1]);
				} else {
					System.out.println(-1);
				}
				break;
			}
		}
	}
}
