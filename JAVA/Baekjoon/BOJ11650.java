/*
문제 : 좌표 정렬하기
유형 : 정렬
난이도 : 실버5
링크 : https://www.acmicpc.net/problem/11650
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ11650 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int N = Integer.parseInt(br.readLine());
		int arr[][] = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());

		}
		
//        Arrays.sort(arr, new Comparator<int[]>() {
//            @Override
//            public int compare(int[] a, int[] b) {
//                if (a[0] == b[0]) {
//                    return a[1] - b[1];
//                } else {
//                    return a[0] - b[0];
//                }
//            }
//        });
		
		Arrays.sort(arr, (a, b) -> {
			if (a[0] == b[0]) {
				return a[1] - b[1];
			} else {
				return a[0] - b[0];
			}
		});

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < N; i++) {
			sb.append(arr[i][0] + " " + arr[i][1] + '\n');
		}
		System.out.println(sb);
	}
}
