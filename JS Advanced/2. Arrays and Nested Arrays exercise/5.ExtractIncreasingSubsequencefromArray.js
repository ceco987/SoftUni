//Not perfect but can't be bothered
function solution(arr) {
    let result = [arr[0]];
    arr.reduce((acc, num, i, array) => {
        if (num >= result[result.length-1]) {
            result.push(num);
        }
    });
    return result;
}


console.log(solution([1,
    3,
    8,
    4,
    10,
    12,
    3,
    2,
    24]
));
console.log('----------');
console.log(solution([1,
    2,
    3,
    4]
    ));
console.log('----------');
console.log(solution([20,
    3,
    2,
    15,
    6,
    1]
));