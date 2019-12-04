
public class MergeSortDemoMT{

	public static void main(String[] args){

//		int[] anArray = {9,12,8,7};
		int[] anArray = {7, 5, 11, 2, 16, 4, 18, 14, 12, 30};
//	    final int MAXSIZE=10000;
//	    int[] anArray=new int[MAXSIZE];
//		for(int i=0;i<MAXSIZE;i++){
//			anArray[i]=MAXSIZE-i;
//		}
	    
		int[] result = new int[anArray.length];
		System.out.println("Array values before sorting:");
		for (int i = 0; i < anArray.length; i++)
			System.out.print(anArray[i] + " ");
		System.out.println();

		//new a MergeSortMT thread t1
		MergeSortMT t1 = new MergeSortMT(anArray, 0, anArray.length-1);
		//Start running the thread
		t1.start();
		//Wait for t1.
		try{
			t1.join();
		}catch(InterruptedException e){
			e.printStackTrace();
		}

		System.out.println("Array values after sorting:");
		for (int i = 0; i < anArray.length; i++)
			System.out.print(anArray[i] + " ");
		System.out.println();
	}

}
