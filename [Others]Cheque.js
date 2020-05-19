/*
Convert number to words
 123456
  Output: one hundred twenty three thousand four hundred fifty six

  0 to 999 999 ONLY
*/

const convert = input => {
  var ones = [
    "",
    "one",
    "two",
    "three",
    "four",
    "five",
    "six",
    "seven",
    "eight",
    "nine",
    "ten",
    "eleven",
    "twelve",
    "thirdteen",
    "fourteen",
    "fifthteen",
    "sixteen",
    "seventeen",
    "eighteen",
    "nineteen"
  ];

  var tens = [
    "",
    "",
    "twenty",
    "thirty",
    "fourty",
    "fifty",
    "sixty",
    "seventy",
    "eighty",
    "ninety"
  ];

  if (input < 20) {
    return ones[input];
  }
  //2 digits
  if (input < 100) {
    return (
      tens[Math.floor(input / 10)] +
      (input % 10 !== 0 ? " " : "") +
      ones[input % 10]
    );
  }
  //3 digits
  if (input < 1000) {
    return ones[Math.floor(input / 100)] + " Hundred " + convert(input % 100);
  }
  //4 & 5 digit
  if (input < 100000) {
    return (
      convert(Math.floor(input / 1000)) + " Thousand " + convert(input % 1000)
    );
  }

  if (input < 1000000) {
    return (
      convert(Math.floor(input / 100000)) +
      " Hundred " +
      convert(input % 100000)
    );
  }
};

var original = 999999;
console.log(convert(original));
