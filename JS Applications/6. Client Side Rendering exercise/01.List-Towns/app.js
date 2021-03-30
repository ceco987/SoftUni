import { html, render } from "../node_modules/lit-html/lit-html.js"

const form = document.querySelector('form');
const target = document.getElementById('root');

document.getElementById('btnLoadTowns').addEventListener('click',(event)=>{
    event.preventDefault();
    const formData = new FormData(form);

    const data = formData.get('towns').split(', ').filter(e=>e!='');
    
    const template = (input) => html`
        <ul>
            ${input.map(e=>html`<li>${e}</li>`)}
        </ul>
    `
    const result = template(data);
    render(result,target);
})