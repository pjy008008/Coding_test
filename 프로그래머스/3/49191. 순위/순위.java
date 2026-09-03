import java.util.*;

class Solution {
    public int solution(int n, int[][] results) {
        ArrayList<Integer>[] graph = new ArrayList[n+1];
        int[] indegree = new int[n+1];
        for(int i=1;i<=n;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<results.length;i++){
            int a = results[i][0];
            int b = results[i][1];
            indegree[b]++;
            graph[a].add(b);
        }
        
        BitSet[] winner = new BitSet[n+1];
        for(int i=1;i<=n;i++){
            winner[i] = new BitSet();
        }
        
        Queue<Integer> q = new LinkedList<>();
        for(int i=1;i<=n;i++){
            if(indegree[i]==0){
                q.offer(i);
            }
        }
        
        while(!q.isEmpty()){
            int cur = q.poll();
            for(int next:graph[cur]){
                // next를 이긴 cur
                winner[next].set(cur);
                // cur은 next가 이긴 모든 사람을 이김
                winner[next].or(winner[cur]);
                
                indegree[next]--;
                if(indegree[next]==0){
                    q.offer(next);
                }
            }
        }
        
        int[] win = new int[n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(winner[j].get(i)){
                    win[i]++;
                }
            }
        }
        
        int res = 0;
        for(int i=1;i<=n;i++){
            if(win[i]+winner[i].cardinality()==n-1){
                res++;
            }
        }
        
        return res;
    }
}

// 위상 정렬
// A가 B를 이겼을 때 => A에서 B로 가는 edge가 존재함.