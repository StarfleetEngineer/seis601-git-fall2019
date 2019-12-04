/**
Class for sorting an array of integers from smallest to largest
using the merge sort algorithm.
*/
//To make a multithreaded merge sort, the class MergeSortMT should extend Threads
//To-Do: extends Thread
public class MergeSortMT extends Thread
{
	int[] source;
    int halfLength,start_index,end_index;

    //Constructor
    //Initialize the data that the thread is going to sort
	MergeSortMT(int[] source, int start_index, int end_index){
		halfLength = (end_index-start_index+1) / 2;
		this.source = source;
		this.start_index = start_index;
		this.end_index = end_index;
    }
	
	/**
    Precondition: Every indexed variable of the array a has a value.
    Postcondition: a[0] <= a[1] <= . . . <= a[a. length - 1].
    */
	//The thread is started at run()
	//This method is essentially the same as the sort method in the MergeSort class
    public void run()
    {
        if (end_index-start_index+1 >= 2)//recursive case: more than 2 elements
        {        
            //To-Do: 
        	//1. sort the first half of the source in one thread
        	MergeSortMT t1 = new MergeSortMT(source, start_index, start_index + halfLength - 1);
        	//2. sort the second half of the source in another thread
        	MergeSortMT t2 = new MergeSortMT(source, start_index + halfLength, end_index);
        	t1.start();
        	t2.start();
        	//3. wait for the two threads to finish
        	try {
        		
        		t1.join();
        		t2.join();
        		
        	} catch(InterruptedException e) {
        		
        		e.printStackTrace();
        		
        	}
            
        	//merge the first half and the second half        	
            merge(source, start_index, end_index);
        }
        //base:case: only one elements. No need to sort. Return
        return;
    }

    //Precondition: firstHalf and lastHalf are sorted from smallest to largest; a. length = firstHalf.length + lastHalf.length.
    //Postcondition: An array contains all the values from firstHalf and lastHalf and is sorted from smallest to largest.
    private static void merge(int[] source, int start_index, int end_index)
    {
    	int[] tmp= new int[end_index-start_index+1];
    	int halfLength = (end_index-start_index+1) / 2;
    	int firstHalfIndex = start_index, lastHalfIndex = start_index+halfLength, aIndex = 0;
        while ((firstHalfIndex < start_index+halfLength) &&
               (lastHalfIndex <= end_index))
        {
           if (source[firstHalfIndex] < source[lastHalfIndex])
           {
        	   tmp[aIndex++] = source[firstHalfIndex++];
           }
           else
           {
        	   tmp[aIndex++] = source[lastHalfIndex++];
           }
           //At this point, at least one element from firstHalf or lastHalf has been copied to a.
         }           
        //At this point, either firstHalf or lastHalf has been completely copied to a.

        //Copy rest of firstHalf, if any.
        while (firstHalfIndex < start_index+halfLength)
        {
            tmp[aIndex++] = source[firstHalfIndex++];
        }
        //Copy rest of lastHalf, if any.
        while (lastHalfIndex <= end_index)
        {
            tmp[aIndex++] = source[lastHalfIndex++];
        }
        // Copy tmp back
        for(int i = 0; i < tmp.length; i++)
            source[start_index+i] = tmp[i]; 
    }
}