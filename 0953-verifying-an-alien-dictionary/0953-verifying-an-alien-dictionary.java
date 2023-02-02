class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        // store position of characters at their right position
        int[] store = new int[26];
        for(int i = 0; i < 26; i++) {
            int pos = order.charAt(i) - 'a';
            store[pos] = i;
        }
        
        for(int i = 1; i < words.length; i++) {
            String str1 = words[i - 1];
            String str2 = words[i];
            
            for(int j = 0; j < str1.length(); j++) {
                if(j == str2.length()) return false;
                
                int p1 = str1.charAt(j) - 'a';
                int p2 = str2.charAt(j) - 'a';
                
                if(store[p1] > store[p2]) return false;
                
                // assures that str1 is lexographically small at j
                if(store[p1] < store[p2]) break;  
                
                // System.out.println(str1.charAt(j) + " " + str2.charAt(j));
            }
        }
        
        return true;
    }
}