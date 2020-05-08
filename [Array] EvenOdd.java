/**
reorder its entries so that the even entries appear first. This is easy if you use 0(n) space, where n is the length of the array. 
**/

public static void evenOdd(int[] A){
  int evenCounter = 0;
  int oddCounter = A.length - 1;
  
  while(evenCounter < oddCounter){
    if(A[evenCounter] % 2 == 0){ //I will just proceed
      evenCounter++;
    }else{
    //Do swapping
      int temp = A[oddCounter];
      A[oddCounter] = A[EvenCounter];
      A[evenCounter] = temp;
      oddCounter--;
    }
  }
}
