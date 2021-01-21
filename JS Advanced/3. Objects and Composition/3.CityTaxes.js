function solution(name, population, treasury) {
    const city = {};
    city.name = name;
    city.population = population;
    city.treasury = treasury;
    city.taxRate = 10;

    city.collectTaxes = function collectTaxes(){
        city.treasury+=city.population*city.taxRate;
    }

    city.applyGrowth = function applyGrowth(percentage){
        city.population+=Math.floor(city.population*percentage/100);
    }

    city.applyRecession = function applyRecession(percentage) {
        city.treasury-=Math.ceil(city.treasury*percentage/100);
    }
    return city;
}

console.log(solution('Tortuga',7000,15000))