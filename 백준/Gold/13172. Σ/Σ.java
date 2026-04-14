import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// n/s 꼴로 표현된 분수
// n * s^(s-2) mod MOD_VALUE 계산

public class Main {
	private static final int MOD_VALUE = 1_000_000_007;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int m = Integer.parseInt(br.readLine());
		long ans = 0;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int gcb = gcb(n, s);
			// 기약분수꼴로 표현
			n /= gcb;
			s /= gcb;
			ans += (s * solve(n, MOD_VALUE - 2)) % MOD_VALUE;
			ans %= MOD_VALUE;
		}
		System.out.println(ans);
	}

	private static long solve(long n, long k) {
		if (k == 1) {
			return n;
		}
		long res = solve(n, k / 2);
		res = res * res % MOD_VALUE;
		if (k % 2 == 1) {
			res *= n;
			res %= MOD_VALUE;
		}
		return res;
	}

	private static int gcb(int a, int b) {
		int r = a % b;
		if (r == 0) {
			return b;
		}
		return gcb(b, r);
	}
}
