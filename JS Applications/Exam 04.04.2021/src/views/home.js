import { html } from "../../node_modules/lit-html/lit-html.js"
import { loaderTemplate } from "../views/common/loader.js"
import { until } from "../../node_modules/lit-html/directives/until.js"
import { getRecentArticles } from "../api/data.js";

const sectionsMap = {
    JavaScript: 'js',
    Python: 'python',
    Java: 'java',
    "C#": 'csharp'
}

const sectionTemplate = (cat,trueCat) => html`
${cat ? 
html`<section class="recent ${sectionsMap[cat.category]}">
    <h2>${cat.category}</h2>
    <article>
        <h3>${cat.title}</h3>
        <p>${cat.content}</p>
        <a href="/details/${cat._id}" class="btn details-btn">Details</a>
    </article>
</section>` : 
html`<section class="recent ${sectionsMap[trueCat]}">
    <h2>${trueCat}</h2>
    <h3 class="no-articles">No articles yet</h3>
</section>`}`;

const homeTemplate = (data) => html`
<section id="home-page" class="content">
    <h1>Recent Articles</h1>
    ${Object.keys(sectionsMap).map(s => {
    const cat = data.find(ar => ar.category == s);
    return html`${sectionTemplate(cat,s)}`
    })}`;

export async function homePage(ctx) {
    ctx.render(until(populateTemplate(), loaderTemplate()))

    async function populateTemplate() {
        const data = await getRecentArticles();
        return homeTemplate(data);
    }
}