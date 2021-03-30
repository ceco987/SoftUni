import { towns } from "./towns.js"
import { html, render } from "../node_modules/lit-html/lit-html.js"

const template = (match) => html`
<article>
   <div id="towns">
      <ul>
         ${towns.map(t => liTemplate(t, match))}
      </ul>
   </div>
   <input type="text" id="searchText" />
   <button @click=${search}>Search</button>
   <div id="result"></div>
</article>
`
const liTemplate = (name, match) => html`
<li class=${(match && name.toLowerCase().includes(match.toLowerCase())) ? "active" : "" }>${name}</li>
`
const target = document.body;
update();

function update(match = '') {
   const result = template(match)
   render(result, target)
}

function search() {
   const match = document.getElementById('searchText').value;
   update(match);
   const resultDiv = document.getElementById('result');
   const resultCount = document.querySelectorAll('.active').length;
   resultDiv.textContent = resultCount > 0 ? `${resultCount} matches found` : '';
}