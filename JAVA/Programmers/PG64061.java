/*
문제 : 크레인 인형뽑기 게임
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/64061
*/

import java.util.Stack;

public class PG64061 {
	public static void main(String args[]) {
		System.out.println(solution(new int[][] { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 },
				{ 4, 2, 4, 4, 2 }, { 3, 5, 1, 3, 1 } }, new int[] { 1, 5, 3, 5, 1, 2, 1, 4 }));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		Stack<Integer> stack = new Stack<>(); // 바구니

		for (int i = 0; i < moves.length; i++) {
			int pick = 0;
			for (int h = 0; h < board.length; h++) {
				if (board[h][moves[i] - 1] != 0) {
					// 인형 집기
					pick = board[h][moves[i] - 1];
					board[h][moves[i] - 1] = 0;

					// 바구니로 옮기기
					if (!stack.isEmpty() && stack.peek() == pick) {
						stack.pop();
						answer += 2;
					} else {
						stack.push(pick);
					}
					break;
				}
			}
		}
		return answer;
	}
}
