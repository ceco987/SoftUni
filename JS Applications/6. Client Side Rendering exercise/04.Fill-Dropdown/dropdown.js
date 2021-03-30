import { html, render } from "../node_modules/lit-html/lit-html.js"

const url = "http://localhost:3030/jsonstore/advanced/dropdown"
const target = document.querySelector('div');
const input = document.getElementById('itemText');

const template = (list) => html`
<select id="menu">
    ${list.map(i => html`<option value=${i._id}>${i.text}</option>>`)}
</select>
`

getItems();

function update(list) {
    const result = template(list);
    render(result, target);
}

async function getItems() {
    document.querySelector('form').addEventListener('submit', ev=>addItem(ev, list))

    const response = await fetch(url);
    const data = await response.json();
    let list = Object.values(data);

    update(list);
}

async function addItem(ev, list) {
    ev.preventDefault();

    const item = {
        text: input.value
    };

    input.value = "Loading, please wait";
    input.setAttribute('disabled',"")

    const reponse = await fetch(url, {
        method: 'post',
        headers: { "Content-Type": "application/json" },
        body: JSON.stringify(item)
    });

    input.value = '';
    input.removeAttribute('disabled')

    const result = await reponse.json();
    list.push(result);

    update(list);
}