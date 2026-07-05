/*
문제 : 택배 배달과 수거하기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150369
*/

public class PG150369 {
	public static void main(String[] args) {
		System.out.println(solution(4, 5, new int[] { 1, 0, 3, 1, 2 }, new int[] { 0, 3, 0, 4, 0 }));
		System.out.println(solution(2, 7, new int[] { 1, 0, 2, 0, 1, 0, 2 }, new int[] { 0, 2, 0, 1, 0, 2, 0 }));
	}

	public static long solution(int cap, int n, int[] deliveries, int[] pickups) {
		long answer = 0;

		int d = n - 1;
		int p = n - 1;
		while (true) {
			// 가장 먼 배달 위치, 수거 위치 저장
			while (d >= 0 && deliveries[d] == 0) {
				d--;
			}
			while (p >= 0 && pickups[p] == 0) {
				p--;
			}
			
			if(d < 0 && p < 0) {
				break;
			}
			
			// 왕복 거리 추가
			answer += (long) (Math.max(d,p) + 1) * 2;

			// 배달
			int load = cap;
			while(d >= 0 && load > 0) {
				if(deliveries[d] <= load) {
					load -= deliveries[d];
					deliveries[d] = 0;
					d--;
				}
				else {
					deliveries[d] -= load;
					load = 0;
				}
			}
			
			// 수거
			load = 0;
			while(p >= 0 && load < cap) {
				if (pickups[p] <= cap - load) {
					load += pickups[p];
					pickups[p] = 0;
					p--;
				}
				else {
					pickups[p] -= cap - load;
					load = cap;
				}
			}
		}
		return answer;
	}
}
