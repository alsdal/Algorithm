/*
문제 : 길찾기
난이도 : D4
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14geLqABQCFAYD
*/


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class SWEA1219 {
	static int [][] map;
	static boolean[] visited;
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			map = new int[100][2];
			visited = new boolean[100];
			StringTokenizer st = new StringTokenizer(br.readLine());
			int T = Integer.parseInt(st.nextToken());
			int numRoads = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			while(st.hasMoreTokens()) {
				int start = Integer.parseInt(st.nextToken());
				int end = Integer.parseInt(st.nextToken());
				if(map[start][0]!=0) {
					map[start][1] = end;
				} else {
					map[start][0] = end;
				}
			}
			System.out.println("#"+test_case+" "+path(0));
		}
	}
	
	public static int path(int n) {
		Stack<Integer> stack = new Stack<Integer>();
		stack.push(n);
		while(!stack.isEmpty()) {
			int node = stack.pop();
			visited[node] = true;
			if(node == 99) {
				return 1;
			}
			if(map[node][0]!=0 && visited[map[node][0]]==false) {
				stack.push(map[node][0]);
			}
			if(map[node][1]!=0 && visited[map[node][1]]==false) {
				stack.push(map[node][1]);
			}
		}
		return 0;
	}
}