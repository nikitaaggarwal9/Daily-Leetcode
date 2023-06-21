class Solution {
    public int characterReplacement(String s, int k) {
        int maxLen = 0, si = 0;
        int[] freq = new int[26];
        
        for(int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'A']++;
            
            int mfreq = 0;
            for(int n: freq) mfreq = Math.max(n, mfreq);
            
            int lettersToChange = (i - si + 1) - mfreq;
            
            if(lettersToChange > k) {
                freq[s.charAt(si) - 'A']--;
                si++;
            }
            
            maxLen = Math.max(maxLen, i - si + 1);
        }
        
        return maxLen;
    }

}