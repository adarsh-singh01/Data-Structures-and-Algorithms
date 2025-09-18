#include <iostream>
using namespace std;

int main() {

    //int, float, double, char, bool, long long
    int a = 10;               // Integer data type
    float b = 5.5f;          // Floating point data type
    double c = 9.99;         // Double precision floating point
    char d = 'A';            // Character data type
    bool e = true;           // Boolean data type
    long long f = 1234567890123; // Long long integer
    cout << "Integer: " << a << endl;
    cout << "Float: " << b << endl;
    cout << "Double: " << c << endl;
    cout << "Character: " << d << endl;
    cout << "Boolean: " << e << endl;
    cout << "Long Long: " << f << endl;

    //string,getline
    string str = "Hello, World!";
    cout << "String: " << str << endl;

    //string s;
    //cout << "Enter a string: ";
    //cin>> s;
    //cout << "You entered: " << s << endl;//only single word input
    

    //string s1, s2;
    //cout << "Enter two strings: ";
    //cin >> s1 >> s2;
    //cout << "You entered: " << s1 << " and " << s2 << endl;

    //string str1;
    //getline(cin, str1);//picks full line including spaces but doesnt pick after \n i.e new line
    //cout << "You entered: " << str1 << endl;


    //char input :for single character input
    char ch;
    cin >> ch;
    cout << "You entered: " << ch << endl;

    return 0;
}