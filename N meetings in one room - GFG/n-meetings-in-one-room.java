//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());

        while (t-- > 0) {
            String inputLine[] = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);

            int start[] = new int[n];
            int end[] = new int[n];

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++)
                start[i] = Integer.parseInt(inputLine[i]);

            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) 
                end[i] = Integer.parseInt(inputLine[i]);
                
            int ans = new Solution().maxMeetings(start, end, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends

class Pair {
    int first;
    int second;
    
    Pair (int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution 
{
    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        // add your code here
         
        Pair pairs[] = new Pair[n];
        for(int i = 0; i < n; i++) {
            pairs[i] = new Pair(start[i], end[i]);
        }
        
        Arrays.sort(pairs, (p1, p2) -> p1.second - p2.second);
        
        int count = 1;
        int endLimit = pairs[0].second;
        
        for(int i = 1; i < pairs.length; i++) {
            if(pairs[i].first > endLimit) {
                count++;
                endLimit = pairs[i].second;
            }
        }
        
        return count;
    }
}
