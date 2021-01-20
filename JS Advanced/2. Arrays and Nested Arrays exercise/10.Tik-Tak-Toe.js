function solution(arr){
    let dashboard = [[],[],[]];
    dashboard.fill([false,false,false]);
    for (let i = 0; i < arr.length; i++) {
        
    }
    return dashboard.map(x=>x.join("\t")).join("\n");
}

console.log(solution([1,2,3]))