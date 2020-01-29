/**
Problem:You are givennbinary valuesx0, x1, . . . , xn−1, such thatxi∈ {0,1}. This arrayrepresents holes in a roof (1 is a hole). You are also givenkboards of the same size. The goalis to choose the optimal (minimal) size of the boards that allows all the holes to be coveredby boards.Solution:The size of the boards can be found with a binary search. If sizexis sufficient tocover all the holes, then we know that sizesx+1, x+2, . . . , nare also sufficient. On the otherhand, if we know thatxis not sufficient to cover all the holes, then sizesx−1, x−2, . . . ,1are also insufficient
**/
public class test {
  public static int check(int[] A, int numOfBoards) {
    int length = A.length;
    int begin = 1;
    int end = length;
    int result = -1;

    while (begin <= end) {
      int mid = (begin + end) / 2; // Mid is the size of the board
      // Thus you are using binary search to search for the size of the board
      if (checkRequiredBlocks(A, mid) <= numOfBoards) {
        // So i can choose a smaller size board if its still less than the allowed
        // number of boards
        end = mid - 1;
        result = mid;
      } else {
        begin = mid + 1;
      }

    }
    return result;
  }

  public static int checkRequiredBlocks(int[] A, int size) {
    int numOfBoards = 0;
    int last = -1;
    //Loop through the array and place the board at the earliest point possible
    //And let it cover as much as possible
    //Some sort of greedy algo
    for (int i = 0; i < A.length; i++) {
      if (A[i] == 1 && last < i) {
        numOfBoards++;
        last = i + size - 1; // Imagine size of 5. 1 + 5 = 6. But 1 1 1 1 1 - So it will cover only until
                             // index 5.
      }
    }
    return numOfBoards;
  }

  public static void main(String[] args) {
    int[] A = { 0, 1, 0, 1, 1, 1, 0, 1 };
    System.out.println(check(A, 100));
  }

}
