function solve (product, weight, price){
    weight/=1000;
    console.log(`I need $${(weight*price).toFixed(2)} to buy ${weight.toFixed(2)} kilograms ${product}.`)
}

solve('apple', 1563, 2.35)