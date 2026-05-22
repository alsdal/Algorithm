/*
문제 : 타겟 넘버
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/43165
*/

public class PG43165 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] { 1, 1, 1, 1, 1 }, 3));
	}

	static int answer;

	public static int solution(int[] numbers, int target) {
		dfs(numbers, target, 0, 0);
		return answer;
	}

	public static void dfs(int[] numbers, int target, int idx, int sum) {
		// 타겟 넘버이면 카운팅
		if (idx == numbers.length) {
			if (sum == target) {
				answer++;
			}
			return;
		}

		// 더하는 경우
		dfs(numbers, target, idx + 1, sum + numbers[idx]);
		
		// 빼는 경우
		dfs(numbers, target, idx + 1, sum - numbers[idx]);
	}
}
