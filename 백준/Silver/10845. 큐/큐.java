import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        LinkedList<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            String cmd = st.nextToken();
            if (cmd.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                q.offer(x);
            }
            if (cmd.equals("pop")) {
                if (!q.isEmpty()) {
                    sb.append(q.poll()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
            if (cmd.equals("size")) {
                sb.append(q.size()).append("\n");
            }
            if (cmd.equals("empty")) {
                if (q.isEmpty()) {
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }
            if (cmd.equals("front")) {
                if (!q.isEmpty()) {
                    sb.append(q.getFirst()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
            if (cmd.equals("back")) {
                if (!q.isEmpty()) {
                    sb.append(q.getLast()).append("\n");
                }else{
                    sb.append(-1).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}