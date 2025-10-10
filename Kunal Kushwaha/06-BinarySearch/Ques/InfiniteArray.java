public class InfiniteArray {
    public static void main(String[] args) {
        int arr[]={3,5,7,9,10,90,100,130,140,160,170};
        int target=10;
        System.out.println(ans(arr,target));
    }

    static int ans(int[] arr,int target){
        //find the range
        //start with box of size 2
        int start=0;
        int end=1;

        //condition for the target to lie in the range

        while(target>arr[end]){
            int temp=end+1;//this is new start

            // Double the range size: increase end by (current range size) * 2
            // (end - start + 1) is the size of current window
            end=end+(end-start+1)*2;
            start=temp;
        }

        return binarySearch(arr, target, start, end);

    }

    static int binarySearch(int arr[],int target,int start,int end){
        while (start<=end){
            int mid=start+(end-start)/2;

            if(target<arr[mid]){
                end=mid-1;
            }
            else if(target>arr[mid]){
                start=mid+1;
            }
            else{
                //ans found
                return mid;
            }
            
        }
        return -1;
    }
}
