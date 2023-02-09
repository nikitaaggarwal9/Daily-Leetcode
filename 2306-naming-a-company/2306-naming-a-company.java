class Solution {
    public long distinctNames(String[] ideas) {
//         TLE
//         HashSet<String> hs = new HashSet<>();
        
//         for(String idea : ideas) hs.add(idea);
        
//         long count = 0;
//         for(int i = 0; i < ideas.length - 1; i++) {
//             for(int j = i + 1; j < ideas.length; j++) {
//                 String s1 = ideas[i];
//                 String s2 = ideas[j];
                
//                 String sw1 = s2.substring(0, 1) + s1.substring(1);
//                 String sw2 = s1.substring(0, 1) + s2.substring(1);
                
//                 if(!hs.contains(sw1) && !hs.contains(sw2)) count++;
//             }
//         }
        
//         return 2 * count;
        
        HashSet<String>[] groups = new HashSet[26];
        for (int i = 0; i < 26; ++i) 
            groups[i] = new HashSet<>();
        
        for (String idea : ideas) 
            groups[idea.charAt(0) - 'a'].add(idea.substring(1));
        

        long answer = 0;
        for (int i = 0; i < 25; ++i) {
            for (int j = i + 1; j < 26; ++j) {
                
                long mutuals = 0;
                for (String ideaA : groups[i]) {
                    if (groups[j].contains(ideaA)) {
                        mutuals++;
                    }
                }
                answer += 2 * (groups[i].size() - mutuals) * (groups[j].size() - mutuals);
            }
        }
        
        return answer;
    }
}

// System.out.println(sw1 + " " + sw2);