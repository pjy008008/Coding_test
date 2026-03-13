import java.util.*;
class Solution {
    public List<Integer> solution(String[] maps) {
        int n = maps.length, m = maps[0].length();
        List<Integer> answer = new ArrayList<>();
        int[] dx = {0,0,-1,1}, dy = {-1,1,0,0};
        int[][] board = new int[n][m], vis = new int[n][m];
        Deque<Integer> Q = new ArrayDeque<>();
        for(int i = 0; i<n; i++){
            String str = maps[i];
            for(int j = 0; j<m; j++){
                if(str.charAt(j) == 'X') board[i][j] = 0;
                else board[i][j] = str.charAt(j) - '0';
            }
        }
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<m; j++){
                if(board[i][j] == 0 || vis[i][j] == 1) continue;
                else {
                    Q.offer(i * m + j);
                    vis[i][j] = 1;
                    int cnt = board[i][j];
                    while(!Q.isEmpty()) {
                        int cur = Q.poll();
                        int row = cur / m;
                        int col = cur % m;
                        for(int k = 0; k<4; k++){
                            int nrow = row + dx[k];
                            int ncol = col + dy[k];
                            if(nrow < 0 || nrow >= n || ncol >= m || ncol < 0) continue;
                            if(vis[nrow][ncol] != 0 || board[nrow][ncol] == 0) continue;
                            Q.offer(nrow * m + ncol);
                            vis[nrow][ncol] = 1;
                            cnt += board[nrow][ncol];
                        }
                    }
                    answer.add(cnt);
                }
            }
        }
        if(answer.isEmpty()) answer.add(-1);
        else Collections.sort(answer);
        return answer;
    }
}