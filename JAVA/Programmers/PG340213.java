/*
문제 : 동영상 재생기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/340213
*/

public class PG340213 {
	public static void main(String[] args) {
		System.out.println(solution("34:33", "13:00", "00:55", "02:55", new String[] { "next", "prev" }));
		System.out.println(solution("10:55", "00:05", "00:15", "06:55", new String[] { "prev", "next", "next" }));
	}

	public static String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
		// 시간 int로 변환
		int end = convertTime(video_len);
		int cur = convertTime(pos);
		int opStart = convertTime(op_start);
		int opEnd = convertTime(op_end);

		// 시작 위치가 오프닝인 경우 건너뛰기
		if (cur >= opStart && cur <= opEnd) {
			cur = opEnd;
		}

		for (String command : commands) {
			// 10초 전 이동
			if (command.equals("prev")) {
				if (cur < 10) {
					cur = 0;
				} else {
					cur -= 10;
				}
			}
			// 10초 후 이동
			else {
				if (cur > end - 10) {
					cur = end;
				} else {
					cur += 10;
				}
			}

			// 오프닝 건너뛰기
			if (cur >= opStart && cur <= opEnd) {
				cur = opEnd;
			}
		}

		// String으로 변환
		int min = cur / 60;
		int sec = cur % 60;

		return String.format("%02d:%02d", min, sec);
	}

	public static int convertTime(String s) {
		String[] str = s.split(":");
		String mm = str[0];
		String ss = str[1];
		return Integer.parseInt(mm) * 60 + Integer.parseInt(ss);
	}
}
