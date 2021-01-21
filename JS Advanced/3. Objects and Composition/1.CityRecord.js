function solution(name, population, treasury) {
    const city = {};
    city.name = name;
    city.population = population;
    city.treasury = treasury;
    return city;
}

console.log(solution(
    'Tortuga',
    7000,
    15000
))
console.log('-'.repeat(25));
console.log(solution(
    'Santo Domingo',
    12000,
    23500
))