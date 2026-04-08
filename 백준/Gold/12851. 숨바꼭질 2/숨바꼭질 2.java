import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static final int MAX_RANGE = 100_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] time = new int[MAX_RANGE + 1];
		int[] count = new int[MAX_RANGE + 1];

		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		time[n] = 1;
		count[n] = 1;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == k) {
				continue;
			}
			if (check(cur + 1)) {
				if (time[cur + 1] == 0) {
					time[cur + 1] = time[cur] + 1;
					count[cur + 1] = count[cur];
					q.offer(cur + 1);
				} else if (time[cur + 1] == time[cur] + 1) {
					count[cur + 1] += count[cur];
				}
			}

			if (check(cur - 1)) {
				if (time[cur - 1] == 0) {
					time[cur - 1] = time[cur] + 1;
					count[cur - 1] = count[cur];
					q.offer(cur - 1);
				} else if (time[cur - 1] == time[cur] + 1) {
					count[cur - 1] += count[cur];
				}
			}

			if (check(cur * 2)) {
				if (time[cur * 2] == 0) {
					time[cur * 2] = time[cur] + 1;
					count[cur * 2] = count[cur];
					q.offer(cur * 2);
				} else if (time[cur * 2] == time[cur * 2]) {
					count[cur * 2] += count[cur];
				}
			}
		}

		System.out.println(time[k] - 1);
		System.out.println(count[k]);
	}

	private static boolean check(int x) {
		return 0 <= x && x <= MAX_RANGE;
	}
}
