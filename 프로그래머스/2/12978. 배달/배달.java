import java.util.*;

class Solution {
    public int solution(int N, int[][] road, int K) {
        ArrayList<Node>[] graph = new ArrayList[N+1];
        for(int i=1;i<=N;i++){
            graph[i] = new ArrayList<>();
        }
        
        int[] dist = new int[N+1];
        for(int i=1;i<=N;i++){
            dist[i] = Integer.MAX_VALUE;
        }
        
        for(int i=0;i<road.length;i++){
            int a = road[i][0];
            int b = road[i][1];
            int w = road[i][2];
            graph[a].add(new Node(b,w));
            graph[b].add(new Node(a,w));
        }
        
        PriorityQueue<Node> pq = new PriorityQueue<>((o1,o2)->{
            return o1.w-o2.w;
        });
        pq.offer(new Node(1,0));
        dist[1]=0;
        while(!pq.isEmpty()){
            Node cur = pq.poll();
            if(dist[cur.n]<cur.w){
                continue;
            }
            for(Node next:graph[cur.n]){
                if(dist[next.n]>next.w+dist[cur.n]){
                    dist[next.n]=next.w+dist[cur.n];
                    pq.offer(new Node(next.n,dist[next.n]));
                }
            }
        }
        int res = 0;
        for(int i=1;i<=N;i++){
            if(dist[i]<=K){
                res++;
            }
        }
        return res;
    }
    private static class Node{
        int n;
        int w;
        Node(int n, int w){
            this.n=n;
            this.w=w;
        }
    }
}