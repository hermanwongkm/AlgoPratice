/**
Bob is about to go on a trip. But first he needs to take care of his supply of socks. Each sock has its own color. Bob wants to take as many pairs of clean socks as possible (both socks in the pair should be of the same color).

Socks are divided into two drawers: clean and dirty socks. Bob has time for only one laundry and his washing machine can clean at most K socks. He wants to pick socks for laundering in such a way that after washing he will have a maximal number of clean, same-colored pairs of socks. It is possible that some socks cannot be paired with any other sock, because Bob may have lost some socks over the years.

Bob has exactly N clean and M dirty socks, which are described in arrays C and D, respectively. The colors of the socks are represented as integers (equal numbers representing identical colors).

For example, given four clean socks and five dirty socks:

If Bob's washing machine can clean at most K = 2 socks, then he can take a maximum of three pairs of clean socks. He can wash one red sock and one green sock, numbered 1 and 2 respectively. Then he will have two pairs of red socks and one pair of green socks.

Write a function:

    class Solution { public int solution(int K, int[] C, int[] D); }

that, given an integer K (the number of socks that the washing machine can clean), two arrays C and D (containing the color representations of N clean and M dirty socks respectively), returns the maximum number of pairs of socks that Bob can take on the trip.

For example, given K = 2, C = [1, 2, 1, 1] and D = [1, 4, 3, 2, 4], the function should return 3, as explained above.

Assume that:

        K is an integer within the range [0..50];
        each element of arrays C, D is an integer within the range [1..50];
        C and D are not empty and each of them contains at most 50 elements.


**/



class Solution {
    public int solution(int K, int[] C, int[] D) {
        int pairsOfCleanSocks = 0;
        int value = Math.max(D.length, C.length);
        int[] c1 = new int[51];
        int[] d1 = new int[51];
        
        //You count the number of socks into an array using counting method
        for(int i = 0; i < C.length; i++){
            c1[C[i]] = c1[C[i]] + 1;
        }
        for(int i = 0; i < D.length; i++){
            d1[D[i]] = d1[D[i]]+ 1;
        }
        
        for(int i = 0; i < 51; i++){
            int numOfCleanSocks = c1[i];
            //Remove all pairs of possible cleansocks first
            pairsOfCleanSocks = pairsOfCleanSocks + (numOfCleanSocks/2);
            int remainingCleanSocks = numOfCleanSocks%2;
            
            //Check if you can wash a dirty socks 
            if(remainingCleanSocks == 1 && d1[i] >= 1 && K >= 1){
                K--;
                pairsOfCleanSocks++;
                d1[i] = d1[i] -1;
            }
        }
        //No point washing anymore
        if(K <=1){
            return pairsOfCleanSocks;
        }
        
        //Check if you can wash the remaining dirty socks
        for(int i = 0; i < 51; i++){
            while(d1[i] >= 2){
                K = K - 2;
                d1[i] = d1[i] -2;
                pairsOfCleanSocks++;
                if(K <=1){
                    return pairsOfCleanSocks;
                }
            }
        }
        
        return pairsOfCleanSocks;
    }
}

