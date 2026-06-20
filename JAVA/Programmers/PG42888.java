/*
문제 : 오픈채팅방 
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/42888
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class PG42888 {
	public static void main(String[] args) {
		String[] arr = solution(new String[] { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234",
				"Enter uid1234 Prodo", "Change uid4567 Ryan" });
		for (String string : arr) {
			System.out.println(string);
		}
	}

	public static String[] solution(String[] record) {
		Map<String, String> map = new HashMap<>(); // uid, 닉네임 관리
		List<String[]> log = new ArrayList<>(); // 메시지 관리

		// 기록 입력
		for (String s : record) {
			StringTokenizer st = new StringTokenizer(s);
			String command = st.nextToken();
			String uid = st.nextToken();

			switch (command) {
			case "Enter":
				String nickname = st.nextToken();
				map.put(uid, nickname);
				log.add(new String[] { uid, "Enter" });
				break;
			case "Leave":
				log.add(new String[] { uid, "Leave" });
				break;
			case "Change":
				String newName = st.nextToken();
				map.put(uid, newName);
				break;
			}
		}

		// 결과 생성
		String[] answer = new String[log.size()];
		for (int i = 0; i < log.size(); i++) {
			String uid = log.get(i)[0];
			String command = log.get(i)[1];
			String nickname = map.get(uid);

			if (command.equals("Enter")) {
				answer[i] = nickname + "님이 들어왔습니다.";
			} else {
				answer[i] = nickname + "님이 나갔습니다.";
			}
		}
		return answer;
	}
}
