const solution = nums => {
    let result = [];
    let count=0;
    nums.sort((a,b)=>a-b);
    while(nums.length>0) {
        if(count++%2==0){
            result.push(nums.shift());
        }   else {
            result.push(nums.pop())
        }     
    }
    return result;
}

console.log(solution([1, 65, 3, 52, 48, 63, 31, -3, 18, 56]));