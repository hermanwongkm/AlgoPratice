#  Table of Content

1. Arrays
2. Searching
3. Sorting

## Arrays

Common array methods
1. Keep track of the lowest/highest value so far. Use this to compare against or as an answer. (Q1,Q3)
2. Have an index called indexToOverwrite so you can do inplace overwriting. (Q2)
3. Use 2 pass, one forward and one backwards to do various computations. (Q3)
4. Finding the next larger number involves finding a increasing subsequence, and doing a swap. (Q4)
5. Perform a cyclic rotation when doing swapping (Q7)
6. Do a forward pass and remove and values not needed, populate the array backwards might be able to solve some questions.

Other unusual array questions
1. Sieve of Eratosthenes (Return all prime between 1 and the given integer k) - Have an array of size k all set to true initially. For every number that is a prime, we add it to ans, then set false to all of its multiple using another loop. e.g. i = i + 2 in the loop. Then you use this boolean array to check if it is prime or not. The case from 1-9 will set all its multiples to false. 
2. Reservoir sampling - It is a randomized sampling technique for endless data. It decreases the probability as you work your way towards the end of the data.

---
Question 1

*Find out if you are able to reach the end of the the array, where each index represent maximum value you can advance.*

Solution: Loop through the whole array and keep track of the maximum index you can advance to. Then check if it is the last index.

Code: [Jump Game](./[Array]JumpGame.js)

---

Question 2

*Remove duplicates from sorted array without using additional space*

Solution: Keep a pointer of what the position you can overwrite (In this case start with overwrite = 0 and i = 1). Use a loop to iterate through and compare against indexToOverwrite. If it is the same, if it is a different number, overwrite and increment overwriteIndex.

Code: [Remove Duplicate in Sorted Array](./[Array]Removeduplicates.js)

---

Question 3

*Best time to buy and sell a stock Once/Twice*

Solution (Once): Keep track of the minimum stock price, and loop through the array. Just find the maximum possible difference.

Solution (Twice): Keep track of the maximum profit you can get in the first pass and store it in an array. Then do a backwards pass and add the current profit to the maximum profit possible from the previous array.

Code: [Best Time to Buy and Sell a Stock Once](./[Array]BestTimeToBuyStockOnce.java)

Code: [Best Time to Buy and Sell a Stock Twice](./[Array]BestTimeToBuyStockTwice.js)

---

Question 4

*Next greater permutation/number*

Solution:

1. We want to increase the permutation as little as possible, like a car odometer. We begin by looking from right to left, a increasing subsequence. e.g. xxxk5430. This, is also the largest possible value and thus, cannot simply modify this to increase it further. 

2. Then, we take the value, k, just before this subsequence. This value k, will definitely be smaller than some value in the subsequence. e.g. 1. Remember that our goal, is to increase our entire number. This can be done by swapping k, with a value larger than k to increase the entire number. Thus, now, you will find the next larger element greater than k in the subsequence and swap it with k.

3. Now, the subsequence may not be the smallest. Since the number were increasing, we can simply reverse it so that it will be the smallest possible value. 

Code: [Next Permutation](./[Array]NextPermutation.js)

---

Question 5 (2D Matrix)

*Spiral Matrix*

Solution: You will generally have 4 loops. 1 to go across, 1 to go down, 1 to go left and last to go up. Everytime you finish and outer layer, you will increment and decrement the "matrix size" to move to the next layer.

Code: [Spiral Matrix](./[Array]SpiralMatrix.js)

---

Question 6 (2D Matrix)

*Rotate 2D array*

Solution: Perform a inplace rotation layer by layer using a 4 way swap.

Code: [Rotate 2D Matrix](./[Array]RotateImage.js)

---

Question 7 

*Rotate 1D array*

Solution: Perform a cyclic rotation. You will have 2 loops. The outer for loop will just go through all the indexes. The second while loop, will perform the cyclic rotation until you return to the original position again. You may have like certain condition to check if you finish everything or not.

Code: [Rotate 1D Array](./[Array]ArrayRotation.js)

---
## Searching

Common Searching methods
1. Use binary search. Note, use int mid = start + (end - start)/2;  to avoid overflow. You can make use of the sorted order to dispose of values you do not need/do not meet certain conditions. (Q1,Q2)
2. Make use of the sorted property in a 2D array, and reduce either column or row.
3. Use quickselect

---

Question 1

*Find first and last position of element*

Solution: Perform binary search. 

Code: [First and Last Position of Element](./[Search]FindFirstAndLastPositionOfElement.js)

---


Question 2

