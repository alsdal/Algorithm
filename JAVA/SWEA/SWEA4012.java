/*
문제 : 요리사
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWIeUtVakTMDFAVH&
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class SWEA4012
{
	public static int[][] graph;
	public static void main(String args[]) throws Exception
	{
		System.setIn(new FileInputStream("src/input4.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= 1; test_case++)
		{	
			int N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			
			
			
		}
	}
}