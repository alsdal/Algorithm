/*
문제 : 이진 변환 반복하기
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/70129
*/

public class PG70129 {
	public static void main(String[] args) {
		int[] arr = solution("110010101001");
		for (int i : arr) {
			System.out.println(i);
		}
	}

	public static int[] solution(String s) {
		int[] answer = {};
		int zeroCnt = 0; // 제거한 0의 개수
		int convertCnt = 0; // 변환 횟수

		while (!s.equals("1")) {
			int oneCnt = 0; // 남은 1의 개수
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					oneCnt++;
				} else {
					zeroCnt++;
				}
			}
			
			// 이진 변환
			s = Integer.toBinaryString(oneCnt);
			convertCnt++;
		}
		return new int[] { convertCnt, zeroCnt };
	}
}
