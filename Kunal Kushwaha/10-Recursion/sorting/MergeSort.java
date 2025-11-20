import java.util.Arrays;


/*
1. divide array into two parts
2. get both parts sorted recursively
3. merge two sorted parts

at every level,n elements are being merged.

Time complexity: O(n log n)
space complexity: O(n) for merge function

T(n)=2T(n/2)+(n-1)

whats merge sort in place?
In merge sort in place, we avoid creating new arrays for the left and right halves during the division step.

*/
public class MergeSort {
    public static void main(String[] args) {
      int[] arr={5,4,3,2,1};
      //mergeSort(arr); //it wont work as expected because arrays are reference types 
        //arr=mergeSort(arr);//it will work as expected because we are reassigning the sorted array to arr
       mergeSortInPlace(arr, 0, arr.length); 
      System.out.println(Arrays.toString(arr));
    }

    static int[] mergeSort(int[] arr){
        if(arr.length==1){
            return arr;
        }

        int mid=arr.length/2;
        int[] left=mergeSort(Arrays.copyOfRange(arr, 0, mid));
        int[] right=mergeSort(Arrays.copyOfRange(arr, mid, arr.length));

        return merge(left, right);
    }

    private static int[] merge(int[] first, int[] second) {
        int[] mix=new int[first.length+second.length];

        int i=0;
        int j=0;
        int k=0;

        while(i<first.length && j<second.length){
            if(first[i]<second[j]){
                mix[k]=first[i];
                i++;
            }else{
                mix[k]=second[j];
                j++;
            }
            k++;
        }

        // it may be possible that one of the arrays is not complete 
        //so we need to copy the remaining elements
        while(i<first.length){
            mix[k]=first[i];
            i++;
            k++;
        }

        while(j<second.length){
            mix[k]=second[j];
            j++;
            k++;
        }

        return mix;
    }


    static void mergeSortInPlace(int[] arr, int start, int end){
        if(end-start==1){
            return;
        }


        int mid=(start+end)/2;
        mergeSortInPlace(arr, start, mid);
        mergeSortInPlace(arr, mid, end);

        mergeInPlace(arr, start, mid, end);
    }

    private static void mergeInPlace(int[] arr, int start, int mid, int end) {
        int[] mix=new int[end-start];
        int i=start;
        int j=mid;
        int k=0;
        while(i<mid && j<end){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            }else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
        while(i<mid){
            mix[k]=arr[i];
            i++;
            k++;
        }

        while(j<end){
            mix[k]=arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < mix.length; l++) {
            arr[start+l]=mix[l];
        }
    }
}