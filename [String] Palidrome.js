
var isPalindrome = function(s) {
    let noSpaceString = s.replace(/\W/g, ""); // /W means find a non word character
    let reversedString = noSpaceString.split("").reverse().join("");
    console.log(reversedString);
    console.log(noSpaceString);
    return reversedString.toLowerCase() == noSpaceString.toLowerCase();
};
