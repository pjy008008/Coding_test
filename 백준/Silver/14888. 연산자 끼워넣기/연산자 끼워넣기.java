import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static int[] arr;
	private static int max, min;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		arr = new int[n];
		max = Integer.MIN_VALUE;
		min = Integer.MAX_VALUE;
		int[] operCnt = new int[4];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < 4; i++) {
			operCnt[i] = Integer.parseInt(st.nextToken());
		}
		dfs(1, arr[0], operCnt[0], operCnt[1], operCnt[2], operCnt[3]);
		System.out.println(max);
		System.out.println(min);
	}

	private static void dfs(int cnt, int sum, int plus, int minus, int mul, int div) {
		if (cnt == n) {
			max = Math.max(max, sum);
			min = Math.min(min, sum);
			return;
		}
		if (plus > 0) {
			dfs(cnt + 1, sum + arr[cnt], plus - 1, minus, mul, div);
		}
		if (minus > 0) {
			dfs(cnt + 1, sum - arr[cnt], plus, minus - 1, mul, div);
		}
		if (mul > 0) {
			dfs(cnt + 1, sum * arr[cnt], plus, minus, mul - 1, div);
		}
		if (div > 0) {
			dfs(cnt + 1, sum / arr[cnt], plus, minus, mul, div - 1);
		}
	}
}
