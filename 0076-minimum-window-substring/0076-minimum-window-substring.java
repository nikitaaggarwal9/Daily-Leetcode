class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        
        int[] map = new int[128];
        int count = t.length();
        int start = 0, end = 0, minLen = Integer.MAX_VALUE, startIndex = 0;
        
        // freq array of small string
        for (char c : t.toCharArray()) map[c]++;
        
        
        while (end < s.length()) {
            if (map[s.charAt(end++)]-- > 0) count--;
            
            while (count == 0) {
                if (end - start < minLen) {
                    startIndex = start;
                    minLen = end - start;
                }
                
                if (map[s.charAt(start++)]++ == 0) count++;
            }
        }

        return minLen == Integer.MAX_VALUE? "" : s.substring(startIndex, startIndex + minLen);
    }
}