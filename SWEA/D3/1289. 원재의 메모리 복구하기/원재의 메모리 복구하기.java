import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		for (int test = 0; test < tc; test++) {
			String str = br.readLine();
			char[] arr = str.toCharArray();
			char flag = '0';
			int count = 0;
			for (int i = 0; i < arr.length; i++) {
				if (arr[i] != flag) {
					flag = setFlag(flag);
					count++;
				}
			}
			System.out.println("#" + (test + 1) + " " + count);
		}
	}

	private static char setFlag(char a) {
		if (a == '1') {
			return '0';
		} else {
			return '1';
		}
	}
}
