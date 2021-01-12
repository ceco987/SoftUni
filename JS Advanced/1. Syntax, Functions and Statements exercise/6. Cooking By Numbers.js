function solve (number, o1,o2,o3,o4,o5){
    const operations = [o1,o2,o3,o4,o5];
    number = Number(number);
    for (let i = 0; i < operations.length; i++) {
        switch(operations[i]){
            case 'chop': number /= 2; break;
            case 'dice': number = Math.sqrt(number); break;
            case 'spice': number++; break;
            case 'bake': number*=3; break;
            case 'fillet': number*=0.8; break; 
        }
        console.log(number);
    }
}


solve('9', 'dice', 'spice', 'chop', 'bake', 'fillet');