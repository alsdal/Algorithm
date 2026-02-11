/*
문제 : 수 정렬하기 3
유형 : 누적합
난이도 : 브론즈1
링크 : https://www.acmicpc.net/problem/10989
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ10989 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
//		ArrayList<Integer> arr = new ArrayList<>();
		int[] arr = new int[N];
		
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
//			arr.add(Integer.parseInt(br.readLine()));
		}
//		Collections.sort(arr);
		Arrays.sort(arr);
		for(int i : arr) {
			sb.append(i).append('\n');
		}
		System.out.println(sb);
	}
}