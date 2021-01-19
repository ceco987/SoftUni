function solution(arr, num){
    let rotations = num%arr.length;
    while(rotations-->0){
        arr.unshift(arr.pop());
    }
    return arr.join(' ');
}

console.log(solution(['1', 
'2', 
'3', 
'4'], 
2
));
console.log('---------')
console.log(solution(['Banana', 
'Orange', 
'Coconut', 
'Apple'], 
15
));