#include <iostream>
using namespace std;

void pt16(int n){
    char alphabet='A';
    for(int i=1;i<=n;i++){
        
        for(int j=1;j<=i;j++){
            cout<<char(alphabet);
        }
        cout<<endl;
        alphabet=alphabet+1;
    }

    /*
    or
    for(int i=1;i<=n;i++){
        char alphabet='A'+i;
        for(int j=1;j<=i;j++){
            cout<<char(alphabet);
        }
        cout<<endl;
    }
    */
}



int main(){
    pt16(5);
    return 0;
}

/*
OUTPUT:
A
B B
C C C
D D D D
E E E E E
*/