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
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Node>[] graph = new ArrayList[n + 1];
        ArrayList<Node>[] revGraph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
            revGraph[i] = new ArrayList<>();
        }
        int[] inDegree = new int[n + 1];
        int[] res = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[s].add(new Node(e, w));
            revGraph[e].add(new Node(s, w));
            inDegree[e]++;
        }
        st = new StringTokenizer(br.readLine());
        int han = Integer.parseInt(st.nextToken());
        int roma = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        q.offer(han);
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Node next : graph[cur]) {
                inDegree[next.v]--;
                res[next.v] = Math.max(res[next.v], res[cur] + next.w);
                if (inDegree[next.v] == 0) {
                    q.offer(next.v);
                }
            }
        }
        q.clear();
        q.offer(roma);
        boolean[] visited = new boolean[n + 1];
        visited[roma] = true;
        int cnt = 0;
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (Node next : revGraph[cur]) {
                if (res[cur] == res[next.v] + next.w) {
                    cnt++;
                    if (!visited[next.v]) {
                        visited[next.v] = true;
                        q.offer(next.v);
                    }
                }
            }
        }
        System.out.println(res[roma]);
        System.out.println(cnt);
    }

    static class Node {
        int v;
        int w;

        public Node(int v, int w) {
            this.v = v;
            this.w = w;
        }
    }
}
