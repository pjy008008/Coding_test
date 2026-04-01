import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		ArrayList<Integer> list = new ArrayList<>();
		ArrayList<Integer> res = new ArrayList<>();
		for (int i = 1; i <= n; i++) {
			list.add(i);
		}
		int idx = m - 1;
		for (int i = 0; i < n; i++) {
			if (idx >= list.size()) {
				idx %= list.size();
			}
			res.add(list.remove(idx));
			idx += m - 1;
		}
		sb.append("<");
		for (int i = 0; i < n; i++) {
			if (i == n - 1) {
				sb.append(res.get(i)).append(">");
			} else {
				sb.append(res.get(i)).append(", ");
			}
		}
		System.out.println(sb);
	}
}
