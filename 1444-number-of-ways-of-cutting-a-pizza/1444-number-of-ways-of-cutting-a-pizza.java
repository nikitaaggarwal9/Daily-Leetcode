class Solution {
     String pizza[];
    int dp[][][];
    int MOD = (int)1e9 + 7;
    public int ways(String[] pizza, int k) {
        this.pizza = pizza;
        int m = pizza.length;
        int n = pizza[0].length();
        dp = new int[m][n][k+1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                    Arrays.fill(dp[i][j], -1);
            }
        }

        return find(0, m-1, 0, n-1, k);
    }

    int find(int row, int rl, int col, int cl, int k)
    {
        if(k == 1)
        {
            return 1;
        }
        if (dp[row][col][k] != -1) {
            return dp[row][col][k] % MOD;
        }

        dp[row][col][k] = 0;
        for(int i = row; i <= rl; i++)
        {
            if(isApple(row, i, col, cl) && isApple(i+1, rl, col, cl))
            {
                dp[row][col][k] = (dp[row][col][k]+find(i+1, rl, col, cl, k-1))%MOD;
            }
        }

        for(int i = col; i <= cl; i++)
        {
            if(isApple(row, rl, i+1, cl) && isApple(row, rl, col, i))
            {
               dp[row][col][k] = (dp[row][col][k]+find(row, rl, i+1, cl, k-1))%MOD;
            }
        }
        return dp[row][col][k];
    }

    boolean isApple(int row, int rl, int col, int cl)
    {
        for(int i = row;i <= rl;i++)
        {
            for(int j = col; j <= cl;j++)
            {
                if(pizza[i].charAt(j) == 'A')
                {
                    return true;
                }
            }
        }
        return false;
    }

}