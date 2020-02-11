/**
Given a non-empty array of integers, return the k most frequent elements.

Example 1:

Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:

Input: nums = [1], k = 1
Output: [1]


**/

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //Use a hashMap to do counting
        HashMap<Integer, Integer> map = new HashMap();
        for(int x: nums){
            map.put(x, map.getOrDefault(x, 0)+1);
        }
        
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>((map1,map2) ->(map2.getValue() - map1.getValue()));
        //Map.entry is an entry in the map it is the type
        //if first > second, return positive. Sort in ascending order
        //So, we want to sort it in decending because most frequent first.
        //So i want the opposite so i use map2 minus map1. 
        
        for(Map.Entry<Integer,Integer> x: map.entrySet()){
            pq.add(x);
        }
        
        ArrayList<Integer> ans = new ArrayList();
        while(ans.size() < k){
            ans.add(pq.poll().getKey());
        }
        return ans;
    }
}
