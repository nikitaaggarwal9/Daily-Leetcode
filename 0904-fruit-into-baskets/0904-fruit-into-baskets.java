class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> hm = new HashMap<>();
        int ans = 0, s = 0;
        
        for(int e = 0; e < fruits.length; e++) {
            hm.put(fruits[e], hm.getOrDefault(fruits[e], 0) + 1);
            
            while(hm.size() > 2) {
                hm.put(fruits[s], hm.get(fruits[s]) - 1);
                
                if(hm.get(fruits[s]) == 0)
                    hm.remove(fruits[s]);
                
                s++;
            }
            
            ans = Math.max(ans, e - s + 1);
        }
        
        return ans;
    }
}