#  Table of Content

1. Arrays
2. Searching
3. Sorting
4. Binary Tree
5. Stack
6. String
7. Greedy

Others
1. SQL/Database design

## Arrays

Common array methods
1. Keep track of the lowest/highest value so far. Use this to compare against or as an answer. (Q1,Q3)
2. Have an index called indexToOverwrite so you can do inplace overwriting. (Q2)
3. Use 2 pass, one forward and one backwards to do various computations. (Q3)
4. Finding the next larger number involves finding a increasing subsequence, and doing a swap. (Q4)
5. Perform a cyclic rotation when doing swapping (Q7)
6. Do a forward pass and remove and values not needed, populate the array backwards might be able to solve some questions.
7. Can sorting help? If yes, skip to sorting section.
8. Keep 2 pointers, 1 in the front, 1 in the back. Sliding window method.
9. Save it to their respective index corresponding to the number

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

Code: [Remove Duplicate in Sorted Array](./[Array]RemoveduplicatesSorted.js)

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
Question 8

*Longest subarray with distinct element*

Solution: Use a hashtable to store the most recent occurance of the element. If we meet this element again, you use this value to minus the startIndex and check if it is longer. Then set that index as the new start index. 

Solution: Another method is that you can use a second pointer, and slowly move it forward when you see a character you seen before.

Code: [Longest distinct substring with hashmap](./[Array]LongestDistinctSubstring.js)

Code: [Longest distinct substring without hashmap](./[SlidingWindow]LongestDistinctSubstring.java )


---

Question 9

*Given an unsorted array of integers, find the length of the longest consecutive elements sequence, not in terms of adjacent index*

Solution: Store everything inside a hashset. Now, for each value, you will slowly -1 each time, and remove it from the set if it exist. If it does not, break and do an increment. The range from highest to lowest is your length of elements that are adjacent to each other.

Code: [Longest Consequentive in a array (not adjacent)](./[Array]LongestConsequentiveSequence.js)


---


Question 10

*3 Sum*

Solution: Loop through the array. For each index, based on the sorted property, we will have a pointer at the front and one at the end. If the sum of both of this value is greater than target - sum, this means that we need a smaller number, so we move the right point left. Else we move the left pointer right. 

Code: [3 Sum](./[Array]3Sum.java)

Code: [2 Sum](./[Array]2Sums.java)

---


Question 11

*Maximum Trapped Water*

Solution: We considerate the widest possible length, which is start and end of index. The idea is now to explore the best way to trade off width for height. You are reducing width, hoping to get a higher height. You will move the shorter index. If it is equal, you can move both inwards, as this is the max you can get with 2 index of the same height. 

Code: [Maximum Trapped Water](./[Array]MaximumTrappedWater.java)


---

Question 12

*Smallest Missing Number*

Solution: Some initial methods are to use a hashtable or sorting to solve the problem. We can save the number to its respective index and perform swap. Then go through the array one more time to see if the number are in their respective position. 

Code: [Small Missing Number](./[Array]SmallestMissingNumber.java)


---

Question 13

*Maximum subarray*

Solution: Loop through the array, for each iteration, you take the max as `prevMax` or previous continious array + current index. The idea is that, if it goes below your max, say even the first index, even if the next one is larger, you can just take the next one instead of including that negative number.

Code: [Maximum subarray](./[Array]MaximumSubarray.java )


---

Question 14

*Maximum Contiguous Product*

Solution: The idea to keep track both the minimum (which will definitely be a negative number) and the maximum. Then just keep multiplying for each index. 

Code: [Maximum Contiguous Product](./[Array]MaxProductContiguous.java)


---

Question 15

*Find minimum difference between 2 subarray*

Solution: The idea to first get the sum of the entire array. Then you slowly increment `first` which will be the sum from i = 0 to i = x. Then use the sum to minus first and get the second section. Now you can just compare and get the minimum difference.

Code: [Maximum Contiguous Product](./[Array]FindMinAbsDifBetween2Parts.java)


---

Question 16

*Get product of all values except itself*

Solution: This question have to be solved without division. First, you will do one pass forward to get the product of all numbers to its left. Thus arr[i] will contain all the products before it. You will start the loop with i = 1. Now, you will do a backwards pass, and this pass will compute all the product to the right of itself. In the same section, you can make it faster by multiplying by the first array to get the answer.

Code: [Product Except Itself](./[Array]ProductExceptItself.java)


---

Question 17

*Given an unsorted array of integers. Find an element such that all the elements to its left are smaller and to its right are greater*

Solution: The solution invovles 2 pass. The forward pass, keeps track of the largest number until this point i. Meaning it either use the previous value, or the current value, whichever is greater. Then we do the same for the backwards pass. Finally, you will go through each index and check is it greater than left and less than right.

