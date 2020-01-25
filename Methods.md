
# Methods

**Others**
1) Using map or set to store certain values
2) The only way to get a lower average is to encounter a number less than the current average
3) Maximum slice of smallest slice is either 2 or 3.

**Array Methods**

1) Use modulus to shift the array. 
2) Sorting the array

**Counting Method**

This method involves storing the the value of the first array as an index for a new array.

**Caterpillar Method**

This method involves having a starting point and ending point, usually at the start or the end of an array. And then based on some criteria, you move either one of it.

**Prefix Sum Method**

Prefix means before. prefix sum means the sum of everything before this index. The idea is that in a for loop, the value at this index, is the ones of the previous + current. 

Subsequently, if you are asked to find the total from e.g. index 5 to 10. You just have to take index 10's value and minus away the value at index 5 as that comprises of all the value from 1 to 5. 

**Max Slice Method**
The method involves calculating the largest sum at each position. This is under the assumption that if at a particular index, this is the max sum that can be gotten, you can just simply add the next index and this will be the maximum up to including this new index. 
