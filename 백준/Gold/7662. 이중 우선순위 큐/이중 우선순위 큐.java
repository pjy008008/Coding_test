import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int t = Integer.parseInt(br.readLine());
		for (int i = 1; i <= t; i++) {
			int n = Integer.parseInt(br.readLine());
			TreeMap<Integer, Integer> map = new TreeMap<>();
			for (int j = 0; j < n; j++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				int key = Integer.parseInt(st.nextToken());
				if (cmd == 'I') {
					if (map.containsKey(key)) {
						int count = map.get(key);
						map.put(key, count + 1);
					} else {
						map.put(key, 1);
					}
				}
				if (cmd == 'D') {
					if (!map.isEmpty()) {
						int count;
						if (key == 1) {
							count = map.get(map.lastKey());
							count--;
							if (count == 0) {
								map.remove(map.lastKey());
							} else {
								map.put(map.lastKey(), count);
							}
						}
						if (key == -1) {
							count = map.get(map.firstKey());
							count--;
							if (count == 0) {
								map.remove(map.firstKey());
							} else {
								map.put(map.firstKey(), count);
							}
						}
					}
				}
			}
			if (map.isEmpty()) {
				sb.append("EMPTY\n");
			} else {
				sb.append(map.lastKey()).append(" ").append(map.firstKey()).append("\n");
			}
		}
		System.out.println(sb);
	}

}
