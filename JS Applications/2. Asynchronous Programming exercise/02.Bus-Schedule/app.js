function solve() {
    const arriveBtn = document.getElementById("arrive");
    const departBtn = document.getElementById("depart");
    const resultBox = document.querySelector('#info').firstChild;

    let stop = {
        next: 'depot'
    };

    async function depart() {
        const url = `http://localhost:3030/jsonstore/bus/schedule/${stop.next}`
        const response = await fetch(url);
        const data = await response.json();
        
        stop = data;
        resultBox.textContent = `Next stop ${stop.name}`
        departBtn.disabled = true;
        arriveBtn.disabled = false;
    }

    function arrive() {
        resultBox.textContent = `Arriving at ${stop.name}`
        departBtn.disabled = false;
        arriveBtn.disabled = true;
    }

    return {
        depart,
        arrive
    };
}

let result = solve();