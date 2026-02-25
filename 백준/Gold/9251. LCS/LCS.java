import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String a = br.readLine();
		String b = br.readLine();
		int[][] map = new int[a.length() + 1][b.length() + 1];
		for (int j = 1; j <= a.length(); j++) {
			for (int k = 1; k <= b.length(); k++) {
				if (a.charAt(j - 1) == b.charAt(k - 1)) {
					map[j][k] = map[j - 1][k - 1] + 1;
				} else {
					map[j][k] = Math.max(map[j - 1][k], map[j][k - 1]);
				}
			}
		}
		sb.append(map[a.length()][b.length()]);
		System.out.println(sb);
	}
}
