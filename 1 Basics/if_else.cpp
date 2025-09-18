#include <iostream>
using namespace std;
int main()//main function is starting point of program if we dont write it program will not run and give error
{
    int marks;
    cout << "Enter your marks: ";
    cin >> marks;

    if(marks<=25) {
        cout << "Grade: F" << endl;
    }
    if(marks<=45) {
        cout << "check kr rha" << endl;//this will run if marks<=25 also because its not else if
    }
    else if(marks<=45) {
        cout << "Grade: E" << endl;
    }
    else if(marks<=50) {
        cout << "Grade: D" << endl;
    }
    else if(marks<=60) {
        cout << "Grade: C" << endl;
    }
    else if(marks<=80) {
        cout << "Grade: B" << endl;
    }
    else {
        cout << "Grade: A" << endl;
    }

    return 0;
}