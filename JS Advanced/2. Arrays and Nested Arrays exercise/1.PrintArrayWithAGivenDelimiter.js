function solution(arr, delimiter){
    return arr.join(delimiter);
}

console.log(solution(['One', 
'Two', 
'Three', 
'Four', 
'Five'], 
'-'
));

console.log(solution(['How about no?', 
'I',
'will', 
'not', 
'do', 
'it!'], 
'_'
));