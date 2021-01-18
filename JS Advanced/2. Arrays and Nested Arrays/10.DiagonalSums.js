function solution(arr) {
    let mainDiag = 0;
    let secDiag = 0;
    for (let i = 0; i < arr.length; i++) {
        mainDiag += arr[i][i];
        secDiag += arr[i][arr.length - i - 1];
    }
    return mainDiag+' '+secDiag;
}

console.log(solution([
    [20, 40],
    [10, 60]]
));

console.log(solution([
    [3, 5, 17],
    [-1, 7, 14],
    [1, -8, 89]]
));