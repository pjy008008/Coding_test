import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static long c;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());
		long res = dfs(a, b);
		System.out.println(res);
	}

	private static long dfs(long x, long n) {
		if (n == 1) {
			return x % c;
		}
		if (n % 2 == 0) {
			long y = dfs(x, n / 2);
			return (y * y) % c;
		} else {
			long y = dfs(x, (n - 1) / 2);
			return (((y * y) % c) * x) % c;
		}
	}
}
