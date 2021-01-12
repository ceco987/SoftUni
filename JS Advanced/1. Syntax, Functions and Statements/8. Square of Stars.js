function square (a=5){
    let result='';
    for (let i = 0; i < a; i++) {
        result+='* ';
    }
    for (let i = 0; i < a; i++) {
        console.log(result);
    }
}

square(6);