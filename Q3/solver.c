#include <stdio.h>
#include <stdlib.h>

void main(int argc, char* argv[]) {
	if (argc != 4) {
		printf("0.0");
	}

	if (argv[1] == "*") {
		printf("%lf", atof(argv[2]) * atof(argv[3]));
	} else if (argv[1] == "/") {
		printf("%lf", atof(argv[2]) / atof(argv[3]));
	} else if (argv[1] == "+") {
		printf("%lf", atof(argv[2]) + atof(argv[3]));
	} else if (argv[1] == "-") {
		printf("%lf", atof(argv[2]) - atof(argv[3]));
	}
}