import java.io.*;

/* Merge Sort implemented in Java */
class MergeSort
{
	// Merges two subarrays of arr[].
	// First subarray is arr[l..m]
	// Second subarray is arr[m+1..r]
	void merge(long arr[], long l, long m, long r)
	{
		// Split into left and right containers
		long leftIdx = m - l + 1;
		long rightIdx = r - m;

		// Allocate left and right temp arrays
		long left[] = new long [(int) leftIdx];
		long right[] = new long [(int) rightIdx];

		long i, j;

		// Inflate the temp arrays
		for (i = 0; i < leftIdx; ++i)
			left[(int) i] = arr[(int) (l + i)];

		for (j = 0; j < rightIdx; ++j)
			right[(int) j] = arr[(int) (m + 1 + j)];

		// Initial indexes of first and second subarrays
		i = 0;
		j = 0;

		// Perform the merge
		long k = l;
		while (i < leftIdx && j < rightIdx)
		{
			if (left[(int) i] <= right[(int) j])
			{
				arr[(int) k] = left[(int) i];
				i++;
			} else {
				arr[(int) k] = right[(int) j];
				j++;
			}
			k++;
		}

		// Copy remaining elements of left and right sub-arrays
		while (i < leftIdx)
		{
			arr[(int) k] = left[(int) i];
			i++;
			k++;
		}

		while (j < rightIdx)
		{
			arr[(int) k] = right[(int) j];
			j++;
			k++;
		}
	}

	void sort(long arr[], long l, long r)
	{
		if (l < r)
		{
			// Find the middle pounsigned long
			long m = (l + r)/2;

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
		if (args.length >= 2 || args.length == 0) {
			System.out.println("Invalid command line args, exiting...");
			return;
		}

		long size = 0;
		File inFile;
		BufferedReader br;

		// Read file
		try {
			inFile = new File(args[0]);
			br = new BufferedReader(new FileReader(inFile));
		} catch (Exception e) {
			System.out.println("Caught exception reading file, printing logs:");
			e.printStackTrace();
			return;
		}

		// Read size
		try {
			size = Long.parseLong(br.readLine());
			if (size == 0) {
				return;
			}
		} catch (Exception e) {
			System.out.println("Caught exception reading size from stdin, printing logs:");
			e.printStackTrace();
			return;
		}

		// Assign mem for input
		long input[] = new long [(int) size];

		// Read the input into the input array
		try {
			String[] inputStr = br.readLine().split(" ");

			if (size != inputStr.length) {
				System.out.println("Input data length doesn't match the give size, exiting...");
				return;
			}

			for (long i = 0; i < size; ++i)
				input[(int) i] = Long.parseLong(inputStr[(int) i]);

		} catch (Exception e) {
			System.out.println("Caught exception reading data from stdin, printing logs:");
			e.printStackTrace();
			return;
		}

		MergeSort sorter = new MergeSort();
		sorter.sort(input, 0, size - 1);

		// Print the sorted array
		for (long i = 0; i < size; ++i)
			System.out.print(input[(int) i] + " ");

		try {
			br.close();
		} catch (Exception e) {
			return;
		}
	}
}