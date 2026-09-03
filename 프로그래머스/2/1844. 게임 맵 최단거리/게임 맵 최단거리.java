import java.util.*;

class Solution {
    private static int[] dx = {0,0,1,-1};
    private static int[] dy = {1,-1,0,0};
    private static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps[0].length;
        int m = maps.length;
        int result = -1;
        visited = new boolean[m][n];
        
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(0,0,1));
        visited[0][0]=true;
        while(!q.isEmpty()){
            Node node = q.poll();
            int cx = node.x;
            int cy = node.y;
            int dist = node.dist;
            if(cx==n-1 && cy==m-1){
                result = dist;
                break;
            }
            for(int dir = 0;dir<4;dir++){
                int nx = cx+dx[dir];
                int ny = cy+dy[dir];
                if(0<=nx&&nx<n&&0<=ny&&ny<m){
                    if(!visited[ny][nx]&&maps[ny][nx]==1){
                        visited[ny][nx]=true;
                        q.offer(new Node(nx,ny,dist+1));
                    }
                }
            }
        }
        return result;
    }
    
    private static class Node{
        int x;
        int y;
        int dist;
        Node(int x,int y, int dist){
            this.x = x;
            this.y = y;
            this.dist = dist;
        }
    }
}