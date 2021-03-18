const url = 'http://localhost:3030/jsonstore/phonebook/';
function attachEvents() {
    document.getElementById("btnLoad").addEventListener("click", getRecords)
    document.getElementById("btnCreate").addEventListener("click", createRecord);
}

async function getRecords() {
    const recordsList = document.getElementById("phonebook");
    recordsList.innerHTML = '';
    const response = await fetch(url);
    const data = await response.json();

    Object.entries(data)
        .map(([key,rec]) => {
            const li = e('li', {},
                `${rec.person}: ${rec.phone}`,
                e('button', {
                    'href': 'javascript:void(0)',
                    'onclick': ev => {
                        fetch(url + key, {
                            method: 'DELETE'
                        });

                        ev.target.parentNode.remove()
                    }
                },
                    'Delete')
            )
            recordsList.appendChild(li);
        })

}

function createRecord() {
    const person = document.getElementById("person");
    const phone = document.getElementById("phone");
    
    fetch(url, {
        method: "POST",
        headers: { "Content-Type": 'application/json' },
        body: JSON.stringify({ person: person.value, phone: phone.value })
    })

    person.value = '';
    phone.value = '';
}

attachEvents();

function e(type, attributes, ...content) {
    const result = document.createElement(type);

    for (let [attr, value] of Object.entries(attributes || {})) {
        if (attr.substring(0, 2) == 'on') {
            result.addEventListener(attr.substring(2).toLocaleLowerCase(), value)
        } else {
            result[attr] = value;
        }
    }

    content = content.reduce((acc, c) => acc.concat(Array.isArray(c) ? c : [c]), [])

    content.forEach(e => {
        if (typeof e == 'string' || typeof e == 'number') {
            const node = document.createTextNode(e);
            result.appendChild(node)
        } else {
            result.appendChild(e)
        }
    })

    return result;
}