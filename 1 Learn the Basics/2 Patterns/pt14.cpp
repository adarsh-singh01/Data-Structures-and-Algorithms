#include <iostream>

using namespace std;

void pt13(int n){
    for (int i=1;i<=n;i++){
        char a='A';
        for (int j=1;j<=i;j++){
            
            cout<<a<<" ";

            a=char(a+1);
        }
        cout<<endl;
    }
}

int main(){
    // char a='A';
    // cout<<char(a+1);
    pt13(5);
    return 0;
}