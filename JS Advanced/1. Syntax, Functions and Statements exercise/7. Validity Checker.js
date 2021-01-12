function solve (x1, y1, x2, y2){
    return `{${x1}, ${y1}} to {0, 0} ${checkIfValid(x1,y1,0,0)}\n{${x2}, ${y2}} to {0, 0} ${checkIfValid(x2,y2,0,0)}\n{${x1}, ${y1}} to {${x2}, ${y2}} ${checkIfValid(x1,y1,x2,y2)}`

    function checkIfValid(x1,y1,x2,y2){
        let hypotenuse = Math.sqrt((x1-x2)**2+(y1-y2)**2);
        let difference = hypotenuse - Math.floor(hypotenuse)
        if(difference==0) return 'is valid';
        else return 'is invalid';
    }
}

console.log(solve(3,0,0,4))
console.log(solve(2,1,1,1))