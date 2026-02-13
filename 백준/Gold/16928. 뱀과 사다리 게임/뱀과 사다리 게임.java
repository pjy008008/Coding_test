import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    private static int[] depth;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] move = new int[101];
        depth = new int[101];
        for (int i = 0; i < n + m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            move[s] = e;
        }
        bfs(1, move);
        System.out.println(depth[100]);
    }

    private static void bfs(int start, int[] move) {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        while (!queue.isEmpty()) {
            int x = queue.poll();
            for (int i = 1; i <= 6; i++) {
                int next = x + i;
                if (next > 100) {
                    continue;
                }
                if (move[next] != 0) {
                    next = move[next];
                }
                if (depth[next] == 0) {
                    depth[next] = depth[x] + 1;
                    queue.offer(next);
                }
            }
        }
    }
}