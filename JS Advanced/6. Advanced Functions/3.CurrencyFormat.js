function currencyFormatter(separator, symbol, symbolFirst, value) {
    let result = Math.trunc(value) + separator;
    result += value.toFixed(2).substr(-2, 2);
    if (symbolFirst) return symbol + ' ' + result;
    else return result + ' ' + symbol;
}

function createFormatter (separator, symbol, symbolFirst, currencyFormatter){
    let formatter = function(value){
        return currencyFormatter(separator, symbol, symbolFirst, value);
    }
    return formatter;
}

let test = createFormatter(',','$','true',currencyFormatter);
console.log(test(5.486));
console.log(test(2));
console.log(test(4));
console.log(test(983.248698654));
console.log(test(4.23142));
console.log(test(5.1234));