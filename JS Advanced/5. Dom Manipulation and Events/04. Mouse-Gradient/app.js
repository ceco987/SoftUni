function attachGradientEvents() {
    const element = document.getElementById('gradient');
    const result = document.getElementById('result');
    
    element.addEventListener('mousemove',onMouseMove);
    // element.addEventListener('mouseleave',()=>result.textContent='');

    function onMouseMove(ev){
        let coor = ev.offsetX;
        coor = Math.floor(coor/element.clientWidth*100);
        result.textContent= `${coor}%`;
    }

}