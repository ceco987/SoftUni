function solution(arr){
    let result=[];
    for (let i = 1; i < arr.length; i+=2) {
        result[result.length]=arr[i];
    }
    return result.map((x)=>x*2).reverse().join(' ');
}

console.log(solution([10, 15, 20, 25]));
console.log(solution([3, 0, 10, 4, 7, 3]));