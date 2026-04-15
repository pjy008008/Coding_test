import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		long temp = gcd(a, b);
		for (int i = 0; i < temp; i++) {
			sb.append(1);
		}
		System.out.println(sb);
	}

	private static long gcd(long a, long b) {
		long r = a % b;
		if (r == 0) {
			return b;
		}
		return gcd(b, r);
	}
}
