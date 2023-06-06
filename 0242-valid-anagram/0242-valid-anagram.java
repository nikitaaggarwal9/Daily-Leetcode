class Solution {
    public boolean isAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap();
        
        for(int i = 0; i < s.length(); i++) 
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
        
        for(int i = 0; i < t.length(); i++) {
            char ch = t.charAt(i);
            
            if(hm.containsKey(ch)) {
                if(hm.get(ch) == 1) hm.remove(ch);
                else hm.put(ch, hm.get(ch) - 1);
            } else return false;
        }

        return hm.size() == 0;
    }
}