/*
문제 : 최솟값 찾기
유형 : 덱, 슬라이딩 윈도우
난이도 : 골드1
링크 : https://www.acmicpc.net/problem/11003
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class BOJ11003 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken()); // 입력 받을 수의 개수
		int L = Integer.parseInt(st.nextToken()); // 최솟값 찾을 범위의 크기
		
		st = new StringTokenizer(br.readLine());
		
		Deque<Node> deque = new LinkedList<>();
		
		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());
			while (!deque.isEmpty() && deque.getLast().val > num) { // 입력 받은 수보다 크다면 덱에서 제거
				deque.removeLast();
			}
			deque.addLast(new Node(num, i)); // 덱에 다음 숫자 추가
			
			if(deque.getFirst().idx <= i - L) { // 지나간 숫자 제거
				deque.removeFirst();
			}
			sb.append(deque.getFirst().val + " ");
		}
		System.out.println(sb);
	}
	
	static class Node {
		private int val;
		private int idx;
		
		Node(int val, int idx) {
			this.val = val;
			this.idx = idx;
		}
	}
}
