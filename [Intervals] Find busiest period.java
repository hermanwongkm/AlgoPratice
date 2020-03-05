/**

Find the point where maximum intervals overlap

Consider a big party where a log register for guest’s entry and exit times is maintained. Find the time at which there are maximum guests in the party. Note that entries in register are not in any order.

Example :

Input: arrl[] = {1, 2, 9, 5, 5}
       exit[] = {4, 5, 12, 9, 12}
First guest in array arrives at 1 and leaves at 4, 
second guest arrives at 2 and leaves at 5, and so on.

Output: 5
There are maximum 3 guests at time 5.  
**/
//The idea is to sort it. 
//After sorting it, we track the number of people currently in the gym
//If someone leaves, meaning that exit is greater than entry. we minus.
//Else if entry is less than exit, it means no one exited yet.

  static void findMaxGuests(int entry[], int exit[]){    
    // Sort arrival and exit arrays 
    Arrays.sort(entry); 
    Arrays.sort(exit); 
    int i = 1; 
    int j = 0;
    int max = 1;
    int currGuest = 1;
    int time = entry[0];
    
    while(i < entry.length && j < exit.length){
      if(entry[i] <= exit[j]){
        currentGuest++;    

      if(currentGuest > max){
        max = currentGuest;
        time = entry[i];
      }
    i++
    }
    else{
      currentGuest--;
      j++;
    }
  
  }
  
  
