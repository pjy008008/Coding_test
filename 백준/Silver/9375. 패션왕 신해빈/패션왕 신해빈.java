import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 0; i < t; i++) {
			HashMap<String, Integer> map = new HashMap<>();
			int n = Integer.parseInt(br.readLine());
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken();
				String s2 = st.nextToken();
				if (!map.containsKey(s2)) {
					map.put(s2, 1);
				} else {
					map.put(s2, map.get(s2) + 1);
				}
			}
			int comb = 1;
			for (int x : map.values()) {
				comb *= x + 1;
			}
			sb.append(comb - 1).append("\n");

		}
		System.out.println(sb);
	}
}
