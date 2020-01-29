### This repo consists is an archival of all solutions done on various websites such as leetcode.


####  Common Methods

**Array Methods**

1) Use modulus to shift the array. 
2) Sorting the array

**Counting Method**

This method involves storing the the value of the first array as an index for a new array.

**Caterpillar Method**

This method involves having a starting point and ending point, usually at the start or the end of an array. And then based on some criteria, you move either one of it.

**Prefix Sum Method**

Prefix means before. prefix sum means the sum of everything before this index. The idea is that in a for loop, the value at this index, is the ones of the previous + current. 

Usually you will take a index minus another index
Subsequently, if you are asked to find the total from e.g. index 5 to 10. You just have to take index 10's value and minus away the value at index 5 as that comprises of all the value from 1 to 5. 

 1 2 3 4 5 6  [0,1,3,6,10,15,21]  between 2 & 4 i want 12 
 It is always end + 1 minus start 
 
 The third index of the original array, will refer to the sum of the third index (exclusive)

**Max Slice Method**

The method involves calculating the largest sum at each position. This is under the assumption that if at a particular index, this is the max sum that can be gotten, you can just simply add the next index and this will be the maximum up to including this new index. 

This is also known as the Kadane algorithm and you can loop it backwards to calculate the sum starting from index i.

Whereas, if you loop from the front, it is calculating ending with index i. 

**Stack Method**

Use a stack to solve the problem. Matching brackets. 

**Leader Method**
This method involves finding an element in an array who occur more than n/2. 
This is based on the idea that there can only be one leader even if you split the array because no matter what it will occupy at least half. 
You can maintain a virtual stack, just keep track of the last value as anything below that will be the same. And just pop off any values that are not equals the stack value. 

**Others**

1) Using map or set to store certain values
2) The only way to get a lower average is to encounter a number less than the current average
3) Maximum slice of smallest slice is either 2 or 3.
