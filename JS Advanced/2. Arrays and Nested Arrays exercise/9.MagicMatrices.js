const solution = mat =>{
    let firstSum = mat[0].reduce((acc,curr)=>acc+curr);
    for (let i = 0; i < mat.length; i++) {
        let sum = 0;
        for (let j = 0; j < mat[i].length; j++) {
            sum+=mat[j][i];
        }     
        if(sum!=firstSum) return false;
        if(i==0) continue;
        sum = mat[i].reduce((acc,curr)=>acc+curr);
        if(sum!=firstSum) return false;
    }
    return true;
}

console.log(solution([[1, 0, 0],
    [0, 0, 1],
    [0, 1, 0]]     
   ))