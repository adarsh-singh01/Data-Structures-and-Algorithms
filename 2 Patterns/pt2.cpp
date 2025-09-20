#include <iostream>
using namespace std;

void pt2(int n){
    
    for(int i=1;i<=n;i++){//outer loop for no of rows which is n
        for(int j=1;j<=i;j++){//inner loop for no of columns which is i bcoz in each row, no of columns is equal to no of rows..if inspite of i, we put n, then it will print a square pattern
        cout<<"* ";
        }
        cout<<endl;
    }
}

int main(){
    int t;//no of test cases
    cout<<"enter no. of test cases u wanna perform : ";
    cin>>t;
    for(int i=1;i<=t;i++){//loop for no of test cases
        int n;//no of rows
        cout<<"enter the no of rows : ";
        cin>>n;
        pt2(n);
    }
    
    return 0;
}

/* 
This function prints a right-angled triangle pattern of asterisks 

like this:
For n = 4:

*
* *
* * *
* * * *

*/