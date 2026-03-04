import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Map<Long, Long> map = new HashMap<>();
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		Queue<Long> q = new LinkedList<>();
		q.offer(a);
		map.put(a, 1L);
		while (!q.isEmpty()) {
			long cur = q.poll();
			if (cur == b) {
				break;
			}
			if (cur > b) {
				continue;
			}
			if (!map.containsKey(cur * 10 + 1)) {
				map.put(cur * 10 + 1, map.get(cur) + 1);
				q.offer(cur * 10 + 1);
			}
			if (!map.containsKey(2 * cur)) {
				map.put(2 * cur, map.get(cur) + 1);
				q.offer(cur * 2);
			}
		}
		if (map.containsKey(b)) {
			System.out.println(map.get(b));
		} else {
			System.out.println(-1);
		}

	}
}
