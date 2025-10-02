import java.util.ArrayList;
import java.util.Arrays;

public class PG12906 {

	public static void main(String[] args) {
		int[] result = solution(new int[] {1,1,3,3,0,1,1});
		System.out.println(Arrays.toString(result));
	}

    public static int[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int prev = -1;
        
        for (int i = 0; i < arr.length; i++) {
			if(prev != arr[i]) {
				list.add(arr[i]);
				prev = arr[i];
			}
		}
        
        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
        		answer[i] = list.get(i);
        }
        return answer;
    }
}

