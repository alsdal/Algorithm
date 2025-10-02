/*
문제 : 부족한 금액 계산하기
난이도 : 1
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/82612
 */


public class PG82612 {
	public static void main(String[] args) {
		System.out.println(solution(3,20,4));
	}
	
    public static long solution(int price, int money, int count) {
        long answer, temp = 0, total = 0;     
        for (int i = 1; i <= count; i++) {
			temp += i;
		}
        total = (temp * price);
        if(total < money) {
        		answer = 0;
        } else {
        		answer = total - money;
        }
        return answer;
    }
}
