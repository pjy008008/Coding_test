import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int v;
    private static int e;
    private static ArrayList<Integer>[] graph;
    private static int[] color;
    private static boolean flag;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            v = Integer.parseInt(st.nextToken());
            e = Integer.parseInt(st.nextToken());
            graph = new ArrayList[v + 1];
            color = new int[v + 1];
            flag = true;  // 이분 그래프라고 가정
            for (int j = 1; j <= v; j++) {
                graph[j] = new ArrayList<>();
            }
            for (int j = 0; j < e; j++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph[a].add(b);
                graph[b].add(a);
            }
            for (int j = 1; j <= v; j++) {
                if (color[j] == 0 && flag) {
                    bfs(j);
                }
            }
            if (flag) {
                sb.append("YES\n");
            } else {
                sb.append("NO\n");
            }
        }
        System.out.println(sb);
    }

    private static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        color[start] = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : graph[cur]) {
                if (color[next] == 0) {
                    if (color[cur] == 1) {
                        color[next] = 2;
                    }
                    if (color[cur] == 2) {
                        color[next] = 1;
                    }
                    q.offer(next);
                } else {
                    // 0이 아니면 visited 상태
                    if (color[cur] == color[next]) {
                        flag = false;
                        return;
                    }
                }
            }
        }
    }
}