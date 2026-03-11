import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // number of gem
		int k = Integer.parseInt(st.nextToken()); // number of bag
		PriorityQueue<Gem> gems = new PriorityQueue<>((o1, o2) -> {
			return o1.weight - o2.weight;
		});
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			gems.offer(new Gem(w, v));
		}
		PriorityQueue<Integer> bags = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			bags.offer(Integer.parseInt(br.readLine()));
		}
		PriorityQueue<Gem> candidate = new PriorityQueue<>((o1, o2) -> {
			return -(o1.value - o2.value);
		});
		long res = 0;
		for (int i = 0; i < k; i++) {
			int bag = bags.poll();
			while (!gems.isEmpty()) {
				if (bag >= gems.peek().weight) {
					candidate.offer(gems.poll());
				} else {
					break;
				}
			}
			if (!candidate.isEmpty()) {
				res += candidate.poll().value;
			}
		}
		System.out.println(res);
	}

	static class Gem {
		int weight;
		int value;

		public Gem(int weight, int value) {
			this.weight = weight;
			this.value = value;
		}
	}
}
