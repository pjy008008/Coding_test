import java.util.*;

class Solution {
    static ArrayList<Integer>[] graph;
    static boolean[] visit;
    static int count=0;
    public int solution(int n, int[][] computers) {
        visit = new boolean[computers.length];
        graph = new ArrayList[computers.length];
        for(int i=0;i<computers.length;i++){
            graph[i] = new ArrayList<Integer>();
        }
        for(int i=0;i<computers.length;i++){
            for(int j=0;j<computers[0].length;j++){
                if(j==i){
                    continue;
                }
                if(computers[i][j]==1){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
        for(int i=0;i<computers.length;i++){
            if(!visit[i]){
                dfs(i);
                count++;
            }
        }
        return count;
    }
    public static void dfs(int vertex){
        if(visit[vertex]){
            return;
        }
        visit[vertex]=true;
        for(int i:graph[vertex]){
            dfs(i);
        }
    }
}