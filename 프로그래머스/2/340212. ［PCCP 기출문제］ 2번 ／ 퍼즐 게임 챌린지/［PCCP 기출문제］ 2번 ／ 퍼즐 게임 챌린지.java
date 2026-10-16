class Solution {
    private static int[] diff;
    private static int[] time;
    private static long lim;
    
    public int solution(int[] diffs, int[] times, long limit) {
        diff = diffs;
        time = times;
        lim = limit;
        
        int max = 0;
        for(int i=0;i<diffs.length;i++){
            if(diffs[i]>max){
                max = diffs[i];
            }
        }
        // max로 parametric search 1~max
        return search(1, max);
    }
    
    private int search(int s, int e){
        if(s>=e){
            return s;
        }
        
        int mid = (s+e)/2;

        long t = 0;
        for(int i=0;i<diff.length;i++){
            if(mid>=diff[i]){
                t += time[i];
            }else{
                t += (long)(time[i-1] + time[i]) * (diff[i] - mid) + time[i];
            }
        }
        
        if(t<=lim){
            return search(s, mid);
        }else{
            return search(mid + 1, e);
        }
    }
}