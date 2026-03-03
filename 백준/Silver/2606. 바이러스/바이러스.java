import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		boolean[] visited = new boolean[n + 1];
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			graph[s].add(e);
			graph[e].add(s);
		}
		Queue<Integer> q = new LinkedList<>();
		q.offer(1);
		visited[1] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph[cur]) {
				if (!visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		int cnt = 0;
		for (int i = 2; i <= n; i++) {
			if (visited[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
}
