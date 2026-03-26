import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        PriorityQueue<Car> pq = new PriorityQueue<>((o1,o2)->{
            if(o1.e==o2.e){
                return o1.s-o2.s;
            }
            return o1.e-o2.e;
        });
        for(int i=0;i<routes.length;i++){
            pq.offer(new Car(routes[i][0],routes[i][1]));
        }
        int end = pq.poll().e;
        int res = 1;
        while(!pq.isEmpty()){
            Car c = pq.poll();
            if(c.s>end){
                end = c.e;
                res++;
            }
        }
        
        return res;
    }
    static class Car{
        int s;
        int e;
        Car(int s,int e){
            this.s=s;
            this.e=e;
        }
    }
}