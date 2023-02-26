class Solution {
    public int minDistance(String s1, String s2) {
        int N = s1.length();
        int M = s2.length();
        int[][] dp = new int[N + 1][M + 1];
        for(int n = 0; n <= N; n++) {
            for(int m = 0; m <= M; m++) {
                if(n == 0 || m == 0) {
                    dp[n][m] = n == 0 ? m : n;
                    continue;
                }
                
                if(s1.charAt(n - 1) == s2.charAt(m - 1)) dp[n][m] = dp[n - 1][m - 1];
                else dp[n][m] = Math.min(dp[n - 1][m - 1], Math.min(dp[n - 1][m], dp[n][m - 1])) + 1;
            }
        }
        return dp[N][M];
    }
}