public class PurelySorted {
    public static void main(String[] args){
        int[][] matrix={
            {1,2,3},
            {4,5,6},
            {7,8,9},
        };

        int target=6;

        // Search for the target in the sorted matrix
        int[] ans=search(matrix,target);

        System.out.println("Target found at:"+" Row: "+ans[0]+" Column: "+ans[1]);
    }

    // ----------------------------
    // Performs binary search in a given row between column range cStart to cEnd
    // Returns the indices [row, col] if found, else [-1, -1]
    // ----------------------------
    static int[] binarySearch(int[][] matrix,int row,int cStart,int cEnd,int target){
        while(cStart<=cEnd){
            int mid=cStart+(cEnd-cStart)/2; // avoid overflow

            if(matrix[row][mid]==target){
                return new int[]{row,mid}; // found target
            }

            // if middle element < target → search right half
            if(matrix[row][mid]<target){
                cStart=mid+1;
            }
            // if middle element > target → search left half
            else{
                cEnd=mid-1;
            }
        }
        // target not found in this row
        return new int[]{-1,-1};
    }

    // ----------------------------
    // Search for target in a 2D sorted matrix (sorted both row-wise and column-wise)
    // Uses binary elimination on rows, then searches within reduced rows
    // ----------------------------
    static int[] search(int[][] matrix,int target){
        int rows=matrix.length;
        int cols=matrix[0].length; // assume non-empty matrix

        // Special case: only one row → simple binary search on that row
        if(rows==1){
            return binarySearch(matrix,0,0,cols-1,target);
        }

        int rStart=0;          // start row
        int rEnd=rows-1;       // end row
        int cMid=cols/2;       // middle column (acts as vertical divider)

        // Reduce the search space until only 2 rows remain
        while(rStart<(rEnd-1)){ // ensures at least 2 rows remain
            int mid=rStart+(rEnd-rStart)/2;

            // if middle column element is target
            if(matrix[mid][cMid]==target){
                return new int[]{mid,cMid};
            }

            // if target > middle element → eliminate upper half
            if(matrix[mid][cMid]<target){
                rStart=mid;
            }
            // else eliminate lower half
            else{
                rEnd=mid;
            }
        }

        // Now we have only 2 rows: rStart and rStart+1

        // Step 1: Check middle column of both rows
        if(matrix[rStart][cMid]==target){
            return new int[]{rStart,cMid};
        }
        if(matrix[rStart+1][cMid]==target){
            return new int[]{rStart+1,cMid};
        }

        // Step 2: Check the four halves (quadrants)

        // 1st quadrant → upper-left part
        if(target<=matrix[rStart][cMid-1]){
            return binarySearch(matrix,rStart,0,cMid-1,target);
        }

        // 2nd quadrant → upper-right part
        if(target>=matrix[rStart][cMid+1] && target<=matrix[rStart][cols-1]){
            return binarySearch(matrix,rStart,cMid+1,cols-1,target);
        }

        // 3rd quadrant → lower-left part
        if(target<=matrix[rStart+1][cMid-1]){
            return binarySearch(matrix,rStart+1,0,cMid-1,target);
        }

        // 4th quadrant → lower-right part
        else{
            return binarySearch(matrix,rStart+1,cMid+1,cols-1,target);
        }
    }
}


/*

Detailed Control Flow Summary Diagram:
 
                    ┌──────────────────────────────────┐
                    │          START MAIN              │
                    └──────────────────────────────────┘
                                   │
                                   ▼
                     call → search(matrix, target)
                                   │
               ┌──────────────────────────────────┐
               │  Phase 1: initialize variables   │
               │  rStart=0, rEnd=2, cMid=1        │
               └──────────────────────────────────┘
                                   │
                     while(rStart < rEnd-1)
                                   │
                 ┌─────────────────┴─────────────────┐
                 │  compare matrix[mid][cMid]        │
                 │  if < target → move rStart=mid    │
                 │  if > target → move rEnd=mid      │
                 └───────────────────────────────────┘
                                   │
                        (2 rows remain)
                                   │
         ┌────────────────────────────────────────────┐
         │  Check middle column of rStart, rStart+1   │
         │  If target found → return indices          │
         └────────────────────────────────────────────┘
                                   │
                    ↓ Not found in mid column ↓
                                   │
    ┌────────────────────────────────────────────────────────────────────┐
    │   Check Four Quadrants (subsections of the remaining matrix):      │
    │                                                                    │
    │   Q1: top-left     (rStart,   0 → cMid-1)                         │
    │   Q2: top-right    (rStart,   cMid+1 → cols-1)   ← Target here    │
    │   Q3: bottom-left  (rStart+1, 0 → cMid-1)                         │
    │   Q4: bottom-right (rStart+1, cMid+1 → cols-1)                    │
    └────────────────────────────────────────────────────────────────────┘
                                   │
                     call → binarySearch()
                                   │
                     Found target → return [row, col]
                                   │
                                   ▼
                          Print result in main()
                                   │
                    ┌──────────────────────────────────┐
                    │            END MAIN              │
                    └──────────────────────────────────┘

 */