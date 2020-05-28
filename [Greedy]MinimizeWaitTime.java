//Minimize wait time by reordering your task
//<2,5,1,3>
//If that is your input order, your answer will be:
//2 + (2+5) + (2+5+1) + (2+5+1+3) because the last one, will have to wait for everyone else in the front.
//Thus the solution is to sort it and have the smallest one go first.

public static int minimizeWaitTime(int[] array){
  Arrays.sort(array);
  int length = array.length;
  int ans = 0;
  
  for(int i = 0; i < array.length; i++){
    ans = ans + array[i] * length; //This is the number of times it has to wait
    length--;
  }
  return ans;
}
