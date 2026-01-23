/*
문제 : 괄호 짝짓기
난이도 : D4
링크 : https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14eWb6AAkCFAYD&categoryId=AV14eWb6AAkCFAYD&categoryType=CODE&problemTitle=1218&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1&&&&&&&&&
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

class SWEA1218 {
	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		for (int test_case = 1; test_case <= 10; test_case++) {
			Stack<Character> stack = new Stack<Character>();
			
			int T = Integer.parseInt(br.readLine());
			int result = 1;
			String s = br.readLine();
			for (int i = 0; i < T; i++) {
				char c = s.charAt(i);
				// 여는 괄호이면 스택에 push
				if(c=='(' || c=='[' || c=='{' || c=='<') {
					stack.push(c);
				}
				// 닫는 괄호 일때
				else if (c==')' || c==']' || c=='}' || c=='>') {
					// 스택에 열린 괄호가 없다면 false
					if(stack.isEmpty()) {
						result = 0;
						break;
					}
					// 여는 괄호와 일치하면 stack.pop
					if(sameParenthesis(stack.peek(),c)) {
						stack.pop();						
					}
					// 일치하지 않으면 false
					else {
						result = 0;
						break;
					}
				}
			}
			// 괄호가 남아있다면 false
			if(!stack.isEmpty()) {
				result = 0;
			}
			System.out.println("#"+test_case+" "+result);
		}
	}
	// 직전에 열린 괄호와 닫는 괄호가 일치하는지 판별
	public static boolean sameParenthesis(char open, char close) {
		if(open == '(' && close == ')') {
			return true;
		}
		else if(open == '[' && close == ']') {
			return true;
		}
		else if(open == '{' && close == '}') {
			return true;
		}
		else if(open == '<' && close == '>') {
			return true;
		}
		else return false;
	}
}