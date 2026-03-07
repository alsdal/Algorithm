/*
문제 : DNA 비밀번호
유형 : 슬라이딩 윈도우
난이도 : 실버2
링크 : https://www.acmicpc.net/problem/12891
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ12891 {
	static int[] minDNA = new int[4]; // A, C, G, T 최소 개수
	static int[] checkDNA = new int[4]; // 현재 문자열의 A, C, G, T 개수
	static int cnt = 0;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int S = Integer.parseInt(st.nextToken()); // DNA 문자열 길이
		int P = Integer.parseInt(st.nextToken()); // 비밀번호로 사용할 부분문자열 길이
		char[] DNA = new char[S]; // DNA 문자열

		String s = br.readLine();
		for (int i = 0; i < S; i++) {
			DNA[i] = s.charAt(i);
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			minDNA[i] = Integer.parseInt(st.nextToken());
		}

		// 문자열 초기화
		for (int i = 0; i < P; i++) {
			Add(DNA[i]);
		}

		Check();

		// 슬라이딩 윈도우
		for (int j = P; j < S; j++) {
			int i = j - P;
			Add(DNA[j]);
			Remove(DNA[i]);
			Check();
		}
		System.out.println(cnt);
	}

	// DNA 문자열 추가
	static void Add(char c) {
		switch (c) {
		case 'A':
			checkDNA[0]++;
			break;
		case 'C':
			checkDNA[1]++;
			break;
		case 'G':
			checkDNA[2]++;
			break;
		case 'T':
			checkDNA[3]++;
			break;
		}
	}

	// DNA 문자열 제거
	static void Remove(char c) {
		switch (c) {
		case 'A':
			checkDNA[0]--;
			break;
		case 'C':
			checkDNA[1]--;
			break;
		case 'G':
			checkDNA[2]--;
			break;
		case 'T':
			checkDNA[3]--;
			break;
		}
	}

	// 비밀번호 사용 가능 여부 판별 후 카운팅
	static void Check() {
		boolean valid = true;
		for (int i = 0; i < 4; i++) {
			if (minDNA[i] > checkDNA[i]) {
				valid = false;
			}
		}
		if (valid)
			cnt++;
	}
}
