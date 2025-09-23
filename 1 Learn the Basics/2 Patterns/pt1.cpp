#include <iostream>
using namespace std;

void pattern1(int n){
    for (int i=1; i<=n;i++){
        for (int j=1;j<=n;j++){
            cout<<"* ";
        }
        cout<<endl;
    }
}

int main() {

    // int n;
    // cout<<"Enter the number of rows: ";
    // cin>>n;
    //pattern1(n);

    //in the coding rounds, your code will be tested against multiple test cases.
    int t;
    cout<<"Enter the number of test cases: ";
    cin>>t;
    for(int i=1;i<=t;i++){
        int n;
        cout<<"Enter the number of rows: ";
        cin>>n;
        pattern1(n);
    }
}

/*

OUTPUT
Enter the number of rows: 4
* * * * 
* * * * 
* * * * 
* * * * 

*/