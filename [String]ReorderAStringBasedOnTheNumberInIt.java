//Reorder the string given the number in its string.
//e.g. thi1s i1s a4 sentenc2e.
//Note that instead of using a hashmap, I can insert it directly into the array itself. 


function reorderSentence(input) {
    //Assume it started with 0
    //assume that it is strictly increasing by 1 each time
    //no dup
    // always by spaces
    
    
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
    
}
