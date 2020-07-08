class RottenOranges {
	public static void main(String[] args){
		RottenOranges ro = new RottenOranges();
		int[][] grid = {{1,2,1,1,1},{1,0,2,1,2}};
		
		System.out.println(ro.orangesRotting(grid));
	}

	public int orangesRotting(int[][] grid) {
        if(null == grid || grid.length == 0){
            return 0;
        }
       int[][] result = new int[grid.length][grid[0].length];   
        
       for(int i=0; i< grid.length; i++){
           for ( int j = 0 ; j< grid[0].length; j++){
               if(grid[i][j] != 2){
                   result[i][j] = Integer.MAX_VALUE;
               }
           }
       }   
        for(int i = 1; i< grid.length; i++){
            if(grid[i][0] != 0 && grid[i][0] !=2) {
                result[i][0] = 
                Math.min(result[i][0],result[i-1][0]) == Integer.MAX_VALUE ?
                    Integer.MAX_VALUE :  Math.min(result[i][0],result[i-1][0]) + 1;
            }
        }
           
           for(int j = 1; j< grid[0].length; j++){
            if(grid[0][j] != 0 && grid[0][j] !=2) {
                result[0][j] = 
                Math.min(result[0][j],result[0][j-1]) == Integer.MAX_VALUE ?
                    Integer.MAX_VALUE :  Math.min(result[0][j],result[0][j-1]) + 1;
            }
        }
           
          for(int i = 1; i< grid.length; i++){
              for(int j = 1 ; j< grid[0].length; j++ ){
                  
             if(grid[i][j] != 0 && grid[i][j] !=2) {
                result[i][j] = 
                Math.min(result[i-1][j],result[i][j-1]) == Integer.MAX_VALUE ?
                    Integer.MAX_VALUE :  Math.min(result[i-1][j],result[i][j-1]) + 1;
            }
              }
        }
           
           
       int r = grid.length - 1;
        int c = grid[0].length -1;
        for(int i = r - 1; i >=0 ; i--){
            if(grid[i][c] != 0 && grid[i][c] !=2) {
                if(result[i][c] > result[i+1][c] ){
                   result[i][c] = result[i+1][c] +1;
                }
            }
        }   
           
         for(int j = c - 1; j >= 0 ; j--){
            if(grid[r][j] != 0 && grid[r][j] !=2) {
                if(result[r][j] > result[r][j+1] ){
                   result[r][j] = result[r][j+1] + 1;
                }
            }
        }
           
          for(int i = r -1; i >=0 ; i--){
              for(int j = c - 1 ; j > 0; j-- ){
                  
             if(grid[i][j] != 0 && grid[i][j] !=2) {
               if(result[i][j] > Math.min(result[i + 1][j],result[i][j+1])){
                   result[i][j] = Math.min(result[i + 1][j],result[i][j+1]) + 1;
               }
            }
              }
        }
    
    int maxValue = 0;       
    for(int i = 0 ; i< grid.length ; i++){
        for ( int j= 0  ; j < grid[0].length; j++){
            if(grid[i][j] != 0 ){
                maxValue = Math.max(maxValue,result[i][j]);
            }
        }
    }
           
    if(maxValue == Integer.MAX_VALUE){
        return -1;
    }else{
        return maxValue;
    }       
    
           
           
           
           
       
    }
}