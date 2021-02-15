function solve (n){
    return function add (m){
        return n+m;
    }
}

let add5 = solve(7);
console.log(add5(2));
console.log(add5(3));