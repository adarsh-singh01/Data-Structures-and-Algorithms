// this is  hello world program but ask name of user and greet them

import java.util.Scanner;

public class CppCompare {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.println("Hello, " + name + "! Welcome to the program.");

        scanner.close();
    }
}

/*
 
#include <iostream>
#include <string>

int main() {
    std::string name;

    std::cout << "Enter your name: ";
    std::getline(std::cin, name);

    std::cout << "Hello, " << name << "! Welcome to the program." << std::endl;

    return 0;
}


 */
