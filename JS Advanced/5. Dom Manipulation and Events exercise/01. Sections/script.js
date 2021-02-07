function create(words) {
    const div = document.getElementById('content');
    
    for (let i = 0; i < words.length; i++) {
        const innerDiv = document.createElement('div');
        const innerP = document.createElement('p')
        innerP.textContent=words[i];
        innerP.style.display = 'none';
        innerDiv.appendChild(innerP);

        innerDiv.addEventListener('click',(ev)=>ev.target.firstElementChild.style.display='')
        
        div.appendChild(innerDiv);
    }
}