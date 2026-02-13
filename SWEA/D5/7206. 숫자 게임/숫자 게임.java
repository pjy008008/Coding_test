import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
	private static Map<String, Integer> map = new HashMap<>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			String s = br.readLine();
			int max = dfs(s);
			sb.append("#").append(i).append(" ").append(max).append("\n");
		}
		System.out.println(sb);
	}

	private static int dfs(String s) {
		if (Integer.parseInt(s) < 10) {
			return 0;
		}
		if (map.containsKey(s)) {
			return map.get(s);
		}
		int depth = 0;
		for (int i = 1; i < 1 << (s.length() - 1); i++) { // 부분조합
			List<String> list = new ArrayList<>();
			int idx = 0;
			for (int j = 0; j < s.length() - 1; j++) {
				if ((i & (1 << j)) != 0) { // j번째 비트가 켜져있으면 쪼갬
					list.add(s.substring(idx, j + 1));
					idx = j + 1;
				}
			}
			list.add(s.substring(idx));
			int sum = 1;
			for (String ns : list) {
				sum *= Integer.parseInt(ns);
			}
			depth = Math.max(depth, dfs(String.valueOf(sum)) + 1);
		}
		map.put(s, depth);
		return depth;
	}
}
