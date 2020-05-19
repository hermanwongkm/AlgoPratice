const search = (nums) =>{
  let start = 0;
  let end = nums.length - 1;
  while(start < end){
    let mid = start + (end-start)/2;
    let diff = nums[mid] - mid;
    if(diff === 0){
      return mid; //You found a value where entry equals its index
    }
    else if(diff > 0){
      //Means the value is greater than its index, then no entry after this can satisfy the condition so throw right
      //This is because each element in the array is at least 1 greater than the previous element.
      end = mid -1;
    }
    else{ //If the value is less than its index, than no value before it can satisfy the condition too
      start = mid -1;
   }
   return -1;
}
