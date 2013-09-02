/********************************************************
 *  Project :  Assignment 09- Merge Sort
 *  File    :  MergedSort.java
 *  Name    :  Anthony Browness
 *  Date    :  7/10/2013
 *
 *  Description 	: Performs a recursive sort via mergeSort, breaks out of the recursive
 *  					routine at a determined threshold and into a non-recursive insertionSort
 *  					in order to increase efficiency. 
 *
 *	Data Structures	: Linked List, Array
 *
 *  Implementation	: N/A
 *
 *  Methods			: mergedSortTest, insertionSort, internalMergeSort, mergeSort,   
 *
 *  Changes 		: 
 *
 ********************************************************/
import java.util.Random;
public class MergedSort 
{
	int min = 1;
	int max = 1001;
	Random rand = new Random();
	LinkedList list = new LinkedList();
	static int threshold = 30;
	/**
	 * I decided the threshold by running the list in the insertionSort and clocking the time
	 * for each "block" of number placements. I decided what a block was by dividing the total amount
	 * of indexes to be sorted in half for every block thus mimicking the mergeSort timing of blocks.
	 * I ran the same timing in merge sort and found that at around 30 the mergeSort was taking longer than
	 * the insertionSort so I set the threshold there in order to optimize the efficiency of the program.
	 */
	
	/****************************************************
	 * Method     : main
     *
     * Purpose    : Launch the program
     *
     * Parameters : @param args
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public static void main(String[] args) {
		MergedSort sort = new MergedSort();
		sort.mergedSortTest();
	}
	
	/****************************************************
	 * Method     : mergedSortTest
     *
     * Purpose    : Generates a linked list of random integers and sorts them using
     * 				recursive and non-recursive sort routines. Displays the list to the
     * 				user in a 10x10 grid. 
     *
     * Parameters : This method does not require parameters.
     *
     * Returns    : This method does not return a value.
     *
     ****************************************************/
	public void mergedSortTest()
	{
		//fill list with random numbers
		list = new LinkedList();
		for(int i = 0; i < 100; i++)
		{
			int randomNumber = rand.nextInt(max);
			list.add(randomNumber);
		}
		
		//display list
		int e = 0;
		for(int r = 0; r < 10; r++)
		{
			for(int c = 0; c < 10; c++)
			{
				System.out.printf("\t%d", list.get(e));
				e++;
			}
			System.out.println();
		}
		
		//convert to array
		System.out.print("List Size: ");
		System.out.println(list.size());
	
		
		int[] listArray = new int[list.size()];
		for(int i = 0; i < list.size(); i++)
		{
			listArray[i] = (int) list.get(i);
		}
		System.out.println();
		
		//sort array
		mergeSort(listArray);
		
		LinkedList newList = new LinkedList();
		for(int i = 0; i < listArray.length; i++)
		{
			int addNum = listArray[i];
			newList.add(addNum);
		}
		
		//display list
		System.out.println();

		e = 0;
		for(int r = 0; r < 10; r++)
		{
			for(int c = 0; c < 10; c++)
			{
				System.out.printf("\t%d", newList.get(e));
				e++;
			}
			System.out.println();
		}
		System.out.println();
	}

	/**
	 * Sort an array of integers in ascending order using insertion sort.
	 * @param a the array of integers to sort
	 * @throws NullPointerException if the array object is null
	 */
	public static void insertionSort( int[] a, int first, int last) 
	{
		int target; // the element we want to insert
	    int targetPos; // position of the first element of the unsorted section
	    int pos;
	    
	    if ( a == null ) {
	      throw new NullPointerException();
	    }

	    // while the size of the unsorted section is greater than 0
	    // when targetPos reaches a.length, there are no more unsorted elements
	    for ( targetPos = first; targetPos <= last; targetPos++ ) 
	    {
	    	// get a copy of the first element in the unsorted section
	    	target = a[targetPos];

	    	// while there are elements in the unsorted section to examine AND
	    	//  we haven't found the insertion point for target
	    	for ( pos = targetPos - 1; ( pos >= 0 ) && ( a[pos] > target ); pos-- ) 
	    	{
	    		// the element at pos is > target, so move it up in the array
	    		a[pos + 1] = a[pos];
	    	}
	    	// loop postcondition: pos == -1 or a[pos] <= target,
	    	//    so pos + 1 is the new home for target

	    	// insert target in its final sorted position
	    	a[pos + 1] = target;
	   	}
	}
	
	/**
	 * The recursive Merge Sort algorithm.
	 * @pre  The array arguments are not null
	 * @pre  first and last are within the bounds of the inputArray
	 * @post The inputArray is sorted in non-decreasing order.
	 *
	 */
	private static void internalMergeSort( int[] inputArray, int[] tempArray, int first, int last ) 
	{
		if ( ( last - first + 1 ) <= threshold ) 
		{
			insertionSort(inputArray, first, last);
			return; // base case 
	    }

	    // find the mid point of the partition from first to last
		int mid = first + ( ( last - first + 1 ) / 2 );
	    int mid2 = ( first + last ) / 2;
//	    System.out.println( "internalMergeSort(): mid = " + mid + " \tmid2 = " +
//	                        mid2 );
	    internalMergeSort( inputArray, tempArray, first, mid - 1 );
	    internalMergeSort( inputArray, tempArray, mid, last );
	    merge( inputArray, tempArray, first, mid, last );
	}

	private static void merge( int[] inputArray, int[] tempArray, int first, int mid, int last ) 
	{
		int tempSize = last - first + 1;
	    int insertIndex = first;
	    int firstPartitionIndex = 0;
	    int secondPartitionIndex = mid;

	    // copy the first partition to the temp array
	    System.arraycopy( inputArray, first, tempArray, 0, mid - first );

	    while ( ( firstPartitionIndex < ( mid - first ) ) && ( secondPartitionIndex <= last ) ) 
	    {
	    	if ( tempArray[firstPartitionIndex] < inputArray[secondPartitionIndex] ) 
	    	{
	    		inputArray[insertIndex] = tempArray[firstPartitionIndex];
	    		firstPartitionIndex++;
	    	}
	    	else 
	    	{
	    		inputArray[insertIndex] = inputArray[secondPartitionIndex];
	    		secondPartitionIndex++;
	    	}
	    	insertIndex++;
	    }
	    // postcondition: one of the partitions is empty.

	    // if the first partition is empty we are done since the second partition
	    //   is already in inputArray

	    // if the second partition is empty, copy the remainder of the first partition from tempArray
	    while ( firstPartitionIndex < ( mid - first ) ) 
	    {
	    	inputArray[insertIndex] = tempArray[firstPartitionIndex];
	    	firstPartitionIndex++;
	    	insertIndex++;
	    }
	}

	/**
	 * Sort the array of integers using the Merge Sort algorithm.
	 * @param inputArray The array of integers to be sorted.
	 * @throws NullPointerException if the argument is null.
	 */
	public static void mergeSort( int[] inputArray ) 
	{
		if ( inputArray == null ) 
		{
			throw new NullPointerException();
	    }

	    int tempArray[] = new int[inputArray.length / 2];
	    internalMergeSort( inputArray, tempArray, 0, inputArray.length - 1 );
	}


}
