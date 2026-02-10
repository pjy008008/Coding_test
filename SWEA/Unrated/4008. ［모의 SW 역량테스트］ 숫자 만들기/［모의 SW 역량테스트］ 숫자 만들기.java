import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	private static int n;
	private static int[] operCnt;
	private static int[] numbers;
	private static int max;
	private static int min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			n = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			numbers = new int[n];
			operCnt = new int[4];
			max = Integer.MIN_VALUE;
			min = Integer.MAX_VALUE;
			for (int j = 0; j < 4; j++) {
				operCnt[j] = Integer.parseInt(st.nextToken());
			}
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				numbers[j] = Integer.parseInt(st.nextToken());
			}
			dfs(1, numbers[0]);
			sb.append("#").append(i).append(" ").append(max - min).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int cnt, int sum) {
		if (cnt == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		if (operCnt[0] > 0) {
			operCnt[0]--;
			dfs(cnt + 1, sum + numbers[cnt]);
			operCnt[0]++;
		}
		if (operCnt[1] > 0) {
			operCnt[1]--;
			dfs(cnt + 1, sum - numbers[cnt]);
			operCnt[1]++;
		}
		if (operCnt[2] > 0) {
			operCnt[2]--;
			dfs(cnt + 1, sum * numbers[cnt]);
			operCnt[2]++;
		}
		if (operCnt[3] > 0) {
			operCnt[3]--;
			dfs(cnt + 1, sum / numbers[cnt]);
			operCnt[3]++;
		}
	}
}
