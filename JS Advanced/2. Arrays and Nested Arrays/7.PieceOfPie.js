function solution(arr, tgt1, tgt2){
    let result = [];
    return result=arr.slice(arr.indexOf(tgt1),arr.indexOf(tgt2)+1);
}

console.log(solution(['Pumpkin Pie',
'Key Lime Pie',
'Cherry Pie',
'Lemon Meringue Pie',
'Sugar Cream Pie'],
'Key Lime Pie',
'Lemon Meringue Pie'
))

console.log(solution(['Apple Crisp',
'Mississippi Mud Pie',
'Pot Pie',
'Steak and Cheese Pie',
'Butter Chicken Pie',
'Smoked Fish Pie'],
'Pot Pie',
'Smoked Fish Pie'
))