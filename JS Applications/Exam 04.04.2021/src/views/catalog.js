import { html } from "../../node_modules/lit-html/lit-html.js"
import {until} from "../../node_modules/lit-html/directives/until.js"
import { getAllArticles } from "../api/data.js";
import {loaderTemplate} from "../views/common/loader.js"

const catalogTemplate = (data) => html`
<section id="catalog-page" class="content catalogue">
    <h1>All Articles</h1>
    ${data!='' ? 
        html`${data.map(articleTemplate)}` : 
        html`<h3 class="no-articles">No articles yet</h3>`}   
</section>`;

const articleTemplate = (article) => html`
<a class="article-preview" href="/details/${article._id}">
    <article>
        <h3>Topic: <span>${article.title}</span></h3>
        <p>Category: <span>${article.category}</span></p>
    </article>
</a>`;

export async function catalogPage(ctx) {
    ctx.render(until(populateTemplate(),loaderTemplate()))
    
    async function populateTemplate(){
        const data = await getAllArticles();
        return catalogTemplate(data);
    }
}