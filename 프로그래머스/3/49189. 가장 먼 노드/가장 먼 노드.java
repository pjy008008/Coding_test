import java.util.*;

class Solution {
    public int solution(int n, int[][] edge) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        int[] visited = new int[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i=0;i<edge.length;i++){
            graph[edge[i][0]].add(edge[i][1]);
            graph[edge[i][1]].add(edge[i][0]);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1]=1;
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next:graph[cur]){
                if(visited[next]==0){
                    visited[next] = visited[cur]+1;
                    q.offer(next);
                }
            }
        }
        
        int max=0;
        int res=0;
        for(int i=1;i<=n;i++){
            if(visited[i]>max){
                max=visited[i];
                res=1;
            }else if(visited[i]==max){
                res++;
            }
        }
        
        return res;
    }
}