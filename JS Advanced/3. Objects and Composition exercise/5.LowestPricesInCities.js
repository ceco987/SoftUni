function createSortedList(input){
    let log = {};

    while(input.length){
        let group = input.shift();
        let [town,product,price] = group.split(' | ');

        if(!log[product]){                                      //correct
            log[product] = {town,price:Number(price)};          //correct
        } else if (log[product].town==town&&log[produt].price>price){
            log[product] = {town,price:Number(price)};
        } else{
            if(log[product].price>Number(price)){
                log[product] = {town,price:Number(price)};
            }
        }
    }

    let result = [];
    for(let product in log){
        result.push(`${product} -> ${log[product].price} (${log[product].town})` )
    }
    return result.join('\n');
}

console.log(createSortedList(
    ['Sample Town | Sample Product | 1000',
        'Sample Town | Orange | 2',
        'Sample Town | Peach | 1',
        'Sofia | Orange | 3',
        'Sofia | Peach | 2',
        'New York | Sample Product | 1000.1',
        'New York | Burger | 10']
));