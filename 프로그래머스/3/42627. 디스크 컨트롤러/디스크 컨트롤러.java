import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        // 진입 순서를 알기 위한 list
        List<Job> list = new ArrayList<>();
        for(int i=0;i<jobs.length;i++){
            list.add(new Job(i, jobs[i][0], jobs[i][1]));
        }
        Collections.sort(list, (o1,o2)->{
            return o1.start - o2.start;
        });
        // 우선 순위를 알기 위한 PQ
        PriorityQueue<Job> pq = new PriorityQueue<>((o1, o2)->{
            if(o1.pTime != o2.pTime){
                return o1.pTime - o2.pTime;
            }
            if(o1.start != o2.start){
                return o1.start - o2.start;
            }
            return o1.num - o2.num;
        });
        
        // 시간
        int time = 0;
        // 조회한 job의 idx
        int idx = 0;
        // 처리된 작업의 개수
        int cnt = 0;
        // 처리하는 작업의 남은 시간
        int left = 0;
        // 총 지연 시간
        int total = 0;
        // 처리하는 작업
        Job job = null;
        while(cnt != list.size()){
            while(idx < list.size() && list.get(idx).start == time){
                pq.offer(list.get(idx));
                idx++;
            }
            if(!pq.isEmpty() && left <= 0){
                job = pq.poll();
                left = job.pTime;
                total += (time+left) - job.start;
                cnt++;
            }
            left--;
            time++;
        }
        return total/cnt;
    }
    
    static class Job{
        int num;
        int start;
        int pTime;
        
        Job(int num, int start, int pTime){
            this.num = num;
            this.start = start;
            this.pTime = pTime;
        }
    }
}