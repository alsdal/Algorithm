/*
문제 : 구간 합 구하기 4
유형 : 누적합
난이도 : 실버3
링크 : https://www.acmicpc.net/problem/11659
 */


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		// 입력 및 초기화
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] pfx = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		// 미리 합 계산하여 입력 받기
		for (int i = 1; i < N; i++) {
			pfx[i] = pfx[i-1] + Integer.parseInt(st.nextToken());
		}
		
	
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			sb.append(pfx[b] - pfx[a-1]).append('\n');
		}
		System.out.println(sb);
	}
}

/*
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ11659 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
                
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] arr = new int[N+1];
        
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i-1] + Integer.parseInt(st.nextToken());
        }
        
        for (int i = 0; i < M; i++) {
        	st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            System.out.println(arr[b]-arr[a-1]);
        }
	}
}
*/