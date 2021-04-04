import { html } from "../../node_modules/lit-html/lit-html.js"
import { getTeams } from "../api/data.js";


const teamTemplate = (team) => html`
<article class="layout">
    <img src=${team.logoUrl} class="team-logo left-col">
    <div class="tm-preview">
        <h2>${team.name}</h2>
        <p>${team.description}</p>
        <span class="details">??? Members</span>
        <div><a href="/details/${team._id}" class="action">See details</a></div>
    </div>
</article>`;

const browseTeamplate = (data) => html`
<section id="browse">

    <article class="pad-med">
        <h1>Team Browser</h1>
    </article>

    <article class="layout narrow">
        <div class="pad-small"><a href="/create" class="action cta">Create Team</a></div>
    </article>

    ${data.map(teamTemplate)}

</section>
`;

export async function browsePage(ctx) {
    const teams = await getTeams();
    ctx.render(browseTeamplate(teams))
}