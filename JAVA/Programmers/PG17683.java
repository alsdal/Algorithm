/*
문제 : 방금그곡
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/17683
*/

public class PG17683 {
	public static void main(String[] args) {
		System.out
				.println(solution("ABCDEFG", new String[] { "12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF" }));
	}

	public static String solution(String m, String[] musicinfos) {
		String answer = "(None)";
		int maxPlayedTime = 0;

		for (String music : musicinfos) {
			String[] musicInfo = music.split(",");

			// 기억한 멜로디의 # -> 소문자 변환
			m = convertMelody(m);

			// 음악 길이 계산, 음악 정보 저장
			int playedTime = toMinutes(musicInfo[1]) - toMinutes(musicInfo[0]);
			String title = musicInfo[2];
			String melody = convertMelody(musicInfo[3]);

			// 재생된 멜로디 저장
			StringBuilder playedMelody = new StringBuilder();
			for (int i = 0; i < playedTime; i++) {
				playedMelody.append(melody.charAt(i % melody.length()));
			}

			// 일치하는 음악 탐색, 재생 시간 긴 음악 갱신
			if (playedMelody.toString().contains(m) && playedTime > maxPlayedTime) {
				answer = title;
				maxPlayedTime = playedTime;
			}
		}
		return answer;
	}

	// 멜로디 #문자 변환
	public static String convertMelody(String melody) {
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < melody.length(); i++) {
			char note = melody.charAt(i);
			if (i + 1 < melody.length() && melody.charAt(i + 1) == '#') {
				sb.append(Character.toLowerCase(note));
				i++;
			} else {
				sb.append(note);
			}
		}
		return sb.toString();
	}

	// 시간 String -> int 변환
	public static int toMinutes(String time) {
		String[] hhmm = time.split(":");
		return Integer.parseInt(hhmm[0]) * 60 + Integer.parseInt(hhmm[1]);
	}
}
