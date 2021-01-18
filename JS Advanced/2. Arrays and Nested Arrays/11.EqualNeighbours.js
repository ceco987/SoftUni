function solution(arr) {
    let count = 0;
    lastRow = arr[arr.length-1];
    for (let i = 0; i < arr.length-1; i++) {
        for (let j = 0; j < arr[i].length; j++) {
            if (arr[i][j]==arr[i + 1][j]||arr[i][j]==arr[i][j+1]) {
                count++;
            }
        }
    }
    for (let i = 0; i < lastRow.length-1; i++) {
        if(lastRow[i]==lastRow[i+1]){
            count++;
        }
    }
    return count;
}

// console.log(solution([
//     ['2', '3', '4', '7', '0'],
//     ['4', '0', '5', '3', '4'],
//     ['2', '3', '5', '4', '2'],
//     ['9', '8', '7', '5', '4']]
// ));
// console.log(solution([
//     ['test', 'yes', 'yo', 'ho'],
//     ['well', 'done', 'yo', '6'],
//     ['not', 'done', 'yet', '5']]
// ));

console.log(solution([
    [2,2,5,7,4],
    [4,0,5,3,4],
    [2,5,5,4,2]
]));