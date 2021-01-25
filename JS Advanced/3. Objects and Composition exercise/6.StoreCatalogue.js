function createSortedList(arr) {
    let catalogue = [];
    while (arr.length) {
        let group = arr.shift();
        let [name, price] = group.split(' : ');
        price = Number(price);
        catalogue.push({name,price});
    }
    catalogue.sort((a, b) => a.name.localeCompare(b.name));
    let result = [];
    let firstLetter = Object.values(catalogue[0])[0].charAt(0);
    let changeLetter = false;
    result.push(firstLetter.toUpperCase())

    for (let item of catalogue) {
        if (firstLetter != item.name.charAt(0)) {
            firstLetter = item.name.charAt(0);
            changeLetter = true;
        }
        if (changeLetter) {
            result.push(firstLetter.toUpperCase())
            changeLetter = false;
        }
        result.push(`  ${item.name}: ${item.price}`);
    }
    return result.join('\n');
}

console.log(createSortedList(
    ['Appricot : 20.4',
        'Fridge : 1500',
        'TV : 1499',
        'Deodorant : 10',
        'Boiler : 300',
        'Apple : 1.25',
        'Anti-Bug Spray : 15',
        'T-Shirt : 10']

))