#include "stdio.h"
#include "stdlib.h"

void swap ( long long int arr[], int i, int j ) {
	int temp = arr[i];
	arr[i] = arr[j];
	arr[j] = temp;
}

//Uses the last element in the array to partition
int partition ( long long int arr[], int first, int last ) {
	
	int pivot = arr[last];
	int mid = first; //Keeps track of the last smallest element
	
	//Sweeps through first to last elements of array to place pivot
	for (int i = first; i <= last; i++) {
		if (arr[i] <= pivot) {
			swap (arr, mid, i);
			mid++; 
		}
	}
	return mid-1; 
}

void quicksortR ( long long int arr[], int first, int last ) {
	
	if (first >= last) return;

	//Use partition() to divide array and place last element in its position
	int mid = partition (arr, first, last);

	//Sort the elements smaller than and larger than mid
	quicksortR (arr, mid+1, last);
	quicksortR (arr, first, mid-1);
	
}

int main (int argc, char** argv) {

    //Open file
    FILE *f = fopen(argv[1], "r"); // "r" for read

    //Error check
    if (f == NULL) {
        printf("Ensure data is entered correctly\n");
        return -1;
    }

    //Get length
    long long int length = 0;
    fscanf (f, "%lld", &length);  

    //Gather ints
    long long int arr[length];
    for (int i = 0; i < length; i++) {
        fscanf (f, "%lld", &arr[i]);
    }

    //Sort
    quicksortR(arr, 0, length-1);

	for (long long int i = 0; i < length; i++) {
		printf("%lld ", arr[i]);
	}
	printf("\n");

    return 0;
}