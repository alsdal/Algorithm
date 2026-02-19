/*
문제 : OX퀴즈
유형 : 구현, 문자열
난이도 : 브론즈1
링크 : https://www.acmicpc.net/problem/8958
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ8958 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < N; i++) {
			int score = 0;
			int count = 1;
			
			String s = br.readLine();
			
			for (int j = 0; j < s.length(); j++) {
				char c = s.charAt(j);
				if(c == 'O') {
					score += count;
					count++;
				}
				else {
					count = 1;
				}
			}
			System.out.println(score);
		}
	}
}
