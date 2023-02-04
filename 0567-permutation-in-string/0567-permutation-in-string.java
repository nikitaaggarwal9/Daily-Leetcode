class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        
        if(l1 > l2) return false;
        
        int freq[] = new int[26];
        
        for(int i = 0; i < l1; i++) {
            int p1 = s1.charAt(i) - 'a';
            int p2 = s2.charAt(i) - 'a';
            
            freq[p1]++;
            freq[p2]--;
        }
        
        // if s2 begins with s1 permutation 
        if(allZeroesFreq(freq)) return true;
        
        // else check for rest of the s2
        // sliding window
        for(int i = l1; i < l2; i++) {
            int currP2 = s2.charAt(i) - 'a';
            int prevP2 = s2.charAt(i - l1) - 'a';
            
            freq[prevP2]++;
            freq[currP2]--;
            
            if(allZeroesFreq(freq)) return true;
        }
        
        return false;
    }
    
    public boolean allZeroesFreq(int[] freq) {
        for(int i = 0; i < freq.length; i++) 
            if(freq[i] != 0) return false;
        
        return true;
    }
}