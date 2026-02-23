/*
문제 : 제로
유형 : 자료구조, 스택, 구현
난이도 : 실버4
링크 : https://www.acmicpc.net/problem/10773
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ10773 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int K = Integer.parseInt(br.readLine()); // 정수의 개수
		int[] stack = new int[K];
		int size = 0;
		int sum = 0;
		
		for (int i = 0; i < K; i++) {
			int num = Integer.parseInt(br.readLine());
			if (num != 0) { // 스택에 저장
				stack[size++] = num;
			}
			else { // 0일 경우 스택에서 지우기
				size--;
			}
		}
		
		// 합 구하기
		for (int i = 0; i < size; i++) {
			sum += stack[i];
		}
		
		System.out.println(sum);
	}
}
