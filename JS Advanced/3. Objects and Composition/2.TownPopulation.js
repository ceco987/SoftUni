function solution(arr) {
    const cityRegistry = {};
    let result = [];
    for (let i = 0; i < arr.length; i++) {
        let temp = arr[i].split(' <-> ');
        if(cityRegistry[temp[0]]!=undefined) {
            cityRegistry[temp[0]] += Number(temp[1]);
        }
        else cityRegistry[temp[0]] = Number(temp[1]);
    }

    for (let [key,value] of Object.entries(cityRegistry)) {
        result.push(key+' : '+value);
    }
    return result.join('\n');
}

console.log(solution(['Istanbul <-> 100000',
'Honk Kong <-> 2100004',
'Jerusalem <-> 2352344',
'Mexico City <-> 23401925',
'Istanbul <-> 1000']
));