import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder("I");
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			sb.append("OI");
		}
		String findStr = sb.toString();
		String str = br.readLine();

		int idx = str.indexOf(findStr);

		int cnt = 0;

		while (idx >= 0) {
			idx = str.indexOf(findStr, idx + 1);
			cnt++;
		}

		System.out.println(cnt);
	}
}
