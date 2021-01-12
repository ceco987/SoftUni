function calculateWalkTime(steps,footprint,speedKMH){
    let speedMPS = speedKMH*1000/3600;
    let distance = steps*footprint;
    let rest = Math.floor(distance/500)*60;
    let time = distance / speedMPS + rest;
    let hours = Math.floor(time/3600).toFixed(0).padStart(2,"0");
    let minutes = Math.floor(time/60).toFixed(0).padStart(2,"0");
    let seconds = (time%60).toFixed(0).padStart(2,"0");
    return `${hours}:${minutes}:${seconds}`
}

console.log(calculateWalkTime(4000, 0.60, 5))
console.log(calculateWalkTime(2564, 0.70, 5.5))