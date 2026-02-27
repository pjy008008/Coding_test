import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
	private static HashMap<Long, Long> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		long n = Long.parseLong(br.readLine());
		map.put(0L, 0L);
		map.put(1L, 1L);
		System.out.println(p(n));
	}

	private static long p(long n) {
		if (!map.containsKey(n)) {
			if (n % 2 == 0) {
				long p1 = p(n / 2);
				long p2 = p(n / 2 - 1);
				map.put(n, (p1 * (p1 + 2 * p2)) % 1000000007);
				return map.get(n);
			} else {
				long p1 = p(n / 2);
				long p2 = p(n / 2 + 1);
				map.put(n, (p1 * p1 + p2 * p2) % 1000000007);
				return map.get(n);
			}
		}
		return map.get(n);
	}
}
