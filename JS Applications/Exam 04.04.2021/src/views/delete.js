import { html } from "../../node_modules/lit-html/lit-html.js"
import { deleteArticle} from "../api/data.js";

const modalTemplate = (onDelete,id) => html`
<div class="overlay">
    <div class="modal">
        <p>Are you sure you want to delete this article?</p>
        <a @click=${onDelete} href="javascript:void(0)" class="action">Yes</a>
        <a href="/details/${id}" class="action">No</a>
    </div>
</div>
`;

export async function deletePage(ctx) {
    const deleteId = ctx.params.id;
    ctx.render(modalTemplate(onDelete,deleteId));

    async function onDelete(){
        await deleteArticle(deleteId);
        document.querySelector('.overlay').style.display = 'none';
        ctx.page.redirect('/');
    }
}