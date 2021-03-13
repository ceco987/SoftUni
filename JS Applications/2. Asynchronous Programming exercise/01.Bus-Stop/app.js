async function getInfo() {
    const id = document.getElementById("stopId");
    const url = `http://localhost:3030/jsonstore/bus/businfo/${id.value}`

    const stop = document.getElementById("stopName");
    const busList = document.getElementById("buses");
    
    try {
        const result = await fetch(url);
        const data = await result.json();
        busList.innerHTML = '';
        stop.textContent = data.name;
        
        for(let [bus, time] of Object.entries(data.buses)){
            const li = document.createElement('li');
            li.textContent = `Bus ${bus} arrives in ${time} minues`;
            busList.appendChild(li);
        }
        id.value = '';
    }
    catch(err){
        stop.textContent = 'Error';
    }

}

function click(inputField,button){
    inputField.addEventListener('keyup',(ev)=>{
        if(ev.key=='Enter') button.click();
    })
}