class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int lo = Integer.MIN_VALUE;
        int hi = 0;
        for(int val: weights) {
            hi += val;
            lo = Math.max(lo, val);
        }
        
        
        while(lo < hi) {
            int mid = (lo + hi) / 2;
            int capacity = mid;
            
            
            int daysTaken = 1;
            int weightSoFar = 0;
            for(int weight: weights) {
                if(weightSoFar + weight <= capacity) {
                    weightSoFar += weight;
                } else {
                    weightSoFar = weight;
                    daysTaken++;
                }
            }
            
            
            if(daysTaken > days) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        
        return lo;
    }
}