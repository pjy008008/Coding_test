import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[] visited = new int[1000001];
		Queue<Integer> q = new LinkedList<>();
		q.offer(n);
		while (!q.isEmpty()) {
			int cur = q.poll();
			if (cur == 1) {
				break;
			}
			if (cur % 3 == 0) {
				if (visited[cur / 3] == 0) {
					visited[cur / 3] = visited[cur] + 1;
					q.offer(cur / 3);
				}
			}
			if (cur % 2 == 0) {
				if (visited[cur / 2] == 0) {
					visited[cur / 2] = visited[cur] + 1;
					q.offer(cur / 2);
				}
			}
			if (visited[cur - 1] == 0) {
				visited[cur - 1] = visited[cur] + 1;
				q.offer(cur - 1);
			}
		}
		System.out.println(visited[1]);
	}
}
