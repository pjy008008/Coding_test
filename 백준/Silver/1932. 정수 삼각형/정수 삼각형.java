import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		List<Integer> list = new ArrayList<>();
		int n = Integer.parseInt(br.readLine());
		list.add(Integer.parseInt(br.readLine()));
		for (int i = 2; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			List<Integer> newList = new ArrayList<>();
			for (int j = 0; j < i; j++) {
				int x = Integer.parseInt(st.nextToken());
				if (j == 0) {
					// 가장 왼쪽
					newList.add(list.get(0) + x);
				} else if (j == i - 1) {
					// 가장 오른쪽
					newList.add(list.get(j - 1) + x);
				} else {
					// 가운데
					newList.add(Math.max(list.get(j - 1), list.get(j)) + x);
				}
			}
			list = newList;
		}
		int max = -1;
		for (int x : list) {
			if (x > max) {
				max = x;
			}
		}
		System.out.println(max);
	}
}
