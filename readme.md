### This repo consists is an archival of all solutions done on various websites such as leetcode.


####  Common Methods

**Array**

Question: Remove duplicates from sorted array

Method: Keep a pointer of what the position you can overwrite, and use a loop to iterate through. Thus, reducing time complexity by shifting each value at most only once.

**Getting the next largest value**

Question: Find the next largest value 

Method: Find the point until it stops being strictly increasing. Swap this value with a value in that section that is the next greater value than this. Reverse the whole section.

**Array Cyclic rotation**

Question:Problems that can be solved using cyclic rotation

Method: Have a outer loop that loops through everything, but have a while loop inside that will try to complete a cycle. Break the outer loop when everything is done.

**Understanding binary tree traversal**

1. When you see pre/post/in order traversal. Think of it as refer to the node itself. Thus, pre order means n l r while inorder means lnr. These are just various method of traversing the tree.

**Common String problems**
1. Replace and remove: replace all As with Ds and all delete all Bs. The idea is count the required space, which is array + 2As and delete all the Bs. This is done first by a forward iteration, Then we do a backwards iteration. Filling up the array backwards.
2. Reverse a string: The solution is to first, reverse the entire string. So now. What is messed up is that each word is individually reversed. However, each word has the correct length. So now you just have to reverse individual words.

**Binary Search**
1. You can use binary search when you notice you can remove large chunk of numbers
2. For example, finding the largest integer who's square is less than or equal to a input. 
**Common Strategies**
1. Can I use a Hashset or a HashMap to store values that you want to find?
2. Can I sort it?
3. Can I use sliding window?
4. Can I use 2 pointers? Sometimes you can fix a third pointer and move the other 2 pointers
5. Can I keep track of the minimum and maximum value and do some computations?
6. Can I attack it from the front and end and do some sort of computations?
7. Can I use kadane Algorithm and keep track of maximum subarray? Think of contious subarray as a graph, and you are slowly adding it up
8. Can I write values from the back of the array or do overwriting?
 
**Array Methods**

1. Use modulus to shift the array. 
2. The first thing when looking at arrays I always ask is, “does order matter?”. A surprising number of array problems can be optimised and solved by firstly sorting the array.
3. Keep track of the lowest/highest value so far and compare against it as you go on. Updating when necessary.
4. Keep track of the maximum subarray by taking Max(max + A[i], A[i]).
5. Use seperate array to store highest/lowest value so far before this index.

**Counting Method**

This method involves storing the the value of the first array as an index for a new array.

**Sliding window Method**

This method involves having a starting point and ending point, usually at the start or the end of an array. And then based on some criteria, you move either one of it.

**Prefix Sum Method**

Prefix means before. prefix sum means the sum of everything before this index. The idea is that in a for loop, the value at this index, is the ones of the previous + current. 

Usually you will take a index minus another index
Subsequently, if you are asked to find the total from e.g. index 5 to 10. You just have to take index 10's value and minus away the value at index 5 as that comprises of all the value from 1 to 5. 

 1 2 3 4 5 6  [0,1,3,6,10,15,21]  between 2 & 4 i want 12 
 It is always end + 1 minus start 
 
 It is the sum excluding the front that you are minusing away. 
 The third index of the original array, will refer to the sum of the third index (exclusive)
 
 Back - front == number inbetween + back
 
 back - front + 1 == number inbetween + back + front
 
 back - front - 1 == exclusive of both 

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

**Binary Search Method**

This method invovles using binary search to search for the value that you want. It can be anything related to the problem. You use this value to then loop through another function to check if this value is possible or not. 

1.Use   int mid = start + (end - start)/2;  to avoid overflow
2. only do mid + 1 and mid -1, if you are searching for a value, as you will have that checking if mid is the value condition. Thus, only remove this value when you are definitely sure. E.g. refer to search for minimum value.

**Interval Methods**
1. Sort the array and use the earliest time greedily to fit the most number of interval.
2. Sort the arrays, then simply count how many people enter or left based on start time < next end time. 
3. Sort the array by start time, if the next start time is within the current end time, it overlaps. 

**Others**

1) Using map or set to store certain values
2) The only way to get a lower average is to encounter a number less than the current average
3) Maximum slice of smallest slice is either 2 or 3.
4) Using a priority queue
