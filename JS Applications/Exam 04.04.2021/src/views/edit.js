import { html } from "../../node_modules/lit-html/lit-html.js"
import { loaderTemplate } from "../views/common/loader.js"
import { until } from "../../node_modules/lit-html/directives/until.js"
import { editArticle, getArticleById } from "../api/data.js";
import { formValidation } from "./common/formValidation.js";

const editTemplate = (onSubmit, data) => html`
<section id="edit-page" class="content">
    <h1>Edit Article</h1>

    <form @submit=${onSubmit} id="edit" action="#" method="">
        <fieldset>
            <p class="field title">
                <label for="title">Title:</label>
                <input type="text" name="title" id="title" .value=${data.title} placeholder="Enter article title">
            </p>

            <p class="field category">
                <label for="category">Category:</label>
                <input type="text" name="category" id="category" .value=${data.category}
                    placeholder="Enter article category">
            </p>
            <p class="field">
                <label for="content">Content:</label>
                <textarea name="content" .value=${data.content} id="content"></textarea>
            </p>

            <p class="field submit">
                <input class="btn submit" type="submit" value="Save Changes">
            </p>

        </fieldset>
    </form>
</section>`;

export async function editPage(ctx) {
    const articleId = ctx.params.id;

    //initial population
    ctx.render(until(initialPopulate(), loaderTemplate()))

    async function onSubmit(event) {
        event.preventDefault();

        const formData = new FormData(event.target);

        const title = formData.get('title');
        const category = formData.get('category');
        const content = formData.get('content');
        
        try{   
            formValidation(title, category, content);
    
            [...event.target.querySelectorAll('label')].forEach(e=>e.disabled=true);
            await editArticle(articleId, { title, category, content });
            [...event.target.querySelectorAll('label')].forEach(e=>e.disabled=false);
            event.target.reset();
            ctx.page.redirect(`/details/${articleId}`)
        } catch (err){
            alert (err.message)
        }
    }

    async function initialPopulate() {
        const data = await getArticleById(articleId)
        return editTemplate(onSubmit, data)
    }
}