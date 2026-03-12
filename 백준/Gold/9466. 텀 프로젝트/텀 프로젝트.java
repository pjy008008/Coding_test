import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int cnt;
	private static boolean[] visited;
	private static boolean[] finished;
	private static int[] target;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			target = new int[n + 1];
			visited = new boolean[n + 1];
			finished = new boolean[n + 1];
			cnt = 0;
			st = new StringTokenizer(br.readLine());
			for (int j = 1; j <= n; j++) {
				int e = Integer.parseInt(st.nextToken());
				target[j] = e;
			}
			for (int j = 1; j <= n; j++) {
				dfs(j);
			}
			System.out.println(n - cnt);
		}
	}

	private static void dfs(int s) {
		visited[s] = true;
		int next = target[s];

		if (!visited[next]) {
			dfs(next);
		} else {
			if (!finished[next]) {
				cnt++;
				for (int i = next; i != s; i = target[i]) {
					cnt++;
				}
			}
		}
		finished[s] = true;
	}
}
