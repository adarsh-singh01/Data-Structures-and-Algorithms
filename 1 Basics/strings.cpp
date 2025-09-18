#include <iostream>
// #include <bits/stdc++.h>
using namespace std;        
int main(){
    string s="adarsh";//string is a sequence of characters and is used to store text data and each character is stored in contiguous memory locations
    cout<<s[4]<<endl; //prints fifth character of string
    int len=s.size(); //gives length of string
    s[len-1]='u'; //changes last character of string to u
    cout<<s<<endl;
    return 0;
}