Code: [Partition Left Right To Be Greater And Less Than](./[Array]PartitionAtGreaterAndLessThanLeftRight.java)


---


## Sorting

Common sorting methods
1. 1 forward pass and 1 backward pass using "quicksort". (Q1)
2. Make use of the sorted property of the array and use 2 pointers for each array, and slowly traverse doing computation. (Q2)
3. Fill up the array from the back making use of the sorted property.
---

Question 1

*Dutch Flag problem - Sort them in-place so that objects of the same color are adjacent*

Solution: Have 2 pass of "quickSort". The first forward pass will sort everything less than 1. The second backwards pass will sort everything greater than 1.

Code: [Dutch Flag](./[Sorting]DutchFlag.java)

---

Question 2

*Intersection of an array*

Solution: Since the array is sorted, we can have a pointer for each of array, and increment it when one of it is smaller than the other. Else we add it to ans.

Code: [Intersection of Arrays](./[Sorting]IntersectionOfArray.java)

---

Question 3

*Merge 2 sorted array*

Solution: We take advantage of the sorted property by filling up the nums1 array from the back. Note that we will never overwrite an entry in the first array that has not already been processed. The reason is that even if every entry of the second array is larger than each element of the first array, all elements of the second array will fill up indices m to m + n - 1 inclusive, which does not conflict with entries stored in the first array.

Code: [Merge 2 sorted arrays](./[Sorting]Merge2SortedArray.java)

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

---

## Binary Tree

Common binary tree methods
1. When you see pre/post/in order traversal. Think of it as refer to the node itself. Thus, pre order means n l r while inorder means lnr. These are just various method of traversing the tree.
2. Other types of traversals are DFS and BFS. BFS using a queue, and DFS uses a stack.

---

Question 1

*Invert Binary Tree*

Solution: There are 2 approaches. Top down or bottom up. In the top down approach, you can perform the swap, and then continue. In the bottom up approach, you perform the recursion then do the assignment.

Code: [Invert Binary Tree](./[BinaryTree]InvertBinaryTree.java)

---

## Stack

Common stack methods
1. 

---

Question 1

*Matching Brackets*

Solution:  each right parenthesis must match the closest left parenthesis to its left. Therefore, starting from the left, every time we see a left parenthesis, we store it. Each time we see a right parenthesis, we match it with a stored left parenthesis.

Code: [Matching brackets](./[Stack]MatchingBrackets.java)

---


## String

Common String methods
1. If you need to do anagrams for strings, sort the string and store it in the hashmap. 
2. Replace and remove: replace all As with Ds and all delete all Bs. The idea is count the required space, which is array + 2As and delete all the Bs. This is done first by a forward iteration, Then we do a backwards iteration. Filling up the array backwards.
3. Reverse a string: The solution is to first, reverse the entire string. So now. What is messed up is that each word is individually reversed. However, each word has the correct length. So now you just have to reverse individual words.
---

Question 1

*Delete word if previous word is a anagram*

Solution: The important idea is the sort the string, and store it as a key in the hashset. This way, you can just do typical checking. 

Code: [Fun With Anagram](./[String]FunWithAnagram.java)

---
## Greedy

Common Greedy Method
1. A hallmark of a greedy algorithm is to select a particular value, and then it never change the selection.
2. Alot of it invovles sorting.

---

Question 1

*Design an algorithm that takes as input a set of tasks and returns an optimum assignment.*

Question: We want to assign tasks to workers so as to minimize how long it takes before all tasks are completed. For example, if there are 6 tasks whose durations are 5, 2, 1, 6, 4, 4 hours. Each worker must be assigned to 2 task.

Solution: This is a greedy solution where we sort the array. And pair the shortest with the longest,second shortest with the second longest, third shortest with the third longest etc. If the durations are 5, 2, 1, 6, 4, 4, then on sorting we get 1, 2, 4, 4, 5, 6, and the pairings are (1,6), (2,5), and (4,4).

---

Question 2 

*Minimize wait time by reordering task and performing one at a time*

Solution: if the service times are (2,5,1,3), if we schedule in the given order, the total waiting time is0+(2)+(2+5)+(2+5+l) = 17. We notice that, 2 is repeated for all of the entries. Thus, it makes intuitive sense to sort it and have the smallest one first.

Code: [Minimize wait time](./[Greedy]MinimizeWaitTime.java)

---

Question 3

*Interval covering problem*

Question: You are given a set of intervals. Your job is to help him minimize the number of visits he makes. In each visit, he can check on all the tasks taking place at the time of the visit. 

Solution: Sort it by end time. Pick the first end time and compare it against the rest. If the start time is before the endtime, we proceed. It means that the choosen endtime will cover it. This is because, it is sorted by end time, thus, the second endtime will definitely be after the current endtime. Thus, if the second start time is later than the current end time, it will be within the interval. e.g. [1,3], [2,4]. 4 will definitely be behind 3. If the second start time 2, is less than the current end time, it means it will happen to until at least end of current end time. 

