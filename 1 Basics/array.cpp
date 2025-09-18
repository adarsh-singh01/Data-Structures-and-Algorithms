#include <iostream>
using namespace std;
int main() {
    //int a,b,c,d;
    //cin>>a>>b>>c>>d; //what if we had to take like 50 inputs...we can use array
    int arr[5];//every array has fixed size so we have to define size of array at the time of declaration and every element of array is of same data type


    cin>>arr[0]>>arr[1]>>arr[2]>>arr[3]>>arr[4]; //array index starts from 0 to n-1
    cout<<arr[3]; //prints 4th element of array
    arr[2]+=5; //adds 5 to 3rd element of array
    cout<<arr[2];
    return 0;
}

//we dont no that where is 0th index is stored in memory but we know that all elements of array are stored in contiguous memory locations
//if 0th index is stored at address 1000 and each integer takes 4 bytes then 1st index will be stored at 1004,2nd at 1008 and so on
//so if we want to access ith index of array then we can use address of 0