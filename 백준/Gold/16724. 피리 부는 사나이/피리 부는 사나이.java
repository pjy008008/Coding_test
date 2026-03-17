import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	private static int n, m;
	private static int[] map;
	private static int[] parent;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		parent = new int[n * m];
		for (int i = 0; i < m * n; i++) {
			parent[i] = i;
		}
		for (int i = 0; i < n; i++) {
			String line = br.readLine();
			for (int j = 0; j < m; j++) {
				char c = line.charAt(j);
				int nx = j;
				int ny = i;
				if (c == 'U') {
					ny--;
				}
				if (c == 'D') {
					ny++;
				}
				if (c == 'L') {
					nx--;
				}
				if (c == 'R') {
					nx++;
				}
				union(i * m + j, ny * m + nx);
			}
		}
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < n * m; i++) {
			set.add(find(i));
		}
		System.out.println(set.size());
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
