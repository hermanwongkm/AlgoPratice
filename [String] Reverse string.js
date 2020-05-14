/**
Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

Example 1:

Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"

 * @param {string} s
 * @return {string}
 */
var reverseWords = function(s) {
    let splitArray = s.split(" ");
    for(let i = 0; i < splitArray.length; i++){
        splitArray[i] = splitArray[i].split("").reverse().join("");
    }
    return splitArray.join(" ");
};
