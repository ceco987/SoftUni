import { contacts } from "./contacts.js";
import { html, render } from "../node_modules/lit-html/lit-html.js";

const cardTemplate = data => html`
<div class="contact card">
    <div>
        <i class="far fa-user-circle gravatar"></i>
    </div>
    <div class="info">
        <h2>Name: ${data.name}</h2>
        <button class="detailsBtn">Details</button>
        <div class="details" id=${data.id}>
            <p>Phone number: ${data.phoneNumber}</p>
            <p>Email: ${data.email}</p>
        </div>
    </div>
`
const container = document.getElementById('contacts');
const result = contacts.map(cardTemplate)
render(result, container)

container.addEventListener('click', onClick)

function onClick(event) {
    if (event.target.classList.contains('detailsBtn')) {
        const details = event.target.nextElementSibling;
        if (details.style.display == 'block') {
            details.style.display = 'none';
        } else details.style.display = 'block'
    }
}