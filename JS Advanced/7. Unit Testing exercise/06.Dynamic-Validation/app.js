function validate() {
    const input = document.querySelector('input');
    const pattern = /^[a-z]+@[a-z]+\.[a-z]+$/;
    
    input.addEventListener('change',(ev)=>{
        if(!pattern.test(input.value)){
            input.classList.add('error');
        } else{
            input.classList.remove('error');
        }
    })
}