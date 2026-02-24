import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        for (int i = 1; i <= t; i++) {
            PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> -(o1 - o2));
            int n = Integer.parseInt(br.readLine());
            sb.append("#").append(i).append(" ");
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(br.readLine());
                int cmd = Integer.parseInt(st.nextToken());
                if (cmd == 1) {
                    pq.add(Integer.parseInt(st.nextToken()));
                }
                if (cmd == 2) {
                    if (pq.isEmpty()) {
                        sb.append(-1);
                    } else {
                        sb.append(pq.poll());
                    }
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}