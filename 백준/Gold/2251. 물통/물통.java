import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] size = new int[3];

        size[0] = Integer.parseInt(st.nextToken());
        size[1] = Integer.parseInt(st.nextToken());
        size[2] = Integer.parseInt(st.nextToken());

        int[] send = new int[]{0, 0, 1, 1, 2, 2};
        int[] receive = new int[]{1, 2, 0, 2, 0, 1};
        boolean[][] visited = new boolean[201][201];  // 첫 번째, 두 번째 물통의 경우의 수

        TreeSet<Integer> ans = new TreeSet<>();
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0}); // 1번째, 2번째 물통
        visited[0][0] = true;
        ans.add(size[2]);  // 3번째 물통 정답에 저장
        
        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int curA = cur[0];
            int curB = cur[1];
            int curC = size[2] - curA - curB;  // 3번째 물통의 양은 유추 가능
            for (int i = 0; i < 6; i++) {
                int sender = send[i];
                int receiver = receive[i];
                int[] next = {curA, curB, curC};
                next[receiver] += next[sender];
                next[sender] = 0;
                if (next[receiver] > size[receiver]) { // 만약 넘치면 가득 채우고 남는 양만큼 다시 담음
                    next[sender] = next[receiver] - size[receiver];
                    next[receiver] = size[receiver];
                }
                if (!visited[next[0]][next[1]]) {  // 방문 하지 않은 경우의 수만
                    visited[next[0]][next[1]] = true;
                    q.offer(new int[]{next[0], next[1]});
                    if (next[0] == 0) {
                        ans.add(next[2]);  // 만약 첫 번째 물통에 물이 없으면 정답에 추가
                    }
                }
            }
        }
        for (Integer an : ans) {
            sb.append(an).append(" ");
        }
        System.out.println(sb);
    }
}