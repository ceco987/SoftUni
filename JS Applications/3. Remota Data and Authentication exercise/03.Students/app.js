const url = 'http://localhost:3030/jsonstore/collections/students';
const form = document.querySelector('form')
const table = document.querySelector('table tbody');

form.addEventListener('submit', async ev => {
    ev.preventDefault();
    const formData = new FormData(ev.target);

    //fields validation
    if ([...formData.values()].some(e => e == '')) {
        return alert('All fields must be filled!');
    } else if (isNaN(Number(formData.get('facultyNumber')))) {
        return alert('Faculty Number must be a number!');
    } else if (isNaN(Number(formData.get('grade')))) {
        return alert('Grade must be a number!');
    }

    //extracting fields from HTML
    const [firstName, lastName, facultyNumber, grade] = formData.values();
    form.reset();

    //posting to server/db
    await fetch(url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ firstName, lastName, facultyNumber, grade })
    });

    //get request for all records
    const request = await fetch(url);
    const data = await request.json();

    //clear table contents
    table.innerHTML = '';

    //fill in the table with data from input menu
    Object.values(data).forEach(row => {
        const tr = e('tr', {},
            e('td', {}, row.firstName),
            e('td', {}, row.lastName),
            e('td', {}, row.facultyNumber),
            e('td', {}, row.grade)
        )
        table.appendChild(tr);
    })

})


function e(type, attributes, ...content) {
    const result = document.createElement(type);

    for (let [attr, value] of Object.entries(attributes || {})) {
        if (attr.substring(0, 2) == 'on') {
            result.addEventListener(attr.substring(2).toLocaleLowerCase(), value);
        } else {
            result[attr] = value;
        }
    }

    content = content.reduce((a, c) => a.concat(Array.isArray(c) ? c : [c]), []);

    content.forEach(e => {
        if (typeof e == 'string' || typeof e == 'number') {
            const node = document.createTextNode(e);
            result.appendChild(node);
        } else {
            result.appendChild(e);
        }
    });

    return result;
}