import { html } from "../../node_modules/lit-html/lit-html.js"
import { loaderTemplate } from "../views/common/loader.js"
import { until } from "../../node_modules/lit-html/directives/until.js"
import { search } from "../api/data.js";

const searchTemplate = (data, onSubmit) => html`
<section id="search-page" class="content">
    <h1>Search</h1>
    <form @submit=${onSubmit} id="search-form">
        <p class="field search">
            <input type="text" placeholder="Search by article title" name="search">
        </p>
        <p class="field submit">
            <input class="btn submit" type="submit" value="Search">
        </p>
    </form>
    ${data==-1 ? '' : data.length>0 ?
    data.map(resultTemplate) :
    html` <div class="search-container">
        <h3 class="no-articles">No matching articles</h3>
    </div>`}
</section>`;

const resultTemplate = (result) => html`
<div class="search-container">
    <a class="article-preview" href="/details/${result._id}">
        <article>
            <h3>Topic: <span>${result.title}</span></h3>
            <p>Category: <span>${result.category}</span></p>
        </article>
    </a>
</div>
`

export async function searchPage(ctx) {
    ctx.render(searchTemplate(-1,onSubmit));

    async function onSubmit(event) {
        event.preventDefault();
        const query = event.target.querySelector('[name="search"]');
        ctx.render(until(populateTemplate(),loaderTemplate()))
        event.target.reset();

        async function populateTemplate() {
            const data = await search(query.value);
            return searchTemplate(data,onSubmit);
        }
    }
}