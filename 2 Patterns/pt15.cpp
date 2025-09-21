#include <iostream>

using namespace std;

void pt15(int n){
    for (int i=1;i<=n;i++){
        char a='A';
        for (int j=0;j<=n-i;j++){
            
            cout<<a<<" ";

            a=char(a+1);
        }
        cout<<endl;
    }
}

int main(){
    // char a='A';
    // cout<<char(a+1);
    pt15(5);
    return 0;
}

/*
OUTPUT:

A B C D E 
A B C D
A B C
A B
A

*/