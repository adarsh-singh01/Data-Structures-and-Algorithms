#include <iostream>
using namespace std;

void pt3(int n){
    
    for(int i=1;i<=n;i++){
        for(int j=1;j<=i;j++){
            cout<<j;
        }
        cout<<endl;
    }
}

int main(){
    int n;
    cout<<"enter the no of rows : ";
    cin>>n;
    pt3(n);
    return 0;
}