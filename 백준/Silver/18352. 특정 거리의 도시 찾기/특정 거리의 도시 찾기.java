import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken()); // 도시 개수
        int m = Integer.parseInt(st.nextToken()); // 도로 개수
        int k = Integer.parseInt(st.nextToken()); // 거리 정보
        int x = Integer.parseInt(st.nextToken()); // 출발 도시
        boolean[] visited = new boolean[n + 1];
        int[] depth = new int[n + 1];
        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList();
        }
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            graph[s].add(e);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(x);
        visited[x] = true;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (!visited[next]) {
                    visited[next] = true;
                    depth[next] = depth[cur] + 1;
                    q.offer(next);
                }
            }
        }
        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            if (depth[i] == k) {
                flag = true;
                sb.append(i).append("\n");
            }
        }
        if (flag) {
            System.out.println(sb);
        } else {
            System.out.println(-1);
        }
    }
}