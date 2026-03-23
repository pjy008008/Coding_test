import java.util.*;

class Solution {
    private static ArrayList<Integer>[] graph;
    private static int len;
    public int solution(String begin, String target, String[] words) {
        len = words.length+1;
        // begin 0, words 1~n
        graph = new ArrayList[len];
        for(int i=0;i<len;i++){
            graph[i] = new ArrayList<>();
        }
        init(begin,target,words);
        
        int goal = -1;
        for(int i=0;i<words.length;i++){
            if(target.equals(words[i])){
                goal = i+1;
            }
        }
        if(goal==-1){
            return 0;
        }
        int[] dist = new int[len];
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int cur = q.poll();
            if(cur==goal){
                break;
            }
            for(int next: graph[cur]){
                if(dist[next]==0){
                    dist[next] = dist[cur] + 1;
                    q.offer(next);
                }
            }
        }
        
        return dist[goal];
    }
    private void init(String begin, String target, String[] words){
        List<String> list = new ArrayList<>();
        list.add(begin);
        // list.add(target);
        for(int i=0;i<words.length;i++){
            list.add(words[i]);
        }
        
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                if(i==j){
                    continue;
                }
                if(isConnected(list.get(i),list.get(j))){
                    graph[i].add(j);
                    graph[j].add(i);
                }
            }
        }
    }
    private boolean isConnected(String a,String b){
        int cnt=0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i)!=b.charAt(i)){
                cnt++;
            }
        }
        return cnt==1;
    }
}