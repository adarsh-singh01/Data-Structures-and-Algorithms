import java.util.Arrays;

public class Insertion {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        insertionSort(arr);
        //print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    static void insertionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            for(int j=i+1;j>0;j--){
                if(arr[j]<arr[j-1]){
                    swap(arr,j,j-1);
                }else{
                    break;
                }
            }
        }
    }


    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}

/*
 the execution flow of insertion sort(by example of array {64, 25, 12, 22, 11}):
    Step 1: i=0, j=1
        Compare arr[1] (25) with arr[0] (64)
        Since 25 < 64, swap them
        Array after swap: {25, 64, 12, 22, 11}
    Step 2: i=1, j=2
        Compare arr[2] (12) with arr[1] (64)
        Since 12 < 64, swap them
        Array after swap: {25, 12, 64, 22, 11}
        Now, j=1
        Compare arr[1] (12) with arr[0] (25)
        Since 12 < 25, swap them
        Array after swap: {12, 25, 64, 22, 11}
    Step 3: i=2, j=3
        Compare arr[3] (22) with arr[2] (64)
        Since 22 < 64, swap them
        Array after swap: {12, 25, 22, 64, 11}
        Now, j=2
        Compare arr[2] (22) with arr[1] (25)
        Since 22 < 25, swap them
        Array after swap: {12, 22, 25, 64, 11}
        Now, j=1
        Compare arr[1] (22) with arr[0] (12)
        Since 22 >= 12, no swap needed, break inner loop
    Step 4: i=3, j=4
        Compare arr[4] (11) with arr[3] (64)
        Since 11 < 64, swap them
        Array after swap: {12, 22, 25, 11, 64}
        Now, j=3
        Compare arr[3] (11) with arr[2] (25)
        Since 11 < 25, swap them
        Array after swap: {12, 22, 11, 25, 64}
        Now, j=2
        Compare arr[2] (11) with arr[1] (22)
        Since 11 < 22, swap them
        Array after swap: {12, 11, 22, 25, 64}
        Now, j=1
        Compare arr[1] (11) with arr[0] (12)
        Since 11 < 12, swap them
        Array after swap: {11, 12, 22, 25, 64}

IN SHORT:
Initial array: {64, 25, 12, 22, 11}
AFTER STEP 1: {25, 64, 12, 22, 11}
AFTER STEP 2: {12, 25, 64, 22, 11}
AFTER STEP 3: {12, 22, 25, 64, 11}
AFTER STEP 4: {11, 12, 22, 25, 64}

*/