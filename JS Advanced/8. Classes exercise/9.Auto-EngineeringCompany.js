function solution(arr) {
    let result =  arr.map(e=>e.split(' | '))
    .reduce((acc,c)=>{
        let [brand,model,quantity] = c;
        quantity = Number(quantity);
        if(!acc[brand]){
            acc[brand]={};
        }
        if(!acc[brand][model]){
            acc[brand][model]=0;
        }
        acc[brand][model]+=quantity;
        return acc;
    },{})
    let output = [];
    Object.entries(result).map(([car,models])=>{
        output.push(car);
        Object.entries(models).map(([model,quantity])=>{
            output.push(`###${model} -> ${quantity}`)
        })
    })
    return output.join('\n');
}

console.log(solution([
    'Audi | Q7 | 1000',
    'Audi | Q6 | 100',
    'BMW | X5 | 1000',
    'BMW | X6 | 100',
    'Citroen | C4 | 123',
    'Volga | GAZ-24 | 1000000',
    'Lada | Niva | 1000000',
    'Lada | Jigula | 1000000',
    'Citroen | C4 | 22',
    'Citroen | C5 | 10']
))