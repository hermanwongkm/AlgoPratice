/**
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * @param {string} digits
 * @return {string[]}
 */
const MAPPING = ["0", "1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"];
var letterCombinations = function(digits) {
    let partialAns = "";
    let ans = [];
    recursiveSolver(digits,0,partialAns,ans);
    return ans;  
};

const recursiveSolver = (digits, index, partialAns, ans) =>{
    if(digits.length === 0){
        return;
    }
    if(index === digits.length){
        //it means i reached the end of the phone number so i can add to ans
        ans.push(partialAns);
    }
    else{
        for(let i = 0; i < MAPPING[digits.charAt(index)].length; i++){
            let c = MAPPING[digits.charAt(index)][i];
            partialAns = partialAns + c;
            recursiveSolver(digits,index + 1, partialAns,ans);
            partialAns = partialAns.substring(0, partialAns.length -1); //remove last charcter 
        }    
    }
    return ans;
}
