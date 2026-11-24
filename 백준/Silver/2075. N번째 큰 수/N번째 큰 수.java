import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer>[] pq = new PriorityQueue[n];
        for (int i = 0; i < n; i++) {
            pq[i] = new PriorityQueue<>((o1, o2) -> {
                return o1 - o2;
            });
        }
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int x = Integer.parseInt(st.nextToken());
                pq[j].offer(x);
            }
        }
        PriorityQueue<Integer> res = new PriorityQueue<>((o1, o2) -> {
            return -(o1 - o2);
        });
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                res.offer(pq[i].poll());
            }
        }
        for (int i = 0; i < n - 1; i++) {
            res.poll();
        }
        System.out.println(res.peek());
    }
}