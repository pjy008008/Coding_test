import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int m;
	private static boolean[] visited = new boolean[100001];
	private static int[] depth = new int[100001];

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		visited[n] = true;
		while (!q.isEmpty()) {
			int pos = q.poll();
			if (pos == m) {
				break;
			}
			if (check(pos * 2) && !visited[pos * 2]) {
				visited[pos * 2] = true;
				depth[pos * 2] = depth[pos];
				q.offer(pos * 2);
			}
			if (check(pos - 1) && !visited[pos - 1]) {
				visited[pos - 1] = true;
				depth[pos - 1] = depth[pos] + 1;
				q.offer(pos - 1);
			}
			if (check(pos + 1) && !visited[pos + 1]) {
				visited[pos + 1] = true;
				depth[pos + 1] = depth[pos] + 1;
				q.offer(pos + 1);
			}
		}
		System.out.println(depth[m]);
	}

	private static boolean check(int x) {
		return 0 <= x && x <= 100000;
	}
}
