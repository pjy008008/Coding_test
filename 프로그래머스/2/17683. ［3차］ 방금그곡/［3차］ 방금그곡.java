import java.util.*;
import java.io.*;
class Solution {
    public String solution(String m, String[] musicinfos) {
        String answer = "(None)";
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i<m.length() -1; i++){
            if(m.charAt(i+1) == '#') sb.append(m.charAt(i) - 65);
            else sb.append(m.charAt(i));
            if(i == m.length() - 2) sb.append(m.charAt(i+1));
        }
        m = sb.toString();
        List<String> songs = new ArrayList<>();
        List<String> melodies = new ArrayList<>();
        List<Integer> times = new ArrayList<>();
        for(int i = 0; i<musicinfos.length; i++){
            String info = musicinfos[i];
            int starttime = Integer.parseInt(info.substring(0,2)) * 60 + Integer.parseInt(info.substring(3,5));
            int endtime = Integer.parseInt(info.substring(6,8)) * 60 + Integer.parseInt(info.substring(9,11));
            int runningTime = endtime - starttime;
            int idx = 12;
            sb = new StringBuilder();
            while(info.charAt(idx) != ','){
                sb.append(info.charAt(idx));
                idx++;
            }
            String song = sb.toString();
            idx++;
            sb = new StringBuilder();
            int cnt = 0;
            for(; idx < info.length(); idx++){
                if(info.charAt(idx) == '#') cnt++;
                sb.append(info.charAt(idx));
            }
            String melody = sb.toString();
            times.add(runningTime);
            sb = new StringBuilder();
            for(int j = 0; j<runningTime; j++){
                if(melody.charAt((j + 1)% melody.length()) == '#'){
                    runningTime++;
                    sb.append(melody.charAt(j % melody.length()) - 65);
                    continue;
                }
                else sb.append(melody.charAt(j % melody.length()));
            }
            System.out.println(m + " " + runningTime + " " + song + " " + melody + " " + sb.toString());
            songs.add(song);
            melodies.add(sb.toString());
        }
        int nowtime = 0;
        for(int i = 0; i<melodies.size(); i++){
            String temp = melodies.get(i);
            if(temp.contains(m) && times.get(i) > nowtime) {
                answer = songs.get(i);
                nowtime = times.get(i);
            }
        }
        
        return answer;
    }
    
}