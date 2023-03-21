class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long count = 0, ans = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0) {
                count++;
            } else if(i > 0 && nums[i-1] == 0) {
                ans += (count * (count + 1) / 2);
                count = 0;
            }
        }
        
        return ans + (count * (count + 1) / 2);
    }
}