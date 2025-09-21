#include <iostream>

using namespace std;

void pt4(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            cout<<i;
        }
        cout<<endl;
    }
}

int main(){
    pt4(6);
    return 0;
}

/*
OUTPUT of this code will be:
1
22
333
4444
55555
*/