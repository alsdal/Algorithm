/*
문제 : 붕대 감기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/250137
*/

public class PG250137 {
	public static void main(String[] args) {
		System.out.println(
				solution(new int[] { 5, 1, 5 }, 30, new int[][] { { 2, 10 }, { 9, 15 }, { 10, 5 }, { 11, 5 } }));
		System.out.println(solution(new int[] { 3, 2, 7 }, 20, new int[][] { { 1, 15 }, { 5, 16 }, { 8, 6 } }));
		System.out.println(solution(new int[] { 4, 2, 7 }, 20, new int[][] { { 1, 15 }, { 5, 16 }, { 8, 6 } }));
		System.out.println(solution(new int[] { 1, 1, 1 }, 5, new int[][] { { 1, 2 }, { 3, 2 } }));
	}

	public static int solution(int[] bandage, int health, int[][] attacks) {
		int maxHealth = health;
		int time = 1;
		int bandageTime = 0;

		for (int[] attack : attacks) {
			while (time <= attack[0]) {

				// 공격 받은 경우
				if (time == attack[0]) {
					health -= attack[1];
					bandageTime = 0;

					if (health <= 0) {
						// 캐릭터 사망
						return -1;
					}
				}
				// 공격 받지 않은 경우
				else {
					bandageTime++;
					// 체력 회복
					health += bandage[1];
					// 추가 회복
					if (bandageTime == bandage[0]) {
						health += bandage[2];
						bandageTime = 0;
					}
					// 최대 체력 초과
					health = Math.min(maxHealth, health);
				}
				time++;
			}
		}
		return health;
	}
}
