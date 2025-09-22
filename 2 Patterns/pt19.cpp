#include <iostream>
using namespace std;

void pt19(int n){
    int iniS=0;
    for(int i=0;i<n;i++){

        //stars
        for(int j=1;j<=n-i;j++){
            cout<<"*";
        }
        
        //spaces
        for(int j=0;j<iniS;j++){
            cout<<"-";
        }

        //stars
        for(int j=1;j<=n-i;j++){
            cout<<"*";
        }
        iniS+=2;
        cout<<endl;
    }

    iniS=8;
    for(int i=1;i<=n;i++){

        //stars
        for(int j=1;j<=i;j++){
            cout<<"*";
        }
        
        //spaces
        for(int j=0;j<iniS;j++){
            cout<<"-";
        }

        //stars
        for(int j=1;j<=i;j++){
            cout<<"*";
        }
        iniS-=2;
        cout<<endl;
    }

   /* // Top half of the diamond
    for(int i=1;i<=n;i++){//outer loop for no of rows which is n
        for(int j=1;j<=n-i+1;j++){//inner loop for no of columns which is n-i+1 bcoz in each row, no of columns is decreasing from n to 1
        cout<<"*";
        }
        for(int j=1;j<=2*(i-1);j++){//inner loop for spaces which is 2*(i-1) bcoz in each row, no of spaces is increasing from 0 to 2*(n-1)
        cout<<" ";
        }
        for(int j=1;j<=n-i+1;j++){//inner loop for no of columns which is n-i+1 bcoz in each row, no of columns is decreasing from n to 1
        cout<<"*";
        }
        cout<<endl;
    }
    // Bottom half of the diamond
    for(int i=1;i<=n;i++){//outer loop for no of rows which is n
        for(int j=1;j<=i;j++){//inner loop for no of columns which is i bcoz in each row, no of columns is increasing from 1 to n
        cout<<"*";
        }
        for(int j=1;j<=2*(n-i);j++){//inner loop for spaces which is 2*(n-i) bcoz in each row, no of spaces is decreasing from 2*(n-1) to 0
        cout<<" ";
        }
        for(int j=1;j<=i;j++){//inner loop for no of columns which is i bcoz in each row, no of columns is increasing from 1 to n
        cout<<"*";
        }
        cout<<endl;
    }*/
}

int main(){
    //int n;//no of rows
    //cout<<"enter the no of rows : ";
    //cin>>n;
    pt19(5);

    return 0;
}

/*
OUTPUT IS:

**********
****  ****
***    ***
**      **
*        *
*        *
**      **
***    ***
****  ****
**********
*/