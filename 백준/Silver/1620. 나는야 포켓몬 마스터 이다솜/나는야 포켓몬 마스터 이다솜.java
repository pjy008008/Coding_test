import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		HashMap<Integer, String> itos = new HashMap<>();
		HashMap<String, Integer> stoi = new HashMap<>();
		for (int i = 1; i <= n; i++) {
			String name = br.readLine();
			itos.put(i, name);
			stoi.put(name, i);
		}
		for (int i = 0; i < m; i++) {
			String s = br.readLine();
			if (Character.isDigit(s.charAt(0))) {
				sb.append(itos.get(Integer.parseInt(s))).append("\n");
			} else {
				sb.append(stoi.get(s)).append("\n");
			}
		}
		System.out.println(sb);
	}
}
