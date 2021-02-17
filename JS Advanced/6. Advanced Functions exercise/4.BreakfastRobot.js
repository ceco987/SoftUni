function solution() {
    const productLibrary = {
        apple: { carbohydrate: 1, flavour: 2 },
        lemonade: { carbohydrate: 10, flavour: 20 },
        burger: { carbohydrate: 5, flavour: 3, fat: 7 },
        eggs: { protein: 5, fat: 1, flavour: 1 },
        turkey: { protein: 10, carbohydrate: 10, fat: 10, flavour: 10 }
    }

    let ingredients = {
        protein: 0,
        carbohydrate: 0,
        fat: 0,
        flavour: 0
    }

    return function manager(input) {
        let [par1, par2, par3] = input.split(' ');
        par3 = Number(par3);
        let message = '';

        let commands = {
            restock: function (microelement, quantity) {
                ingredients[microelement] += quantity;
                message = 'Success';
            },

            prepare: function (recipe, quantity) {
                let neededIngredients = Object.entries(productLibrary[recipe]);
                let checkEl = Array.from(neededIngredients).find(e => ingredients[e[0]] < e[1] * quantity);

                if (!checkEl) {
                    for (let [element, q] of neededIngredients) {
                        ingredients[element] -= q * quantity;
                    }
                    message = 'Success';

                } else {
                    message = `Error: not enough ${checkEl[0]} in stock`;
                }
            },

            report: function () {
                for (let [ingr, quant] of Object.entries(ingredients)) {
                    message += `${ingr}=${quant} `
                }
                message = message.trim();
            }
        }

        commands[par1](par2, par3);
        return message;
    }

}

//example 1
// let manager = solution();
// console.log(manager('restock flavour 50'));
// console.log(manager('prepare lemonade 4'));
// console.log(manager('restock carbohydrates 10'));
// console.log(manager('restock flavour 10'));
// console.log(manager('prepare apple 1'));
// console.log(manager('restock fat 10'));
// console.log(manager('prepare burger 1'));
// console.log(manager('report'));

//example 2
// let manager = solution();
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock protein 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock carbohydrates 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock fat 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('restock flavour 10'));
// console.log(manager('prepare turkey 1'));
// console.log(manager('report'));

//example 3
// let manager = solution();
// console.log(manager('restock protein 100'));
// console.log(manager('restock carbohydrate 100'));
// console.log(manager('restock fat 100'));
// console.log(manager('restock flavour 100'));
// console.log(manager('report'));
// console.log(manager('prepare eggs 2'));
// console.log(manager('report'));
// console.log(manager('prepare eggs 1'));
// console.log(manager('report'));