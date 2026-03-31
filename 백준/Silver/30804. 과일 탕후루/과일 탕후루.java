import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int n = Integer.parseInt(br.readLine());
		int[] arr = new int[n];

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			int x = Integer.parseInt(st.nextToken());
			arr[i] = x;
		}
		if (n == 1) {
			System.out.println(1);
		} else {
			int max = Integer.MIN_VALUE;
			HashMap<Integer, Integer> map = new HashMap<>();
			int s = 0;
			int e = 1;
			map.put(arr[s], 1);
			if (arr[s] == arr[e]) {
				map.put(arr[s], 2);
			} else {
				map.put(arr[e], 1);
			}
			while (e < n) {
				if (s == e) {
					e++;
					if (e >= n) {
						break;
					}
					if (map.containsKey(arr[e])) {
						map.put(arr[e], map.get(arr[e]) + 1);
					} else {
						map.put(arr[e], 1);
					}
				}
				if (map.size() <= 2) {
					max = Math.max(max, e - s);
					e++;
					if (e >= n) {
						break;
					}
					if (map.containsKey(arr[e])) {
						map.put(arr[e], map.get(arr[e]) + 1);
					} else {
						map.put(arr[e], 1);
					}
				} else {
					map.put(arr[s], map.get(arr[s]) - 1);
					if (map.get(arr[s]) == 0) {
						map.remove(arr[s]);
					}
					s++;
				}
			}
			System.out.println(max + 1);
		}
	}
}
