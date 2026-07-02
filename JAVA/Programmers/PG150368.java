/*
문제 : 이모티콘 할인행사
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/150368
*/

public class PG150368 {
	public static void main(String[] args) {
		int[] arr = solution(new int[][] { { 40, 10000 }, { 25, 10000 } }, new int[] { 7000, 9000 });
		for (int i : arr) {
			System.out.println(i);
		}
		arr = solution(new int[][] { { 40, 2900 }, { 23, 10000 }, { 11, 5200 }, { 5, 5900 }, { 40, 3100 }, { 27, 9200 },
				{ 32, 6900 } }, new int[] { 1300, 1500, 1600, 4900 });
		for (int i : arr) {
			System.out.println(i);
		}

	}

	static int[][] users;
	static int[] emoticons;

	static int[] saleRate = { 10, 20, 30, 40 };
	static int[] saleComb; // 할인율 중복순열 저장

	static int maxService;
	static int maxPrice;
	static int[] answer;

	public static int[] solution(int[][] users, int[] emoticons) {
		PG150368.users = users;
		PG150368.emoticons = emoticons;
		saleComb = new int[emoticons.length];

		maxService = 0;
		maxPrice = 0;

		dfs(0);
		answer = new int[] { maxService, maxPrice };
		return answer;
	}

	// 이모티콘 별 할인율 중복순열 구하기
	public static void dfs(int depth) {
		if (depth == emoticons.length) {
			calculate();
			return;
		}
		for (int i = 0; i < saleRate.length; i++) {
			saleComb[depth] = saleRate[i];
			dfs(depth + 1);
		}
	}

	// 결과 계산
	public static void calculate() {
		int serviceJoined = 0;
		int priceTotal = 0;

		for (int[] user : users) {
			int requiredSale = user[0];
			int priceLimit = user[1];
			int priceSum = 0;

			// 구매비용 구하기
			for (int i = 0; i < emoticons.length; i++) {
				if (saleComb[i] >= requiredSale) {
					priceSum += emoticons[i] * (100 - saleComb[i]) / 100;
				}
			}

			// 서비스 가입
			if (priceSum >= priceLimit) {
				serviceJoined++;
			}
			// 이모티콘 구매
			else {
				priceTotal += priceSum;
			}
		}

		if (maxService < serviceJoined) {
			maxService = serviceJoined;
			maxPrice = priceTotal;
		} else if (maxService == serviceJoined && maxPrice < priceTotal) {
			maxPrice = priceTotal;
		}
	}
}
