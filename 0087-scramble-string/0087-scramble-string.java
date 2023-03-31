class Solution {
    public boolean isScramble(String s1, String s2) {
        if(s1.length()!=s2.length())    return false;
        HashMap<String, Boolean> dp = new HashMap<>();
        return find(s1, s2, dp);
    }

    private boolean find(String s1, String s2, HashMap<String, Boolean> dp){
        if(s1.equals(s2))   return true;
        int n = s1.length();
        String key = s1 + " " + s2;
        if(dp.containsKey(key)) return dp.get(key);
        for(int i=1; i<n; i++){
            boolean noswap = find(s1.substring(0, i), s2.substring(0, i), dp) && find(s1.substring(i, n), s2.substring(i, n), dp);
            boolean swap = find(s1.substring(0, i), s2.substring(n-i, n), dp) && find(s1.substring(i, n), s2.substring(0, n-i), dp);
            if(swap || noswap){
                dp.put(key, true);
                return true;
            }
        }
        dp.put(key, false);
        return false;
    }
}