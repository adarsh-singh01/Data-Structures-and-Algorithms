#include <iostream>
using namespace std;

void pt8(int n){
    for(int i=1;i<=n;i++){
        //space
        for(int j=0;j<i-1;j++){
            cout<<"-";
        }

        //stars
        for(int j=1;j<=2*(n-i)+1;j++){
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