function calculator() {
    let firstEl, secondEl, result;
    return {
        init: function (selector1, selector2, resultSelector){
            firstEl=document.querySelector(selector1);
            secondEl=document.querySelector(selector2);
            result=document.querySelector(resultSelector);
        },
        add: function (){
            result.value = Number(firstEl.value)+Number(secondEl.value);
        },
        subtract: function(){
            result.value = Number(firstEl.value)-Number(secondEl.value);
        }
    }
}
let calculate = calculator();
calculate.init("#num1","#num2","#result");