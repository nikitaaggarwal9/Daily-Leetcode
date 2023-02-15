import java.math.BigInteger;

class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        String tmp = "";
		for (int n : num) tmp += n + "";
		
		BigInteger N = new BigInteger(tmp);
		BigInteger K = new BigInteger(k + "");
		BigInteger data = N.add(K);
		
        List<Integer> res = new ArrayList<Integer>();
		String s = data.toString();
		
        for (int i = 0; i < s.length(); i++) 
            res.add(Character.getNumericValue(s.charAt(i)));
        
		return res;
    }
}