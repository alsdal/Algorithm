/*
문제 : Ladder
난이도 : D4
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?problemLevel=4&contestProbId=AV14ABYKADACFAYh&categoryId=AV14ABYKADACFAYh&categoryType=CODE&problemTitle=&orderBy=SUBMIT_COUNT&selectCodeLang=ALL&select-1=4&pageSize=10&pageIndex=1&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Solution {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		for (int test_case = 1; test_case <= 10; test_case++) {
			int[][] arr = new int[102][102];
			int T = Integer.parseInt(br.readLine());

			int max = 0;
			int sum = 0;
			for (int i = 1; i < 101; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 1; j < 101; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// X좌표 찾기
			int x=0;
			for (int i = 1; i < 101; i++) {
				if(arr[100][i] == 2) {
					x = i;
				}
			}
			
			int y=100;
			while(y!=0) {
				if(arr[y][x-1]==1) {
					while(arr[y][x-1]==1) {
						x--;						
					}
					y--;
				}
				else if (arr[y][x+1]==1) {
					while(arr[y][x+1]==1) {
						x++;						
					}
					y--;
				}
				else {
					y--;
				}
			}
			
			System.out.println("#" + T + " " + --x);
		}
	}
}