*Find in a sorted array where its entry is equals to its index*

Solution: Perform binary search. This is based on the principle of that the difference between an entry and its index increases by at least1 as we iterate through A. Observe that if A[j] > j, then no entry after j can satisfy the given criterion. This is because each element in the array is at least 1 greater than the previous element. For the same reason, if A[j] < j, no entry before j can satisfy the given criterion.

Code: [Search in Sorted Array Where Entry Equals Index](./[Search]SearchSortedArrayEntryEqualsIndex.js)

---

Question 3

*Search in a sorted 2D array*

Solution: The idea is to either reduce the row or column with every pass. For every pass, look at the top right corner, if it is less than the top right corner, the entire column will be invalid as it is all greater than the value. Else, if it is greater, the entire row will be invalid as the entire row itself will be smaller than this value.

Code: [Search in Sorted 2D array](./[Search]SearchIn2DArray.js)

---

Question 4

*Find the kth largest element in the array*

Solution: 
1. Create a swap function. 
2. Use the end as a pivot point.
3. Have another variable called anythingBeforeThisIsLess, which itself is self explainatory.
4. If the value is less than pivot value, you swap with this index and increment this pointer.
4.1. You can do this swapping as the for loop with naturally increment it, and the swapped value is still at the right partition.
5. Else, do nothing, because it means it is greater and it is also infront of this pivot.
6 Swap the pivot point over.
7. Discard either the left or right side depending on what index this value is.

Code: [Quickselect]([Search]QuickSelectFindKthLargestElement.js)

## Sorting

Common sorting methods
1. 1 forward pass and 1 backward pass using "quicksort"
---

Question 1

*Dutch Flag problem - Sort them in-place so that objects of the same color are adjacent*

Solution: Have 2 pass of "quickSort". The first forward pass will sort everything less than 1. The second backwards pass will sort everything greater than 1.

Code: [Dutch Flag](./[Sorting]DutchFlag.java)

---

**Understanding binary tree traversal**

1. When you see pre/post/in order traversal. Think of it as refer to the node itself. Thus, pre order means n l r while inorder means lnr. These are just various method of traversing the tree.

**Common String problems**
1. Replace and remove: replace all As with Ds and all delete all Bs. The idea is count the required space, which is array + 2As and delete all the Bs. This is done first by a forward iteration, Then we do a backwards iteration. Filling up the array backwards.
2. Reverse a string: The solution is to first, reverse the entire string. So now. What is messed up is that each word is individually reversed. However, each word has the correct length. So now you just have to reverse individual words.

**Solving sorted array questions**
1. Iterate both pointers at the same time. These are problems such as find *intersection of array*
2. Fill up the array from the back. This is good for sorted array as if it is sorted, you'll not touch/overwrite the front of that array unnecessarily. These are problems such as *merge 2 sorted array*

**Solving interval questions**
1. *Question on number of concurrent events running* Sort the arrays by both the starting and ending point. Then, if it is starting, you will add to count. If it is a ending, you can minus. This will give you the number of concurrent events running.
2. (*Merge intervals*) Sort the array by start time, if the next start time is within the current end time, it overlaps. 
3. (*Remove overlap*) Sort the array and use the earliest end time greedily to fit the most number of interval. The interval with early start might be very long and incompatible with many intervals. But if we choose the interval that ends early, we'll have more space left to accommodate more intervals. Hope it helps.

**Common Strategies**
1. Can I use a Hashset or a HashMap to store values that you want to find?
2. Can I sort it?
3. Can I use sliding window?
4. Can I use 2 pointers? Sometimes you can fix a third pointer and move the other 2 pointers
6. Can I attack it from the front and end and do some sort of computations?
7. Can I use kadane Algorithm and keep track of maximum subarray? Think of contious subarray as a graph, and you are slowly adding it up
8. Can I write values from the back of the array or do overwriting?
 
**Array Methods**

1. Use modulus to shift the array. 
2. The first thing when looking at arrays I always ask is, “does order matter?”. A surprising number of array problems can be optimised and solved by firstly sorting the array.
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


**Leader Method**
This method involves finding an element in an array who occur more than n/2. 
This is based on the idea that there can only be one leader even if you split the array because no matter what it will occupy at least half. 
You can maintain a virtual stack, just keep track of the last value as anything below that will be the same. And just pop off any values that are not equals the stack value. 

**Others**

1) Using map or set to store certain values
2) The only way to get a lower average is to encounter a number less than the current average
3) Maximum slice of smallest slice is either 2 or 3.
4) Using a priority queue
