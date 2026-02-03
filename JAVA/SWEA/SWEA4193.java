/*
문제 : 수영대회 결승전
난이도 : D4
링크 : https://swexpertacademy.com/main/code/userProblem/userProblemDetail.do?contestProbId=AWKaG6_6AGQDFARV
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class SWEA4193 {
	static int[][] graph;
	static boolean[][] visited;
	static int[] dx = { 0, 1, 0, -1 };
	static int[] dy = { 1, 0, -1, 0 };
	static int N, A, B, C, D;
	

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int T = Integer.parseInt(br.readLine());
		for (int test_case = 1; test_case <= T; test_case++) {
			// 그래프 입력
			N = Integer.parseInt(br.readLine());
			graph = new int[N][N];
			visited = new boolean[N][N];
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					graph[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 시작, 도착 위치 입력
			st = new StringTokenizer(br.readLine());
			A = Integer.parseInt(st.nextToken());	// 시작 x
			B = Integer.parseInt(st.nextToken());	// 시작 y
			st = new StringTokenizer(br.readLine());
			C = Integer.parseInt(st.nextToken());	// 도착 x
			D = Integer.parseInt(st.nextToken());	// 도착 y
			
			System.out.println("#" + test_case + " " + bfs(A,B));	
		}
	}
	
	public static int bfs(int x, int y) {
		// 우선 순위 큐로 시간순 정렬
		PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> Integer.compare(a[2],b[2]));
		queue.add(new int[] {x,y,0});
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] node = queue.poll();
			int time = node[2];
//			System.out.println("x: "+ node[0] + " y: "+ node[1] + " time: " + node[2]);
			for (int i = 0; i < 4; i++) {
				int nx = node[0] + dx[i];
				int ny = node[1] + dy[i];
				// 좌표 유효성 검사 , 벽(1)이 아닐 때.
				if(nx>=0 && ny>=0 && nx<N && ny<N && graph[nx][ny] != 1 && !visited[nx][ny]) {
					// 벽일 때
					if(graph[nx][ny] == 0) {
						if(nx==C && ny==D) {
							return time+1;
						}
						queue.add(new int[] {nx,ny,time+1});	
						visited[nx][ny] = true;
					}
					// 소용돌이일 때
					if(graph[nx][ny] == 2) {							
						if(time % 3 == 0) {
							queue.add(new int[] {nx,ny,time+3});	
							visited[nx][ny] = true;
						}							
						if(time % 3 == 1) {
							queue.add(new int[] {nx,ny,time+2});	
							visited[nx][ny] = true;
						}							
						if(time % 3 == 2) {
							queue.add(new int[] {nx,ny,time+1});	
							visited[nx][ny] = true;
						}							
					}
				}				
			}
		}
		return -1;
	}
}