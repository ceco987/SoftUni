function result (a){
    let arrayInput = Array.from(String(a),Number)
    let same = true;
    let el = arrayInput[0];
    let sum = el;
    for (let i = 1; i < arrayInput.length; i++) {
        if(el!=arrayInput[i]) {
            same=false;
        }
        el = arrayInput[i];
        sum+=el;
    }
    console.log(same)
    console.log(sum)
}

result(2222)