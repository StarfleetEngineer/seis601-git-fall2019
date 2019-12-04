/**
Class for sorting an array of integers from smallest to largest
using the merge sort algorithm.
*/
public class MergeSort
{
    /**
    Precondition: Every indexed variable of the array a has a value.
    Postcondition: a[0] <= a[1] <= . . . <= a[a. length - 1].
    */
    public static void sort(int[] source, int start_index, int end_index)
    {
    	int halfLength = (end_index-start_index+1) / 2;
        if (end_index-start_index+1 >= 2)//recursive case: more than 2 elements
        {            
            //To-Do: 
        	//1. sort the first half of the source
        	sort(source, start_index, start_index + halfLength - 1);
        	//2. sort the second half of the source
        	sort(source, start_index + halfLength + 1, end_index);
            //3. merge the first half and the second half
        	merge(source, start_index, end_index);
        }
        //base:case: only one elements. No need to sort. Return
        return;
    }

    //Precondition: firstHalf and lastHalf are sorted from smallest to largest; a. length = firstHalf.length + lastHalf.length.
    //Postcondition: An array contains all the values from firstHalf and lastHalf and is sorted from smallest to largest.
    private static void merge(int[] source, int start_index, int end_index)
    {
    	//initialization
    	int[] tmp = new int[end_index - start_index + 1];
    	int halfLength = (end_index - start_index + 1) / 2;
    	int firstHalfIndex = start_index, lastHalfIndex = start_index + halfLength, aIndex = 0;
        
    	//To-Do: 
    	//compare the elements in the first and second halves, from small to large elements
    	//copy the smaller one to tmp, 
    	//increase the index in tmp, and first or second half
    	//until we finish copying all elements on one of them. 
    	while (firstHalfIndex < start_index + halfLength && lastHalfIndex <= end_index) {
    		
    		if (source[firstHalfIndex] < source[lastHalfIndex])
    			tmp[aIndex++] = source[firstHalfIndex++];
    		else
    			tmp[aIndex++] = source[lastHalfIndex++];
    		
    	}

        //Copy the rest of firstHalf to the tmp, if any.
    	while (firstHalfIndex < start_index + halfLength) {
    		
    		tmp[aIndex++] = source[firstHalfIndex++];
    		
    	}

        //Copy the rest of lastHalf to the tmp, if any.
    	while (lastHalfIndex <= end_index) {
    		
    		tmp[aIndex++] = source[lastHalfIndex++];
    		
    	}

        // Copy tmp back to source
    	for (int i = 0; i < tmp.length; i++)
    		source[start_index + i] = tmp[i];

    }
}