import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
	private static int n, m, k;
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());

		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}

		st = new StringTokenizer(br.readLine());
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken()) - 1;
			int b = Integer.parseInt(st.nextToken()) - 1;
			union(a, b);
		}
		Map<Integer, Thing> map = new HashMap<>();
		for (int i = 0; i < n; i++) {
			int key = find(i);
			if (!map.containsKey(key)) {
				// 해당 집합이 없으면 인원수 1, 가치 그대로
				map.put(key, new Thing(1, arr[i]));
			} else {
				// 해당 집합이 있으면 인원수 + 1, 기존 가치 + 현재 가치
				Thing t = map.get(key);
				map.put(key, new Thing(t.amount + 1, t.value + arr[i]));
			}
		}

		// knapsack
		int[] dp = new int[k];
		for (Thing t : map.values()) {
			int amount = t.amount;
			int value = t.value;
			for (int p = k - 1; p >= amount; p--) {
				dp[p] = Math.max(dp[p], dp[p - amount] + value);
			}
		}
		System.out.println(dp[k - 1]);
	}

	static class Thing {
		int amount;
		int value;

		Thing(int amount, int value) {
			this.amount = amount;
			this.value = value;
		}
	}

	private static int find(int a) {
		if (parent[a] == a) {
			return a;
		}
		return parent[a] = find(parent[a]);
	}

	private static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) {
			parent[b] = a;
		}
	}
}
