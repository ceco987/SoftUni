import page from "../node_modules/page/page.mjs"
import { render } from "../node_modules/lit-html/lit-html.js"

import { homePage } from "./views/home.js"
import { browsePage } from "./views/browse.js";
import { loginPage } from "./views/login.js";
import { registerPage } from "./views/register.js";
import { logout as apiLogout} from "./api/data.js";
import { createPage } from "./views/create.js";
import { detailsPage } from "./views/details.js";
import { editPage } from "./views/edit.js";

const main = document.querySelector('main');
document.getElementById('logoutBtn').addEventListener('click',logout);

page('/', decorateContext, homePage);
page('/index.html', decorateContext, homePage);
page('/browse', decorateContext, browsePage);
page('/login',decorateContext,loginPage);
page('/register',decorateContext,registerPage)
page('/create',decorateContext,createPage)
page('/details/:id',decorateContext,detailsPage)
page('/edit/:id',decorateContext,editPage)

setUserNav();

page.start();

function decorateContext(ctx, next) {
    ctx.render = (content) => render(content, main)
    ctx.setUserNav = setUserNav;
    next();
}

function setUserNav() {
    const userId = sessionStorage.getItem('userId')
    if (userId != null) {
        [...document.querySelectorAll('a.user')].forEach(e => e.style.display = 'block');
        [...document.querySelectorAll('a.guest')].forEach(e => e.style.display = 'none');
    } else {
        [...document.querySelectorAll('a.user')].forEach(e => e.style.display = 'none');
        [...document.querySelectorAll('a.guest')].forEach(e => e.style.display = 'block');

    }
}

async function logout(){
    await apiLogout();
    setUserNav();
    page.redirect('/')
}