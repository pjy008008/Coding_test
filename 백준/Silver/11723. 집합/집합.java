import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int m = Integer.parseInt(br.readLine());
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			String cmd = st.nextToken();
			if (cmd.equals("add")) {
				int x = Integer.parseInt(st.nextToken());
				set.add(x);
			}
			if (cmd.equals("remove")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x)) {
					set.remove(x);
				}
			}
			if (cmd.equals("check")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x)) {
					sb.append(1).append("\n");
				} else {
					sb.append(0).append("\n");
				}
			}
			if (cmd.equals("toggle")) {
				int x = Integer.parseInt(st.nextToken());
				if (set.contains(x)) {
					set.remove(x);
				} else {
					set.add(x);
				}
			}
			if (cmd.equals("all")) {
				set.clear();
				for (int j = 1; j <= 20; j++) {
					set.add(j);
				}
			}
			if (cmd.equals("empty")) {
				set.clear();
			}
		}
		System.out.println(sb);
	}
}
