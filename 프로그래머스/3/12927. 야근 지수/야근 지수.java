import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1,o2)->{
            return -Integer.compare(o1,o2);
        });
        for(int i=0;i<works.length;i++){
            pq.offer(works[i]);
        }
        while(0<n){
            int x = pq.poll();
            if(x==0){
                break;
            }
            x--;
            pq.offer(x);
            n--;
        }
        long sum=0;
        while(!pq.isEmpty()){
            int x = pq.poll();
            sum+= x*x;
        }
        return sum;
    }
}