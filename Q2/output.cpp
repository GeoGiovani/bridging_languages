#include <iostream>

using namespace std;

int main (int argc, char** argv) {

    int length = 0;
    scanf("%d", &length);
    cout << length << endl;

    char c;
    while (c != EOF) {
        c = scanf("%c", &c);
        cout << c;
    }
    return 0;
}