For the given example, [1,2],[2,3],[3,4],[2,3],[3,4],[4,5], after sorting on right endpoints we get [1,2],[2,3],[2,3],[3,4],[3,4],[4,5], The leftmost right endpoint is 2, which covers the first three intervals. Therefore, we select 2, and as we iterate, we see it covers [1,2],[2,3],[2,3], When we get to [3,4], we select its right endpoint, i.e., 4. This covers [3, 4], [3, 4], [4, 5]. There are no remaining intervals, so (2, 4] is a minimum set of points covering all intervals.

Question 4

*Majority of element*

Solution:The idea is based on the fact that it will always be half + 1 more than any other element. So you solution is to take the first index element, check if it is the same as the next. If it is, increment count. Else minus. If it hits 0, take this element as the new element. You are slowly taking out non-matching pairs, and what is left, will be the last element which is the majority.

Code: [Majority of Element](./[Greedy]FindMajorityOfElement.js)

---

Question 5

*Gas station*

Solution: First, we assume that a answer always exist. We choose starting point 0. If at any point, it reaches below zero, say point x. It means you cannot reach point x from that starting point to x. Why? Imagine, at instead of point 0, you say start with point k which is between 0 and x. Can it reach x? Maybe. However, as it loops back to 0, and want to go to k. Based on the previous part, it means that from 0 to k we used alot of fuel. So, it will not be able to reach k based on that assumption. Thus, the solution is to take the next point.

Code: [Gas Station](./[Greedy]GasStation.java)

---

**Solving interval questions**
1. *Question on number of concurrent events running* Sort the arrays by both the starting and ending point. Then, if it is starting, you will add to count. If it is a ending, you can minus. This will give you the number of concurrent events running.
2. (*Merge intervals*) Sort the array by start time, if the next start time is within the current end time, it overlaps. 
3. (*Remove overlap*) Sort the array and use the earliest end time greedily to fit the most number of interval. The interval with early start might be very long and incompatible with many intervals. But if we choose the interval that ends early, we'll have more space left to accommodate more intervals. Hope it helps.

**Counting Method**

This method involves storing the the value of the first array as an index for a new array.

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

1) The only way to get a lower average is to encounter a number less than the current average
2) Maximum slice of smallest slice is either 2 or 3.

## Database Design

*One to many relationship*

To establish a one-to-many relationship, the primary key of table A (the "one" table) must be the foreign key of table B (the "many" table).

Example: A `teacher` can have many `classes`
teachers: teacher_id, first_name, last_name # the "one" side
classes:  class_id, class_name, teacher_id  # the "many" side will use the teacher_id as the foreign key.

*Many to many relationship*

To establish a many-to-many relationship, create a third/junction table which will have the primary keys of both tables.

Example: A `student` can have many `classes`, and a `class` can have many teachers.
student: student_id, first_name, last_name
classes: class_id, name, teacher_id
student_classes: class_id, student_id     # the junction table will consist of both the primary key of the table.

## Database

*Indexes*

Indexes are special lookup tables that the database search engine can use to speed up data retrieval. Simply put, an index is a pointer to data in a table. An index helps to speed up SELECT queries and WHERE clauses, but it slows down data input, with the UPDATE and the INSERT statements.

An index can be used to efficiently find all rows matching some column in your query and then walk through only that subset of the table to find exact matches. If you don't have indexes on any column in the WHERE clause, the SQL server has to walk through the whole table and check every row to see if it matches, which may be a slow operation on big tables.

## Software engineering 

*Singleton Pattern*

`Require` helps you with this. It does not matter how many times you will require this module in your application; it will only exist as a single instance.

*Controllers*

Controller is part of the MVC model. Controllers are functions to get the requested data from the model. 

*Interface Segregation Principle*

Do not force the class/function to implement unused things. 

*Open-Closed Principle*

If I have to open the JS file your module and make a modification in order to extend it, you’ve failed the open closed principle.

## Deployment

*Continuous integration*

Whenever you push a change to git server, it notifies the CI server, it will take the docker file and combine with your code and create a new image. And automatically deploy to the server itself. Thus, saving time and effort to actually upload the file onto the server.

*Scaling*

Use CDN. Content delivery network helps to reduce server load, by caching static images, so you don't have to hit the server directly. Secondly, it helps to filter malicious traffic. Notice those, `I am not a robot` caption. This is a service offered by cloudflare or CDN providers. This helps to prevent DDOS attack as afterall detecting such things are not a simple task. 

Next, instead of having a server with everything install. E.g. Node.mysql etc. You split it up each to have its own server. You use things like amazon RDS and ECS which will automatically scale for you when necessary. This is after the load balancer passes you all the legitimate requests.



