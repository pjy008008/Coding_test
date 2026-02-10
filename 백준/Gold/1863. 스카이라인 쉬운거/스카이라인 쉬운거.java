import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Deque<Integer> stack = new ArrayDeque<>();
		int cnt = 0;
		stack.addFirst(0);
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			st.nextToken();
			
			int x = Integer.parseInt(st.nextToken());
			if (stack.peekFirst() < x) {
				stack.addFirst(x);
			} else {
				while (true) {
					if(stack.peekFirst()==0) {
						break;
					}
					cnt++;
					stack.removeFirst();
					if (x == stack.peekFirst()) {
						break;
					}
					if (x > stack.peekFirst()) {
						stack.addFirst(x);
						break;
					}
				}
			}
		}
		while(stack.peek()!=0) {
			stack.removeFirst();
			cnt++;
		}
		System.out.println(cnt);
	}
}
