
public class MergeSortDemo {

	public static void main(String[] args) {		

		int[] anArray = {9,12,8,7};
//		int[] anArray = {7, 5, 11, 2, 16, 4, 18, 14, 12, 30};
//	    final int MAXSIZE=1000;
//	    int[] anArray=new int[MAXSIZE];
//		for(int i=0;i<MAXSIZE;i++){
//			anArray[i]=MAXSIZE-i;
//		}
		
		System.out.println("Array values before sorting:");
		for (int i = 0; i < anArray.length; i++)
			System.out.print(anArray[i] + " ");
		System.out.println();
	    
		MergeSort.sort(anArray, 0, anArray.length-1);

	    System.out.println("Array values after sorting:");
		for (int i = 0; i < anArray.length; i++)
			System.out.print(anArray[i] + " ");
		System.out.println();

	}

}
