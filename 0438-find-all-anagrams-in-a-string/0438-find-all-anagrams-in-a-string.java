class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int slen = s.length(), plen = p.length();
        
        List<Integer> list = new ArrayList<>();
        
        if(plen > slen) return list;
        
        int[] freq = new int[26];
        for(int i = 0; i < plen; i++) {
            int sp = s.charAt(i) - 'a';
            int pp = p.charAt(i) - 'a';
            
            freq[sp]--;
            freq[pp]++;
        }
        
        if(allFreqZeroes(freq)) list.add(0);
        
        for(int i = plen; i < slen; i++) {
            int curr_sp = s.charAt(i) - 'a';
            int prev_sp = s.charAt(i - plen) - 'a';
            
            freq[curr_sp]--;
            freq[prev_sp]++;
            
            if(allFreqZeroes(freq)) list.add(i - plen + 1);
        }
        
        return list;
    }
    
    public boolean allFreqZeroes(int[] freq) {
        for(int i = 0; i < freq.length; i++) 
            if(freq[i] != 0) return false;
        
        return true;
    }
}