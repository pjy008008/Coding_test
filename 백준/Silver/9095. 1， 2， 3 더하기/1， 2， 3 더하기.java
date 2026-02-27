import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	private static int sum;
	private static int goal;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
		for (int i = 0; i < n; i++) {
			goal = Integer.parseInt(br.readLine());
			sum = 0;
			dfs(0,0);
			sb.append(sum).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int num, int depth) {
		if (num > goal) {
			return;
		}
		if (num == goal) {
			sum++;
			return;
		}
		dfs(num + 1, depth + 1);
		dfs(num + 2, depth + 1);
		dfs(num + 3, depth + 1);
	}
}
