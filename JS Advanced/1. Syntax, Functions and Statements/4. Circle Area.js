function findCircleArea(r){
    let result;
    let inputType = typeof(r);
    if(inputType=='number') {result = r**2*Math.PI;
    console.log(result.toFixed(2));
    } else console.log(`We can not calculate the circle area, because we receive a ${inputType}.`);
}

findCircleArea('domat');