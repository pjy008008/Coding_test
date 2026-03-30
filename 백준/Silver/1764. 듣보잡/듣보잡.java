import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		Set<String> set = new HashSet<>();
		TreeSet<String> res = new TreeSet<>();
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		for (int i = 0; i < n; i++) {
			set.add(br.readLine());
		}
		int cnt = 0;
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (set.contains(s)) {
				cnt++;
				res.add(s);
			}
		}
		System.out.println(cnt);
		while (!res.isEmpty()) {
			sb.append(res.pollFirst()).append("\n");
		}
		System.out.println(sb);
	}
}
