import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long sum = 0;
		for (int i = 0; i < n; i++) {
			sum += (s.charAt(i) - 'a' + 1) * Math.pow(31, i);
			sum %= 1234567891;
		}
		System.out.println(sum);
	}
}
