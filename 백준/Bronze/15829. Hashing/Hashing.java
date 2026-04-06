import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		String s = br.readLine();
		long sum = 0;
		long r = 1;
		for (int i = 0; i < n; i++) {
			sum = (sum + (s.charAt(i) - 'a' + 1) * r) % 1234567891;
			r = (r * 31) % 1234567891;
		}
		System.out.println(sum);
	}
}
