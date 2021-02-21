function solve(arr) {
    const shop = new Map();
    let bottles = {};
    let output = [];
    for (let pair of arr) {
        let [juice, quantity] = pair.split(' => ');
        if (!shop.has(juice)) {
            shop.set(juice, Number(quantity))
        } else if(shop.get(juice)<1000) shop.set(juice,shop.get(juice)+Number(quantity))
        if (shop.get(juice) >= 1000) {
            let consumed = Math.floor(shop.get(juice)/1000)
            if (bottles[juice]) bottles[juice]+=consumed;
            else bottles[juice] = consumed;
            shop.set(juice, shop.get(juice) - consumed*1000)
        }
    }

    for (let [juice, quantity] of Object.entries(bottles)) {
        output.push(`${juice} => ${quantity}`)
    }

    return output.join('\n');
}

console.log(solve([
    'Kiwi => 234',
    'Pear => 2345',
    'Watermelon => 3456',
    'Kiwi => 4567',
    'Pear => 5678',
    'Watermelon => 6789']

))