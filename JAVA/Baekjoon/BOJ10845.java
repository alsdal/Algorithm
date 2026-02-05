/*
문제 : 큐
유형 : 자료구조, 큐
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/10845
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ10845 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());

		Deque<Integer> q = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();

			switch (cmd) {
			case "push":
				q.add(Integer.parseInt(st.nextToken()));
				break;
			case "pop":
				if (!q.isEmpty()) {
					System.out.println(q.poll());		
				}
				else {
					System.out.println(-1);
				}
				break;
			case "size":
				System.out.println(q.size());
				break;
			case "empty":
				if (q.isEmpty()) {
					System.out.println(1);
				}
				else {
					System.out.println(0);
				}
				break;
			case "front":
				if (!q.isEmpty()) {
					System.out.println(q.peek());					
				}
				else {
					System.out.println(-1);
				}
				break;
			case "back":
				if (!q.isEmpty()) {
					System.out.println(q.peekLast());					
				}
				else {
					System.out.println(-1);
				}
				break;
			}
		}
	}
}
