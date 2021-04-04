import { html } from "../../node_modules/lit-html/lit-html.js"
import { loaderTemplate } from "../views/common/loader.js"
import { until } from "../../node_modules/lit-html/directives/until.js"
import { getArticleById, deleteArticle } from "../api/data.js";

const detailsTemplate = (article, isOwner, onDelete,isSearch) => html`
<section id="details-page" class="content details">
    <h1>${article.title}</h1>

    <div class="details-content">
        <strong>Published in category ${article.category}</strong>
        <p>${article.content}</p>

        <div class="buttons">
            ${isOwner ? html`
            <a @click=${onDelete} href="javascript:void(0)" class="btn delete">Delete</a>
            <a href="/delete/${article._id}" class="btn delete sexy">Sexy Delete</a>
            <a href="/edit/${article._id}" class="btn edit">Edit</a>
            ` : ''}
            <a href="/" class="btn edit">Back</a>
        </div>
    </div>
</section>`;

export async function detailsPage(ctx) {

    ctx.render(until(populateTemplate(), loaderTemplate()))

    async function populateTemplate() {
        const article = await getArticleById(ctx.params.id)
        const ownerId = article._ownerId;
        const userId = sessionStorage.getItem('userId');
        const isSearch = ctx.params.search;
        return detailsTemplate(article, ownerId == userId, onDelete,isSearch)
    }
    async function onDelete() {
        const confirmed = confirm("Are you sure you want to delete this record?")
        if (confirmed) {
            await deleteArticle(ctx.params.id)
            ctx.page.redirect('/')
        }
    }

}