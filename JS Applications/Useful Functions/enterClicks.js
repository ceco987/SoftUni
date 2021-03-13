function click(inputField,button){
    inputField.addEventListener('keyup',(ev)=>{
        if(ev.key=='Enter') button.click();
    })
}