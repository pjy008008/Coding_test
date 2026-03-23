class Solution {
    public int solution(int[][] triangle) {
        int answer = Integer.MIN_VALUE;
        int height = triangle.length;
        int width = 2;
        
        int[][] dp = new int[height][height];
        dp[0][0] = triangle[0][0];
        for(int i=1;i<height;i++){
            for(int j=0;j<width;j++){
                if(j==0){
                    // left
                    dp[i][j] = triangle[i][j] + dp[i-1][j];
                }else if(j==width-1){
                    // right
                    dp[i][j] = triangle[i][j] + dp[i-1][j-1];
                }else{
                    //center
                    dp[i][j] = triangle[i][j] + Math.max(dp[i-1][j],dp[i-1][j-1]);
                }
            }
            width++;
        }
        for(int i=0;i<height;i++){
            answer = Math.max(answer,dp[height-1][i]);
        }
        return answer;
    }
}