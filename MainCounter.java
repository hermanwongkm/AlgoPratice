class Solution {
    public int[] solution(int N, int[] A) {
        int[] counter = new int[N];
        int max = 0;
        int currMax = 0;
        int y = 0;
        for (int x : A) {
            if (x == N + 1) {
                currMax = max;
            }

            else {
                if (counter[x - 1] < currMax) {
                    y = currMax + 1;
                } else {
                    y = counter[x - 1] + 1;
                }
                counter[x - 1] = y;
                max = counter[x - 1] > max ? counter[x - 1] : max;

            }
        }
        for (int i = 0; i < counter.length; i++) {
            if (counter[i] < currMax) {
                counter[i] = currMax;
            }
        }
        return counter;
    }
}