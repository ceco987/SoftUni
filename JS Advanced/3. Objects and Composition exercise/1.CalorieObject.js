function solution(arr){
    const result = {};
    arr.forEach((el,i,arr) => {
        if(i%2==0){
            result[el]=Number(arr[i+1]);
        }
    });

    return result;
}

console.log(solution(['Yoghurt', '48', 'Rise', '138', 'Apple', '52']));