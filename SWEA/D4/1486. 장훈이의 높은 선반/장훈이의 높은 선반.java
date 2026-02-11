import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int b;
	private static int[] worker;
	private static int minHeight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			st = new StringTokenizer(br.readLine());
			n = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			worker = new int[n];
			minHeight = Integer.MAX_VALUE;
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				worker[j] = Integer.parseInt(st.nextToken());
			}
			dfs(0, 0);
			sb.append("#").append(i).append(" ").append(minHeight - b).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int idx, int height) {
		if (height > minHeight) {
			return;
		}
		if (height >= b) {
			minHeight = Math.min(minHeight, height);
		}
		if (idx == n) {
			return;
		}

		dfs(idx + 1, height + worker[idx]);
		dfs(idx + 1, height);
	}
}
