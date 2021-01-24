function solution(input) {
    const car = {};
    const engines = [
        { power: 90, volume: 1800 },
        { power: 120, volume: 2400 },
        { power: 200, volume: 3500 }
    ]

    car.model = input.model;
    car.engine = setEngine(input.power);
    car.carriage = setCarriage(input);
    car.wheels = setWheels(input.wheelsize);

    function setEngine(input) {
        return engines.find(e => e.power >= input);
    }

    function setCarriage(input) {
        return {
            type: input.carriage,
            color: input.color
        }
    }

    function setWheels(input) {
        return input % 2 == 0 ?
            Array(4).fill(input - 1) :
            Array(4).fill(input);
    }

    return car;
}

console.log(solution(
    {
        model: 'VW Golf II',
        power: 90,
        color: 'blue',
        carriage: 'hatchback',
        wheelsize: 14
    }
));

console.log('-'.repeat(50));

console.log(solution(
    {
        model: 'Opel Vectra',
        power: 110,
        color: 'grey',
        carriage: 'coupe',
        wheelsize: 17
    }

));