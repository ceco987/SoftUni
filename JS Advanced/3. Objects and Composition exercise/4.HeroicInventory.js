function solution(arr) {
    let result = [];
    for (let e of arr) {
        let [name, level, itemsUnspl] = e.split(' / ');
        level = Number(level);
        let items = itemsUnspl ? itemsUnspl.split(', ') : [];
        result.push({ name, level, items });
    }

    return JSON.stringify(result);
}

console.log(solution(
    [
        'Isacc / 25 / Apple, GravityGun',
        'Derek / 12 / BarrelVest, DestructionSword',
        'Hes / 1 / Desolator, Sentinel, Antara']
));

console.log('*'.repeat(50));

console.log(solution(
    ['Jake / 1000 / Gauss, HolidayGrenade']
));