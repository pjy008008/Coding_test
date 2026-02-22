import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        for (int i = 1; i <= 10; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] graph = new ArrayList[v + 1];
            for (int j = 1; j <= v; j++) {
                graph[j] = new ArrayList<>();
            }
            int[] inDegree = new int[v + 1];
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < e; j++) {
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());
                graph[start].add(end);
                inDegree[end]++;
            }
            Queue<Integer> q = new LinkedList<>();
            List<Integer> res = new ArrayList<>();
            for (int j = 1; j <= v; j++) {
                if (inDegree[j] == 0) {
                    q.offer(j);
                }
            }
            while (!q.isEmpty()) {
                int cur = q.poll();
                res.add(cur);
                for (int next : graph[cur]) {
                    inDegree[next]--;
                    if (inDegree[next] == 0) {
                        q.offer(next);
                    }
                }
            }
            sb.append("#").append(i).append(" ");
            for (int x : res) {
                sb.append(x).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
