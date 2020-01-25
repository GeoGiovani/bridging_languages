#include <iostream>
#include <string>
#include <fstream>

using namespace std;

//Concatenate two strings in camelCase
string camel(string first, string second) {
    second[0] = toupper(second[0]);
    return first + second;
}

//Concatenate two strings in kebab-case
string kebab(string first, string second) {
    return first + "-" + second;
}

//Concatenate two strings in snake_case
string snake(string first, string second) {
    return first + "_" + second;
}

//Concatenate two strings in PascalCase
string pascal(string first, string second) {
    first[0] = toupper(first[0]);
    second[0] = toupper(second[0]);
    return first + second;
}

string assemble(int length, char** words) { 

    //Gather words and assemble
    string front = words[2];
    string back = "";
    string type = words[1];

    //Error check
    if (!(type == "camelCase" || type == "snake_case" 
                || type == "kebab-case" || type == "PascalCase")) {
        cout << "Ensure input is well formed";
        return "";
    }

    //Get type
    for (int i = 3; i < length; i++) {
        back = words[i];
        if (type == "camelCase") { 
            front = camel(front, back);
        }
        else if (type == "snake_case") { 
            front = snake(front, back); 
        }
        else if (type == "kebab-case") { 
            front = kebab(front, back);
        }
        else if (type == "PascalCase") { 
            front = pascal(front, back);
        }
    }
    return front;
}

int main (int argc, char** argv) {
    cout << assemble(argc, argv) << endl;
}