class Solution {
    private static int N;
    private static int[][] com;
    private static boolean[] visited;
    
    public int solution(int n, int[][] computers) {
        N = n;
        com = computers;
        visited = new boolean[n];
        
        int ans = 0;
        for(int i=0;i<n;i++){
            if(!visited[i]){
                ans++;
                dfs(i);
            }
        }
        return ans;
    }
    private static void dfs(int idx){
        if(visited[idx]){
            return;
        }
        visited[idx] = true;
        for(int i=0;i<N;i++){
            if(com[idx][i]==1){
                dfs(i);    
            }
        }
    }
}