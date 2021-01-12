function solve(speed,region){
    const motorwaySpeedLimit = 130;
    const interstateSpeedLimit = 90;
    const citySpeedLimit = 50;
    const residentialSpeedLimit = 20;

    let difference = 0;
    let speedLimit = 0;
    let status;

    switch(region){
        case 'city': 
            speedLimit = citySpeedLimit;
        break;

        case 'residential':
            speedLimit = residentialSpeedLimit;
        break;

        case 'interstate':
            speedLimit = interstateSpeedLimit;
        break;

        case 'motorway':
            speedLimit = motorwaySpeedLimit;
        break;
    }

    difference = speed-speedLimit;
    if(difference<=0){
        return `Driving ${speed} km/h in a ${speedLimit} zone`;
    } else {
        if(difference <=20) status = 'speeding';
        else if (difference <= 40) status = 'excessive speeding';
        else status = 'reckless driving';
        return `The speed is ${difference} km/h faster than the allowed speed of ${speedLimit} - ${status}`;
    }
}

console.log(solve(40, 'city'))
console.log(solve(21, 'residential'))
console.log(solve(120, 'interstate'))
console.log(solve(200, 'motorway'))