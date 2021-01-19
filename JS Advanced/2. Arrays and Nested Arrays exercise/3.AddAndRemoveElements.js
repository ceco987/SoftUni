function solution(arr){
    let num = 1;
    let result = [];
    arr.forEach(ele => {
        ele=='add' ? result.push(num) : result.pop(num);
        num++;
    });
    return result.length>0 ? result.join(`\n`) : 'Empty';
}

console.log(solution(['add', 
'add', 
'add', 
'add']
));
console.log('--------')
console.log(solution(['add', 
'add', 
'remove', 
'add', 
'add']
));
console.log('--------')
console.log(solution(['remove', 
'remove', 
'remove']
));