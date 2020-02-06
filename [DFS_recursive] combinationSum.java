/**
Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

The same repeated number may be chosen from candidates unlimited number of times.

Note:

    All numbers (including target) will be positive integers.
    The solution set must not contain duplicate combinations.

**/

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> finalAnswer = new  ArrayList<>();
        backtrack(finalAnswer, candidates, 0, new ArrayList<>(), target);
        return finalAnswer;
        
    }
    
    public void backtrack(List<List<Integer>> finalAnswer, int[] candidates, int start, List<Integer> answer, int remainder){
        //If last than 0 means this solution set is invalid and will not be added
        if(remainder < 0){
            return;
        }
        //If equals to zero, it means this solution set is valid and can be added
        else if (remainder == 0){
            finalAnswer.add(new ArrayList<>(answer));
        }
        else{
            for(int i = start; i < candidates.length; i++){ //Note it is i = start not 0, because you dont want to repeat numbers you have visited 
                //this is like DFS, you will try the same value until it hits 0 or less than 0. 
                //For every try, you will add it to the temp answer array
                answer.add(candidates[i]);
                backtrack(finalAnswer, candidates, i, answer, remainder - candidates[i]);
                //When you reach here, means the recursion have ended and you have already validated it so you can remove it out of the array
                answer.remove(answer.size() -1); //remove the last element 
            }
        }
    }
}
