class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        
        for(int i = 0; i < nums.length - 1; i++) {
            int l = i + 1, r = nums.length - 1;
            if((i != 0 && nums[i] == nums[i - 1])) continue;
            
            while(l < r) {
                int sum = nums[i] + nums[l] + nums[r];
                
                if (sum > 0  || (r != nums.length - 1 && nums[r] == nums[r + 1])) r--;
                else if (sum < 0 || (l != i + 1 && nums[l] == nums[l - 1])) l++;
                else {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i], nums[l], nums[r]));
                    ans.add(list);
                    r--;
                    l++;
                }
            }
        }
        
        return ans;
    }
}





