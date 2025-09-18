#include <iostream>
using namespace std;//std is standard library which has cout and cin
int main() {
    int age;
    cout << "Enter your age: ";
    cin>>age;

    if (age<18){
        cout<<"not eligible for job"<<endl;
    }
    else if (age>=18 && age<54){
        cout<<"eligible for job"<<endl;
    }
    else if (age>=54 && age<60){
        cout<<"eligible for job but retirement soon"<<endl;
    }   
    else{
        cout<<"already retired"<<endl;
    }   


    //USING NESTED IF ELSE
    if (age<18){
        cout<<"not eligible for job"<<endl;
    }
    else if (age<=57){
        cout<<"eligible for job"<<" ";
        if (age>=54){
            cout<<"but retirement soon"<<endl;
        }
    }
    else{
        cout<<"already retired"<<endl;
    } 
    return 0;//signal to operating system that program ended successfully if we dont write it still it will return 0 but its good practice to write it
}