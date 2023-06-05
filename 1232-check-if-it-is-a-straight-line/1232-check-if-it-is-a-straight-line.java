class Solution {
    public boolean checkStraightLine(int[][] coordinates) {
        if(coordinates[0][0] == coordinates[1][0]) {
            for(int i = 2; i < coordinates.length; i++) 
                if(coordinates[0][0] != coordinates[i][0]) return false;
            
            return true;
        }
        
        
        float slope = ((float)coordinates[0][1] - coordinates[1][1])/(coordinates[0][0] - coordinates[1][0]);
        
        System.out.println(slope);
        
        for(int i = 2; i < coordinates.length; i++) { 
            if(coordinates[0][0] == coordinates[i][0]) return false;

            float currSlope = ((float)coordinates[0][1] - coordinates[i][1])/(coordinates[0][0] - coordinates[i][0]);
            
                    System.out.println(currSlope);

            
            
            if(currSlope != slope) return false;
        }
            
        return true;
    }
}