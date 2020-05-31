/**
Given an unsorted array of integers. Find an element such that all the elements to its left are smaller and to its right are greater. Print -1 if no such element exists.

Note that there can be more than one such elements. For example an array which is sorted in increasing order all elements follow the property. We need to find only one such element.

Examples :


Input :  A[] = {4, 3, 2, 5, 8, 6, 7}  
Output : 5 

Input : A[] = {5, 6, 2, 8, 10, 9, 8} 
Output : -1

**/


static int FindElement(int[] A, int n){
  int[] GE = new int[A.length];
  int[] SE = new int[A.length];
  
  GE[0] = A[0];
  SE[A.length-1] = A[A.length-1];
  
  //Since we want everything to the left of the element to be smaller, we will keep track of the largest number until this point i
  for(int i = 1; i < A.length; i++){
    if(GE[i-1] > A[i]){ //If the old values are largest than current value, you continue using it as it is the largest to the left
      GE[i] = GE[i-1];
    }
    else{ //Means the current index is larger
      GE[i] = A[i];
    }
  }
  
  //Same concept for the SE, which go from right to left and keep track of the smallest value so far as we want to be
  //the value to the right to be bigger than the index i. So we have to keep the smallest value and check if it is larger than the index we are comparing later
  for (int i = n - 2; i >= 0; i--){ 
    if (A[i] < SE[i + 1]){
      SE[i] = A[i];
    }
    else{
      SE[i] = SE[i+1];
    }
    
  //Now i will loop through the array and ensure that its left is smaller and right is greater
  for(int i = 0; i < A.length; i++){
    if(A[i] < SE[i + 1] && A[i] > GE[i-1]){
    return A[i]
    }
    //This is to check edge condition 
    if(i == 0 && A[i] < SE[i+1] || i = A.length-1 && A[i] > GE[i-1]){
      return A[i];
    }
  }
}
    
