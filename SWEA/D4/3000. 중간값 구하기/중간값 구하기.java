import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			PriorityQueue<Integer> max = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
			PriorityQueue<Integer> min = new PriorityQueue<>();
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int sum = 0;
			max.offer(a);
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				for (int k = 0; k < 2; k++) {
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
				}
				sum += max.peek();
				sum %= 20171109;
			}
			sb.append("#").append(i).append(" ").append(sum).append("\n");
		}
		System.out.println(sb);
	}
}
