#include <iostream>

void pt5(int n){
    for(int i=1;i<=n;i++){
        for(int j=n;j>=i;j--){
            std::cout<<"* ";
        }
        std::cout<< std::endl;
    }

    /*
    OR

BECAUSE WE OBSERVE THAT THE NO. OF STARS IN EACH ROW IS EQUAL TO (n-i+1)
    for(int i=1;i<=n;i++){
        for(int j=1;j<=n-i+1;j++){
            std::cout<<"* ";
        }
        std::cout<< std::endl;
    }
    */
}

int main(){
    int m;
    std::cout<<"no. of rows :";
    std::cin>>m;
    pt5(m);
    return 0;
}

/*
OUTPUT of this code will be:
no. of rows :5
* * * * *
* * * *
* * *
* *
*
*/