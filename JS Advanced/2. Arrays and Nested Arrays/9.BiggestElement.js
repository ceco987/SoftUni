function solution(arr) {
    let max = Number.MIN_VALUE;
    let tempMax = 0;
    for (let row of arr) {
        temp = Math.max(...row);
        if (max < temp) {
            max = temp;
        }
    }
    return max;
}

console.log(solution([
    [20, 50, 10],
    [8, 33, 145]]
))

console.log(solution([
    [3, 5, 7, 12],
    [-1, 4, 33, 2],
    [8, 3, 0, 4]]
))