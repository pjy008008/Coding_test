import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        Deque<Node> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int h = Integer.parseInt(st.nextToken());
            Node node = new Node(i, h);
            if (deque.isEmpty()) {
                deque.addFirst(node);
                sb.append(0).append(" ");
            } else {
                if (deque.peekFirst().height > h) {
                    sb.append(deque.peekFirst().idx).append(" ");
                    deque.addFirst(node);
                } else {
                    while (!deque.isEmpty()) {
                        if (deque.peekFirst().height > h) {
                            break;
                        }
                        deque.poll();
                    }
                    if (deque.isEmpty()) {
                        sb.append(0).append(" ");
                    } else {
                        sb.append(deque.peekFirst().idx).append(" ");
                    }
                    deque.addFirst(node);
                }
            }
        }
        System.out.println(sb);
    }

    static class Node {
        int idx;
        int height;

        public Node(int idx, int height) {
            this.idx = idx;
            this.height = height;
        }
    }
}