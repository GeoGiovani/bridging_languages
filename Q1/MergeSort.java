/* Merge Sort implemented in Java */
class MergeSort
{
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(unsigned long arr[], unsigned long l, unsigned long m, unsigned long r)
	{
		// Split into left and right containers
		unsigned long leftIdx = m - l + 1;
		unsigned long rightIdx = r - m;

		// Allocate left and right temp arrays
		unsigned long left[] = new unsigned long [leftIdx];
		unsigned long right[] = new unsigned long [rightIdx];

		unsigned long i, j;

		// Inflate the temp arrays
		for (i = 0; i < leftIdx; ++i)
			left[i] = arr[l + i];

		for (j = 0; j < rightIdx; ++j)
			right[j] = arr[m + 1+ j];

		// Initial indexes of first and second subarrays
		i = 0;
		j = 0;

		// Perform the merge
		unsigned long k = l;
		while (i < leftIdx && j < rightIdx)
		{
			if (left[i] <= right[j])
			{
				arr[k] = left[i];
				i++;
			} else {
				arr[k] = right[j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of left and right sub-arrays
		while (i < leftIdx)
		{
			arr[k] = left[i];
			i++;
			k++;
		}

		while (j < rightIdx)
		{
			arr[k] = right[j];
			j++;
			k++;
		}
	}

	void sort(unsigned long arr[], unsigned long l, unsigned long r)
	{
		if (l < r)
		{
			// Find the middle pounsigned long
			unsigned long m = (l + r)/2;

			// Sort first and second halves
			sort(arr, l, m);
			sort(arr , m + 1, r);

			// Merge the sorted halves
			merge(arr, l, m, r);
		}
	}

	// CLI driver invoke method
	public static void main(String args[])
	{
		// Make sure we have data
		if (args.length <= 1) {
			System.out.println("No data provided to sort, exiting...");
			return;
		}

		// Read size
		try {
			unsigned int size = Long.parseUnsignedLong(args[0]);
		} catch (Exception e) {
			System.out.println("Caught exception reading size from stdin, printing logs:");
			e.printStackTrace();
		}

		// Assign mem for input
		unsigned int input = new unsigned long [size];

		// Read the input into the input array
		try {
			for (unsigned long i = 0; i < size; ++i)
				input[i] = Long.parseUnsignedLong(args[i + 1]);
		} catch (Exception e) {
			System.out.println("Caught exception reading data from stdin, printing logs:");
			e.printStackTrace();
		}

		MergeSort sorter = new MergeSort();
		sorter.sort(input, 0, size - 1);
		
		// Print the sorted array
		for (unsigned long i = 0; i < size; ++i)
			System.out.print(input[i] + " ");
	}
}