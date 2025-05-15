import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
 * 2109. 순회강연
 */
public class BOJ2109 {
	static int n, d, p;
	static int maxDay;
	static int totalPrice;
	
	static class Lecture {
		int price, date;
		Lecture(int price, int date){
			this.price = price;
			this.date = date;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		n = Integer.parseInt(br.readLine());
		List<Lecture> list = new ArrayList<>();
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			p = Integer.parseInt(st.nextToken());
			d = Integer.parseInt(st.nextToken());
			maxDay = Math.max(maxDay, d);
			list.add(new Lecture(p, d));
		}
		
		list.sort((o1, o2) -> o2.date - o1.date);

		PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
		int idx = 0;
		for (int day = maxDay; day > 0; day--) {
			while(idx<n && list.get(idx).date>=day) {
				queue.add(list.get(idx).price);
				idx++;
			}
			if(!queue.isEmpty()) {
				totalPrice += queue.poll();
			}
		}
		
		System.out.println(totalPrice);

	}
}
