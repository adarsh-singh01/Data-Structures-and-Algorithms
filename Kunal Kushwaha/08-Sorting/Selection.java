import java.util.Arrays;

public class Selection {
    public static void main(String[] args) {
        int[] arr = {64, 25, 12, 22, 11};
        selectionSort(arr);
        //print the sorted array
        System.out.println(Arrays.toString(arr));
    }

    static void selectionSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            //find the maximum item index in the unsorted array and swap it with correct index
            int lastIndex=arr.length-1-i;
            int maxIndex=getMaxIndex(arr,0,lastIndex);
            //swap the found maximum element with the last unsorted element
            swap(arr,maxIndex,lastIndex);
        }
    }

    static int getMaxIndex(int[] arr, int start, int end){
        int maxIndex=start;
        for(int i=start;i<=end;i++){
            if(arr[i]>arr[maxIndex]){
                maxIndex=i;
            }
        }
        return maxIndex;
    }
    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
