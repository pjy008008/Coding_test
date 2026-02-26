import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] visit = new int[100001];
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		visit[n] = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == k) {
				break;
			}
			if (cur + 1 <= 100000) {
				if (visit[cur + 1] == 0) {
					visit[cur + 1] = visit[cur] + 1;
					q.offer(cur + 1);
				}
			}
			if (cur - 1 >= 0) {
				if (visit[cur - 1] == 0) {
					visit[cur - 1] = visit[cur] + 1;
					q.offer(cur - 1);
				}
			}
			if (cur << 1 <= 100000) {
				if (visit[cur << 1] == 0) {
					visit[cur << 1] = visit[cur] + 1;
					q.offer(cur * 2);
				}
			}
		}
		System.out.println(visit[k]);
	}
}
