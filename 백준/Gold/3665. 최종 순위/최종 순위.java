import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for (int test = 0; test < t; test++) {
            int n = Integer.parseInt(br.readLine());
            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }

            int[] indegree = new int[n + 1];
            Set<Integer> set = new HashSet<>();
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                int x = Integer.parseInt(st.nextToken());
                for (int j = 1; j <= n; j++) {
                    if (set.contains(j)) {
                        indegree[x]++;
                        graph[j].add(x);
                    }
                }
                set.add(x);
            }

            int m = Integer.parseInt(br.readLine());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                if (graph[e].contains(s)) {
                    graph[e].remove(Integer.valueOf(s));
                    graph[s].add(e);
                    indegree[s]--;
                    indegree[e]++;
                }else{
                    graph[s].remove(Integer.valueOf(e));
                    graph[e].add(s);
                    indegree[e]--;
                    indegree[s]++;
                }

            }

            Queue<Integer> q = new LinkedList<>();
            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                }
            }

            List<Integer> res = new ArrayList<>();
            int cnt = 0;
            while (!q.isEmpty()) {
                int cur = q.poll();
                res.add(cur);
                cnt++;
                for (int next : graph[cur]) {
                    indegree[next]--;
                    if (indegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }

            if (cnt != n) {
                sb.append("IMPOSSIBLE\n");
            }else{
                for (int i = 0; i < res.size(); i++) {
                    sb.append(res.get(i)).append(" ");
                }
                sb.append("\n");
            }
        }
        System.out.println(sb);
    }
}