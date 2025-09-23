#include <iostream>

using namespace std;

void pt7(int n){
    for(int i=1;i<=n;i++){
        //space
        for(int j=1;j<=n-i;j++){
            cout<<"-";
        }
        //stars
        for(int j=0;j<i*2-1;j++){
            cout<<"*";
        }
        //space
        for(int j=1;j<=n-i;j++){
            cout<<"-";
        }
        cout<<endl;
    }

    /*
    OR

    for (int i = 0; i < n; i++) {
        // space
        for (int j = 0; j < n - i - 1; j++) {
            cout << "-";
        }
        
        // stars
        for (int j = 0; j < 2 * i + 1; j++) {
            cout << "*";
        }
        
        // space
        for (int j = 0; j < n - i - 1; j++) {
            cout << "-";
        }

        cout << endl;
    }
    */
}

int main(){
    pt7(5);
}

/*
OUTPUT :
----*---- 
---***---
--*****--
-*******-
*********

*/