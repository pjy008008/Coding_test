import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int[][] dp = new int[n + 1][m + 1];
		List<Thing> list = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			list.add(new Thing(w, v));
		}
		Collections.sort(list);
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j <= m; j++) {
				Thing t = list.get(i - 1);
				if (j < t.weight) {
					dp[i][j] = dp[i - 1][j];
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t.weight] + t.value);
				}
			}
		}
		System.out.println(dp[n][m]);
	}

	static class Thing implements Comparable<Thing> {
		int weight;
		int value;

		public Thing(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}

		@Override
		public int compareTo(Thing o) {
			return this.weight - o.weight;
		}
	}
}
