/*
GCD : Greatest Common Divisor is the largest number that divides both numbers without leaving a remainder.
HCF : Highest Common Factor is the largest number that divides both numbers without leaving a remainder.

Here we will write a function to find GCD using Euclidean algorithm. which is GCD(a, b) = GCD(a-b,b) a>b

example: GCD(20,15)=GCD(5,15)=GCD(10,5)=GCD(5,0)=GCD(0,5)=5

thats a lot of steps.So, we can optimize it by using the property that GCD(a,b) = GCD(a%b , b)


Time Complexity:

O(log phi (min(a, b)))


*/

#include <iostream>

// Function to compute GCD using Euclidean algorithm
int gcd(int a, int b) {
    while (a > 0 && b > 0) {
        if (a > b)
            a = a % b;
        else
            b = b % a;
    }
    // One of a or b is 0 here; return the non-zero one
    return (a == 0) ? b : a;
}

int main() {
    int a, b;
    std::cout << "Enter two numbers: ";
    std::cin >> a >> b;

    std::cout << "GCD of " << a << " and " << b << " is: " << gcd(a, b) << std::endl;
    return 0;
}

