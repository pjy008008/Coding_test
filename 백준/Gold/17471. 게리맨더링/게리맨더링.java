import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	private static int n;
	private static ArrayList<Integer>[] graph;
	private static int min;
	private static int[] population;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		n = Integer.parseInt(br.readLine());
		min = Integer.MAX_VALUE;
		population = new int[n + 1];
		graph = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++) {
			graph[i] = new ArrayList<>();
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			population[i] = Integer.parseInt(st.nextToken());
		}
		for (int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			int size = Integer.parseInt(st.nextToken());
			for (int j = 0; j < size; j++) {
				int x = Integer.parseInt(st.nextToken());
				graph[i].add(x);
			}
		}
		getSubset();
		if(min==Integer.MAX_VALUE) {
			System.out.println(-1);
		}else {
			System.out.println(min);
		}
	}

	private static void getSubset() {
		ArrayList<Integer> listA = new ArrayList<>();
		ArrayList<Integer> listB = new ArrayList<>();
		for (int i = 1; i < (1 << n)-1; i++) {
			for (int j = 0; j < n; j++) {
				if ((i & (1 << j)) == 0) {
					listA.add(j + 1);
				} else {
					listB.add(j + 1);
				}
			}
			if (visit(listA) && visit(listB)) {
				int sumA = 0, sumB = 0;
				for (int a : listA) {
					sumA += population[a];
				}
				for (int b : listB) {
					sumB += population[b];
				}
				min = Math.min(min, Math.abs(sumA - sumB));
			}
			listA.clear();
			listB.clear();
		}
	}

	private static boolean visit(ArrayList<Integer> list) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] visited = new boolean[n + 1];
		q.offer(list.get(0));
		visited[list.get(0)] = true;
		while (!q.isEmpty()) {
			int cur = q.poll();
			for (int next : graph[cur]) {
				if (list.contains(next) && !visited[next]) {
					visited[next] = true;
					q.offer(next);
				}
			}
		}
		for (int x : list) {
			if (!visited[x]) {
				return false;
			}
		}
		return true;
	}
}
