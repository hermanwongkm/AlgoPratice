//Reorder the string given the number in its string.
//e.g. thi1s i1s a4 sentenc2e.
//Note that instead of using a hashmap, I can insert it directly into the array itself. 

'use strict';

const fs = require('fs');

process.stdin.resume();
process.stdin.setEncoding('utf-8');

let inputString = '';
let currentLine = 0;

process.stdin.on('data', function(inputStdin) {
    inputString += inputStdin;
});

process.stdin.on('end', function() {
    inputString = inputString.split('\n');

    main();
});

function readLine() {
    return inputString[currentLine++];
}

/*
 * Complete the 'reorderSentence' function below.
 *
 * The function is expected to return a STRING.
 * The function accepts STRING input as parameter.
 */

function reorderSentence(input) {
    //Assume it started with 0
    //assume that it is strictly increasing by 1 each time
    //no dup
    // always by spaces
    
    /**
     *  String[] strArrary = input.splt(" ");
     *  HashMap<Integer, String> map = new HashMap();
     *  String[] answer = new String[strArray.length];
     *  //looping through the words
     *  for(int i = 0;  i < strArray.length; i++){
     *      String word = strArray[i];
     * //looping through each inidivudal word
     *      for(int j = 0; j < word.length; j++){
     *          if(word.charAt(j).isDigit()){ 
     *              String count = "";
     *              while(word.charAt(j).isDigit()){
     *                  count = count + word.charAt(j);
     *              }
     *              
     *              map.put(count.ToInteger(), word));
     *              break;
     *          }
     *      }
     * }
     * for(MapElement: map.entrySet()){
     *      answer[mapElement.getKey() - 1] = mapElement.getValue();    
     * }
     * return answer.join(" ");
     */
}

/**
 * HERE
 * 1. loop through the list for each string
 *     1.1 loop through the string to find the position
 *          1.2 Store number as key and value as the string in the hashmap
 * 
 * since i know the size of list, i can create a array of size 5
 * loop thorugh the hashmap, using the key i will insert it into the array
 * []
 */

function main() {
    const ws = fs.createWriteStream(process.env.OUTPUT_PATH);

    const input = readLine();

    const result = reorderSentence(input);

    ws.write(result + '\n');

    ws.end();
}
