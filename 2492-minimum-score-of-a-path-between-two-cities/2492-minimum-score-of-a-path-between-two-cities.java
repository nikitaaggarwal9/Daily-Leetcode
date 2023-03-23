class Solution {
    public int minScore(int n, int[][] roads) {
        List<int[]>[] graph = new List[n+1];
        int res = Integer.MAX_VALUE;
        for(int i =0;i<n+1;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int road[]:roads){
            graph[road[0]].add(new int[]{road[1],road[2]});
            graph[road[1]].add(new int[]{road[0],road[2]});
        }
        
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.add(1);
        set.add(1);
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int[] neighbour: graph[curr]){
                res = Math.min(res, neighbour[1]);
                if(set.add(neighbour[0])){
                    q.add(neighbour[0]);

                }

            }
        }
        return res;
    }
}