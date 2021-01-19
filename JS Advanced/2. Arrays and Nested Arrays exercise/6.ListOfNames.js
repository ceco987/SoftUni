function solution(names) {
    let result = names.sort((a, b) => a.localeCompare(b)).map((el, i) => i+1+'.'+el)
    return result.join('\n');
}

console.log(solution(["John", "Bob", "Christina", "Ema"]));