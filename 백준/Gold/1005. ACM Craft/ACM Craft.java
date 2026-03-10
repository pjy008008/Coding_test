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
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] time = new int[n + 1];
			int[] inDegree = new int[n + 1];
			int[] result = new int[n + 1];
			ArrayList<Integer>[] graph = new ArrayList[n + 1];
			for (int j = 1; j <= n; j++) {
				graph[j] = new ArrayList<>();
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				time[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 0; j < k; j++) {
				st = new StringTokenizer(br.readLine());
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				graph[s].add(e);
				inDegree[e]++;
			}
			int goal = Integer.parseInt(br.readLine());

			// topological sort
			Queue<Integer> q = new LinkedList<>();
			for (int j = 1; j <= n; j++) {
				if (inDegree[j] == 0) {
					q.offer(j);
					result[j] = time[j];
				}
			}
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int next : graph[cur]) {
					result[next] = Math.max(result[next], result[cur] + time[next]);
					inDegree[next]--;
					if (inDegree[next] == 0) {
						q.offer(next);
					}
				}
			}
			System.out.println(result[goal]);
		}
	}
}
