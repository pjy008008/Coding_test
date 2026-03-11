import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] inDegree = new int[n + 1];
		// init graph
		ArrayList<Integer>[] graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			int[] arr = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			for (int j = 1; j < size; j++) {
				graph[arr[j - 1]].add(arr[j]);
				inDegree[arr[j]]++;
			}
		}

		List<Integer> res = new ArrayList<>();
		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++) {
			if (inDegree[i] == 0) {
				q.offer(i);
			}
		}
		int cnt = 0;
		while (!q.isEmpty()) {
			int cur = q.poll();
			res.add(cur);
			cnt++;
			for (int next : graph[cur]) {
				inDegree[next]--;
				if (inDegree[next] == 0) {
					q.offer(next);
				}
			}
		}
		if (cnt != n) {
			System.out.println(0);
		} else {
			for (int i = 0; i < res.size(); i++) {
				sb.append(res.get(i)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
