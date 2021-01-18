function solution(n,k) {
    let arr = [1];
    for (let i = 0; i <=n; i++) {
        arr.length = arr.slice(i-k,i).reduce((acc,c)=>acc+c)
    }
    return arr
}


console.log(solution(6, 3));
console.log(solution(8, 2));