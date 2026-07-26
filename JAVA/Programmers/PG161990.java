/*
문제 : 바탕화면 정리
난이도 : 2
링크 : https://school.programmers.co.kr/learn/courses/30/lessons/161990
*/

public class PG161990 {
	public static void main(String[] args) {
		int[] arr = solution(new String[] {
				".#...",
				"..#..",
				"...#." });
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(new String[] {
				"..........",
				".....#....",
				"......##..",
				"...##.....",
				"....#....."});
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
		System.out.println();
		arr = solution(new String[] {
				".##...##.",
				"#..#.#..#",
				"#...#...#",
				".#.....#.",
				"..#...#..",
				"...#.#...",
				"....#...."});
		
		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static int[] solution(String[] wallpaper) {
		int lux = wallpaper.length, luy = wallpaper[0].length(), rdx = 0, rdy = 0;
		
		for (int x = 0; x < wallpaper.length; x++) {
			int y = 0;
			for (char c : wallpaper[x].toCharArray()) {
				if (c == '#') {
					lux = Math.min(lux, x);
					luy = Math.min(luy, y);
					rdx = Math.max(rdx, x);
					rdy = Math.max(rdy, y);					
				}
				y++;
			}
		}
		
		return new int[] { lux, luy, rdx + 1, rdy + 1 };
	}
}
