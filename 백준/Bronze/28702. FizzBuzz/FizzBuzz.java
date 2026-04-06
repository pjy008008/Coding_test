import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		String a = br.readLine();
		String b = br.readLine();
		String c = br.readLine();
		int x = -1;
		if (Character.isDigit(a.charAt(0))) {
			x = Integer.parseInt(a) + 3;
		} else if (Character.isDigit(b.charAt(0))) {
			x = Integer.parseInt(b) + 2;
		} else {
			x = Integer.parseInt(c) + 1;
		}
		if (x % 5 == 0 && x % 3 == 0) {
			System.out.println("FizzBuzz");
		} else if (x % 3 == 0) {
			System.out.println("Fizz");
		} else if (x % 5 == 0) {
			System.out.println("Buzz");
		} else {
			System.out.println(x);
		}
	}
}
