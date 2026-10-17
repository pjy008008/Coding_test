import java.util.*;

class Solution {
    private static int num = 1;
    private static int n,m;
    private static boolean[][] visited;
    private static int[][] area;
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static Map<Integer, Integer> map = new HashMap<>();
    
    public int solution(int[][] land) {
        n = land.length;
        m = land[0].length;
        num = 1;
        map.clear();
        visited = new boolean[n][m];
        area = new int[n][m];
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                bfs(j,i,land);
            }
        }
        int max = 0;
        for(int i=0;i<m;i++){
            Set<Integer> set = new HashSet<>();
            int cnt = 0;
            for(int j=0;j<n;j++){
                if(area[j][i]>0 && !set.contains(area[j][i])){
                    set.add(area[j][i]);
                    cnt += map.get(area[j][i]);
                }
            }
            System.out.println(cnt);
            if(cnt>max){
                max = cnt;
            }
        }
        
        return max;
    }
    private static void bfs(int x, int y, int[][] land){
        if(visited[y][x] || land[y][x] == 0){
            return;
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x,y});
        visited[y][x] = true;
        area[y][x] = num;
        int cnt = 1;
        while(!q.isEmpty()){
            int[] pos = q.poll();
            int cx = pos[0];
            int cy = pos[1];
            for(int dir=0;dir<4;dir++){
                int nx = cx + dx[dir];
                int ny = cy + dy[dir];
                if(0<=nx&&nx<m&&0<=ny&&ny<n){
                    if(!visited[ny][nx] && land[ny][nx] == 1){
                        visited[ny][nx] = true;
                        area[ny][nx] = num;
                        cnt++;
                        q.offer(new int[]{nx,ny});
                    }
                }
            }
        }
        map.put(num, cnt);
        num++;
    }
}