#include <iostream>
using namespace std;

int main() {
    int i;
    for (i = 0; i < 5; i++) {//also can be written as for (int i = 0; i < 5; i++) but then i will not be accessible outside the loop
        cout << "Hello, World!"<<i << endl;
    }
    cout<<i;// i is accessible here because it was declared outside the loop and it prints 5

    while(i<10){
        cout<<"Hello, World!"<<i<<endl;
        i++;
    }

    do{
        cout<<"Hello, World!"<<i<<endl;
        i++;
    }while(i<15);//executes at least once even if condition is false
    return 0;
}