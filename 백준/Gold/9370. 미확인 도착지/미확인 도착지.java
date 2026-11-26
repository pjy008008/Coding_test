import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static ArrayList<Node>[] graph;
    private static int[] dist;
    private static int[] gDist;
    private static int[] hDist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine());
        for (int test = 0; test < testcase; test++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken()); // 정점
            int m = Integer.parseInt(st.nextToken()); // 간선
            int t = Integer.parseInt(st.nextToken()); // 목적지 후보

            graph = new ArrayList[n + 1];
            for (int i = 1; i <= n; i++) {
                graph[i] = new ArrayList<>();
            }
            dist = new int[n + 1];
            gDist = new int[n + 1];
            hDist = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dist[i] = Integer.MAX_VALUE;
                gDist[i] = Integer.MAX_VALUE;
                hDist[i] = Integer.MAX_VALUE;
            }

            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int v1 = Integer.parseInt(st.nextToken());
                int v2 = Integer.parseInt(st.nextToken());
                int weight = Integer.parseInt(st.nextToken());
                graph[v1].add(new Node(v2, weight));
                graph[v2].add(new Node(v1, weight));
            }
            List<Integer> goals = new ArrayList<>();
            for (int i = 0; i < t; i++) {
                goals.add(Integer.parseInt(br.readLine()));
            }

            PriorityQueue<Node> sPQ = new PriorityQueue<>();
            PriorityQueue<Node> gPQ = new PriorityQueue<>();
            PriorityQueue<Node> hPQ = new PriorityQueue<>();

            sPQ.offer(new Node(s, 0));
            gPQ.offer(new Node(g, 0));
            hPQ.offer(new Node(h, 0));

            dist[s] = 0;
            gDist[g] = 0;
            hDist[h] = 0;

            while (!sPQ.isEmpty()) {
                Node cur = sPQ.poll();
                if (cur.w > dist[cur.v]) {
                    continue;
                }
                for (Node next : graph[cur.v]) {
                    if (dist[next.v] > dist[cur.v] + next.w) {
                        dist[next.v] = dist[cur.v] + next.w;
                        sPQ.offer(new Node(next.v, dist[next.v]));
                    }
                }
            }

            while (!gPQ.isEmpty()) {
                Node cur = gPQ.poll();
                if (cur.w > gDist[cur.v]) {
                    continue;
                }
                for (Node next : graph[cur.v]) {
                    if (gDist[next.v] > gDist[cur.v] + next.w) {
                        gDist[next.v] = gDist[cur.v] + next.w;
                        gPQ.offer(new Node(next.v, gDist[next.v]));
                    }
                }
            }

            while (!hPQ.isEmpty()) {
                Node cur = hPQ.poll();
                if (cur.w > hDist[cur.v]) {
                    continue;
                }
                for (Node next : graph[cur.v]) {
                    if (hDist[next.v] > hDist[cur.v] + next.w) {
                        hDist[next.v] = hDist[cur.v] + next.w;
                        hPQ.offer(new Node(next.v, hDist[next.v]));
                    }
                }
            }


            Collections.sort(goals);
            for (int goal : goals) {
                if (dist[g] + gDist[h] + hDist[goal] == dist[goal]) {
                    sb.append(goal).append(" ");
                    continue;
                }
                if (dist[h] + hDist[g] + gDist[goal] == dist[goal]) {
                    sb.append(goal).append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Node implements Comparable<Node>{
        int v;
        int w;

        Node(int v, int w) {
            this.v=v;
            this.w=w;
        }

        @Override
        public int compareTo(Node o) {
            return this.w - o.w;
        }
    }
}