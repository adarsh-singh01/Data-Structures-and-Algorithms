#include <iostream>

using namespace std;
#include <vector>
#include <algorithm>
#include <utility> //for pair
#include <bit> // Required in C++20



bool comp(pair<int,int> a,pair<int,int> b){
    if(a.second<b.second) return true;
    if(a.second>b.second) return false;
    if(a.first>b.first) return true;
    return false;

    /*
    or simply
    if(a.second==b.second){
        return a.first>b.first;
    }
    return a.second<b.second;
    */
}

void explainExtra(){
    int a[] = {1, 5, 2, 8, 3};
    int n = sizeof(a)/sizeof(int);
    sort(a, a+n); //sorts in ascending order
    vector<int> v = {4, 1, 3, 9, 2};
    sort(v.begin(), v.end()); //sorts vector in ascending order

    cout<<"Array after sorting: ";
    for(int i=0;i<n;i++){
        cout<<a[i]<<" "; //1 2 3 5 8
    }
    cout<<endl;

    cout<<"Vector after sorting: ";
    for(auto it : v){
        cout<<it<<" "; //1 2 3 4 9
    }

    sort (v.begin(), v.end(), greater<int>()); //sorts vector in descending order
    cout<<"\nVector after sorting in descending order: ";
   for(auto it : v){
       cout<<it<<" "; //9 4 3 2 1
   }

   pair <int,int> arr[] = {{3,4}, {1,2}, {5,6}, {7,8}};

   //sort it acc to second element of pair
   //if second element is same then acc to first element but in reverse order i.e descending order

   //sort(a,a+n,comp);//here comp is comparator function..which is user defined when we want to sort in some custom way

   int num=7;

  // int cnt=_builtin_popcount(num);//gives number of set bits in binary representation of num
  // cout<<"\nNumber of set bits in binary representation of "<<num<<" is: "<<cnt<<endl;

   long long num2=1234567890123;
  // int cnt2=__builtin_popcountll(num2);//for long long

   string s="1234";
   sort(s.begin(),s.end()); //sorts string in lexicographical order
   cout<<"String after sorting: "<<s<<endl; //1234

   do{
         cout<<s<<endl; //prints all permutations of string s in lexicographical order
    }while(next_permutation(s.begin(),s.end()));

    int maximum=*max_element(a,a+n);//gives maximum element in array a
    int minimum=*min_element(a,a+n);//gives minimum element in array a
   
    
}

int main()
{
    explainExtra();
    return 0;
}