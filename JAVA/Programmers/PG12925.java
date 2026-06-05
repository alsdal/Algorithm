/*
문제 : 문자열을 정수로 바꾸기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/12925
*/

public class PG12925 {
	public static void main(String[] args) {
		System.out.println(solution("1234"));
	}

	public static int solution(String s) {
	    int num = 0;
	    int sign = 1;
	    int idx = 0;

	    if (s.charAt(0) == '-') {
	        sign = -1;
	        idx = 1;
	    } else if (s.charAt(0) == '+') {
	        idx = 1;
	    }

	    for (int i = idx; i < s.length(); i++) {
	        num = num * 10 + (s.charAt(i) - '0');
	    }

	    return num * sign;
	}
	
//    public static int solution(String s) {
//        return Integer.parseInt(s);
//    }
}
