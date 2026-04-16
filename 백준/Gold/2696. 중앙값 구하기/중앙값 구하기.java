import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			int n = Integer.parseInt(br.readLine());
			sb.append(n / 2 + 1).append("\n");
			PriorityQueue<Integer> min = new PriorityQueue<>();
			PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> {
				return -(o1 - o2);
			});
			st = new StringTokenizer(br.readLine());
			max.offer(Integer.parseInt(st.nextToken()));
			int cnt = 1;
			sb.append(max.peek()).append(" ");
			for (int j = 1; j < n; j++) {
				if (j % 10 == 0) {
					st = new StringTokenizer(br.readLine());
				}
				int x = Integer.parseInt(st.nextToken());
				if (x > max.peek()) {
					min.offer(x);
				} else {
					max.offer(x);
				}
				if (max.size() < min.size()) {
					max.offer(min.poll());
				} else if (max.size() > min.size() + 1) {
					min.offer(max.poll());
				}
				if (j % 2 == 0) {
					cnt++;
					sb.append(max.peek()).append(" ");
				}
				if (cnt == 10) {
					sb.append("\n");
					cnt = 0;
				}
			}
			sb.append("\n");
		}
		System.out.println(sb);
	}
}
