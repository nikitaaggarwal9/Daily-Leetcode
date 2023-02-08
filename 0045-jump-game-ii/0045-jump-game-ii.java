class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        return jumpHelper(0, nums, dp);
    }
    
    public int jumpHelper(int ci, int[] nums, int[] dp) {
        if(ci >= nums.length) return 0;
        if(ci == nums.length - 1) return 0;
        
        if(dp[ci] != -1) return dp[ci];
        
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i <= nums[ci]; i++) {
            int sans = jumpHelper(ci + i, nums, dp);
            
            if(sans == Integer.MAX_VALUE) continue;
            
            ans = Math.min(sans + 1, ans);
        }
        
        return dp[ci] = ans;
    }
}