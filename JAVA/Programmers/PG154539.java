/*
문제 : 뒤에 있는 큰 수 찾기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/154539
*/

import java.util.Arrays;
import java.util.Stack;

public class PG154539 {
	public static void main(String[] args) {
		int[] arr = solution(new int[] { 2, 3, 3, 5 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(new int[] { 9, 1, 5, 3, 6, 2 });
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(int[] numbers) {
		int[] answer = new int[numbers.length];
		Arrays.fill(answer, -1);
		
		Stack<Integer> stack = new Stack<>();
		
		for (int i = 0; i < numbers.length; i++) {
			while(!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
				int idx = stack.pop();
				answer[idx] = numbers[i];
			}
			
			stack.push(i);	
		}
		
		return answer;
	}
}
