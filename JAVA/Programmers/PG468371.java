/*
문제 : 노란불 신호등
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/468371
*/

public class PG468371 {
	public static void main(String[] args) {
		System.out.println(solution(new int[][] { { 2, 1, 2 }, { 5, 1, 1 } }));
		System.out.println(solution(new int[][] { { 2, 3, 2 }, { 3, 1, 3 }, { 2, 1, 1 } }));
	}

	public static int solution(int[][] signals) {
		int lcm = 1;

		// 신호 사이클 계산
		for (int[] lights : signals) {
			int cycle = lights[0] + lights[1] + lights[2];
			lcm = lcm(lcm, cycle);
		}

		// 노란불 겹치는 시간 탐색
		for (int time = 1; time <= lcm; time++) {
			boolean allYellow = true;

			for (int[] lights : signals) {
				int g = lights[0];
				int y = lights[1];
				int r = lights[2];

				int cycle = g + y + r;

				int pos = time % cycle;
				if (pos == 0)
					pos = cycle;

				// 하나라도 노란불이 아닌 경우
		        if (!(g < pos && pos <= g + y)) {
		            allYellow = false;
		            break;
		        }
			}

			if (allYellow) {
				return time;
			}
		}
		return -1;
	}

	public static int gcd(int a, int b) {
		while (b != 0) {
			int temp = a % b;
			a = b;
			b = temp;
		}
		return a;
	}

	public static int lcm(int a, int b) {
		return a / gcd(a, b) * b;
	}
}
