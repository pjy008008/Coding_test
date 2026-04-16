import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> -(o1 - o2));

		int x = Integer.parseInt(br.readLine());
		max.offer(x);
		sb.append(x).append("\n");

		for (int i = 1; i < n; i++) {
			x = Integer.parseInt(br.readLine());
			if (x > max.peek()) {
				min.offer(x);
			} else {
				max.offer(x);
			}

			if (min.size() > max.size()) {
				max.offer(min.poll());
			} else if (max.size() > min.size() + 1) {
				min.offer(max.poll());
			}

			sb.append(max.peek()).append("\n");
		}
		System.out.println(sb);
	}
}
