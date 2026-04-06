import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String s = br.readLine();
		int sum = 0;
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '*') {
				idx = i;
			} else {
				if (i % 2 == 0) {
					sum += s.charAt(i) - '0';
				} else {
					sum += (s.charAt(i) - '0') * 3;
				}
			}
		}
		int res = 0;
		for (int i = 0; i < 10; i++) {
			int w = idx % 2 == 0 ? 1 : 3;
			if ((sum + w * i) % 10 == 0) {
				res = i;
			}
		}
		System.out.println(res);
	}
}
