function solution(arr){
    let result = [];
    return Number(arr.pop())+Number(arr.shift());
}

console.log(solution(['20', '30', '40']))
console.log(solution(['5','10']))
