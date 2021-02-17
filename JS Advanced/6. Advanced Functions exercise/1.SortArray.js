function solution(arr, sort) {
    let comparator = {
        asc: (a, b) => a - b,
        desc: (a, b) => b - a
    }

    return arr.sort(comparator[sort]);
}

console.log(solution([14, 7, 17, 6, 8], 'asc'));
console.log(solution([14, 7, 17, 6, 8], 'desc'));