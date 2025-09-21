#include <iostream>

using namespace std;

void pt6(int n){
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n-i+1;j++){
            cout<<j;
        }
        cout <<endl;
    }
}

int main(){
    int m;
    cin>>m;
    pt6(m);
    return 0;
}

/*
OUTPUT of this code will be:
12345
1234
123
12
1
*/