public class RowColMatrix {
    public static void main(String[] args){
        //the matrix can be of n*m size also
            int[][] matrix={
                {10,20,30,40},
                {15,25,35,45},
                {27,29,37,49},
                {32,34,38,50}
            };

            int target=49;
            int[] ans=search(matrix,target);
            System.out.println("Target found at:"+" Row: "+ans[0]+" Column: "+ans[1]);
    }

    static int[] search(int[][] matrix, int target) {
        int r=0;
        int c=matrix.length-1;
        while(r<matrix.length && c>=0){
            if(matrix[r][c]==target){
                return new int[]{r,c};         
            }
            
            else if(matrix[r][c]<target){
                r++;
            }
            else{
                c--;  
            }
        }
        return new int[]{-1,-1};
    }
}
