class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) return -1;
        
        int n_len = needle.length();
        for(int i = 0; i <= haystack.length() - n_len; i++) {
            if(haystack.substring(i, i + n_len).equals(needle)) return i;
        }
        
        return -1;
    }
}