function createSortedList(arr) {
    [h1, h2, h3] = arr.shift().split(/\s?\|\s?/).filter(x => x != "");
    let output = [];

    while (arr.length) {
        let [el1, el2, el3] = arr.shift().split(/\s?\|\s?/).filter(x => x != "");
        output.push({
            [h1]: el1,
            [h2]: Number(Number(el2).toFixed(2)),
            [h3]: Number(Number(el3).toFixed(2))
        })
    }
    return JSON.stringify(output);
}

console.log(createSortedList(
    ['| Town | Latitude | Longitude |',
        '| Sofia | 42.696552 | 23.32601 |',
        '| Beijing | 39.913818 | 116.363625 |']
)
);
console.log('-'.repeat(75));
console.log(createSortedList(
    ['| Town | Latitude | Longitude |',
        '| Veliko Turnovo | 43.0757 | 25.6172 |',
        '| Monatevideo | 34.50 | 56.11 |']
)
);
console.log('-'.repeat(75));
console.log(createSortedList(
    ['| Town | Latitude | Longitude |',
        '| Delhi |  28.38 | 77.12 |',
        '| Is it a real town? | 71.42 | -13.91 |']
)
);
console.log('-'.repeat(75));
console.log(createSortedList(
    ['| Town | Latitude | Longitude |',
        '| New York | 40.730610 | -73.935242 |',
        '| Must be fake | -22.13 | 68.17 |']
)
);
console.log('-'.repeat(75));
console.log(createSortedList(
    ['| Town | Latitude | Longitude |',
        '| Random Town | 0.00 | 0.00 |']
)
);