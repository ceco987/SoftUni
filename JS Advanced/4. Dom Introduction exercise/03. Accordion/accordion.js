function toggle() {
    let hiddenText = document.getElementById("extra");
    let button = document.querySelector("span");
    let buttonContent = button.textContent;
    const conditionObj ={
        "More": function (){
            hiddenText.style.display='block';
            button.textContent='Less'
        },
        "Less": function(){
            hiddenText.style.display='none';
            button.textContent='More';
        }
    }
    conditionObj[buttonContent]();
}