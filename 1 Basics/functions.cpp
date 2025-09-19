#include <iostream>
using namespace std;
//function is a block of code that performs a specific task and can be reused multiple times in a program
//function declaration
//4 types of functions


//1. function with no return type and no parameters
void printMessage() {//void means no return type...its used when we don't want to return any value from the function i.e. the function performs an action but does not produce a value...here does not return any value means in lamen that it just prints a message and does not give any value back to the caller
    cout << "Hello, World!" << endl;
}
//2. function with return type and no parameters
int getNumber() {
    return 42;
}   
//3. function with no return type and parameters
void printSum(int a, int b) {
    cout << "Sum: " << a + b << endl;
}   
//4. function with return type and parameters
int add(int a, int b) {//it doesnt starts with void because it returns a value of type int ...we could have used void but we would have to use a reference or pointer to store the result and print as cout<<a+b; inside the function
    return a + b;
}

//code to find max of two numbers using function
int findMax(int a, int b) {
    //5>=6
    if (a >= b) {
        return a;
    }
    //looking for a return type but not found so it will give a garbage value
    return b; //else part bcoz...every function with a return type must return a value
}


//PASS BY VALUE  
void doSomething(int x) {//x is a copy of the value passed to the function
    x = x + 10; //modifying x does not affect the original value
    cout << "Inside doSomething: " << x << endl; //prints modified value
    //but the original value remains unchanged
}

//PASS BY REFERENCE
void doSomething2(int &Y) {//Y is a reference to the value passed to the function..This & symbol indicates that Y is a reference variable, meaning it refers to the original variable passed to the function rather than creating a copy of it.
    Y = Y + 10; //modifying Y affects the original value
    cout << "Inside doSomething: " << Y << endl; //prints modified value
    //the original value is changed
}//REMEMBER : in case of arrays its always pass by reference...we can also use pointers to achieve pass by reference but its a bit complex and not recommended for beginners

//function definition and function call 

int main() {
    printMessage(); //calling function with no return type and no parameters
    int num = getNumber(); //calling function with return type and no parameters
    cout << "Number: " << num << endl;
    printSum(5, 10); //calling function with no return type and parameters
    int sum = add(5, 10); //calling function with return type and parameters
    cout << "Sum: " << sum << endl;
    int maxNum = findMax(5, 10); //calling function to find max of two numbers
    cout << "Max: " << maxNum << endl;
    int a = 5;
    cout << "Before doSomething: " << a << endl; //prints original value
    doSomething(a); //calling function with pass by value
    cout << "After doSomething: " << a << endl; //prints original value
    doSomething2(a); //calling function with pass by reference
    cout << "After doSomething2: " << a << endl; //prints modified value
    return 0;
}