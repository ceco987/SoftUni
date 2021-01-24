function solution(input) {
    const result = [];
    let firstIteration = false;

    input.forEach(e => {
        let group = e.split(' | ');
        let [town, product, price] = group;
        price = Number(price);
        if (result.length == 0) {
            result.push({ [product] : {[town]: price } });
            firstIteration = true;
        } else firstIteration = false;
        if (!firstIteration) {
            result.forEach(obj => {
                if (obj[product] != undefined) {
                    [testTown] = Object.keys(obj[product]);
                    if (testTown == town && obj[product[town]] < price) {
                        obj[product[town]] = price;
                    } else if (obj[product[town]] > price) {
                        obj[product] = { town: price };
                    }
                } else result.push({ [product]: { [town]: price } });
            })
        }
    });
    return result;
}

console.log(solution(
    ['Sample Town | Sample Product | 1000',
        'Sample Town | Orange | 2',
        'Sample Town | Peach | 1',
        'Sofia | Orange | 3',
        'Sofia | Peach | 2',
        'New York | Sample Product | 1000.1',
        'New York | Burger | 10']
));