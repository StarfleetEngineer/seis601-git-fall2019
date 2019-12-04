
public class BubbleSort {
	
	public static void sort(int[] source){
		//To-Do:
		//1) loop (i): To find the i-th smallest element
		for (int i = 0; i < source.length - 1; i++)
			//2) loop (j): check every unsorted element from the the large to small indices
			for (int j = source.length - 1; j > i; j--)
				//3) if the value at index j is smaller than the value at index j-1
				if (source[j] < source[j - 1])
					swap(source, j);
	}
	
	private static void swap(int[] source, int index){
		int temp = source[index];
		source[index]=source[index-1];
		source[index-1]=temp;
	}
	
}
