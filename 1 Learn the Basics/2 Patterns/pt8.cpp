#include <iostream>
using namespace std;

void pt8(int n){
    for(int i=1;i<=n;i++){
        //space
        for(int j=0;j<i-1;j++){
            cout<<"-";
        }

        //stars
        for(int j=1;j<=2*(n-i)+1;j++){//bcoz in each row the no. of stars is equal to (2*(n-i)+1)
            cout<<"*";
        }


        //space
        for(int j=0;j<i-1;j++){
            cout<<"-";
        }
        cout<<endl;
    }
    
}

int main(){
    pt8(5);
    return 0;
}

/*

OUTPUT IS 

*********
-*******-
--*****--
---***---
----*----

*/