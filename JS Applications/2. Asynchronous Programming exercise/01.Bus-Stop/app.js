async function getInfo() {
    const id = document.getElementById("stopId");
    const url = `http://localhost:3030/jsonstore/bus/businfo/${id.value}`

    let name = '';
    let busses = {};
    const stop = document.getElementById("stopName");
    const busList = document.getElementById("buses");
    
    const result = await fetch(url);

    try {
        const data = await result.json();
        busses.innerHTML = '';
        name = data.name;
        busses = data.buses;
        stop.textContent = name;
        
        for(let [bus, time] of Object.entries(busses)){
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