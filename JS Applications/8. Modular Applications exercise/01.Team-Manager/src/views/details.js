import { until } from "../../node_modules/lit-html/directives/until.js"
import { html } from "../../node_modules/lit-html/lit-html.js"
import { getTeamById, requestToJoin, getRequestsbyTeamId, cancelMembership } from "../api/data.js"
import { loaderTemplate } from "./common/loader.js";

const detailsTemplate = (team, createControls) => html`
<section id="team-home">
    <article class="layout">
        <img src=${team.logoUrl} class="team-logo left-col">
        <div class="tm-preview">
            <h2>${team.name}</h2>
            <p>${team.description}</p>
            <span class="details">?? Members</span>
            <div>
                ${createControls()}
            </div>
        </div>
        <div class="pad-large">
            <h3>Members</h3>
            <ul class="tm-members">
                <li>My Username</li>
                <li>James<a href="#" class="tm-control action">Remove from team</a></li>
                <li>Meowth<a href="#" class="tm-control action">Remove from team</a></li>
            </ul>
        </div>
        <div class="pad-large">
            <h3>Membership Requests</h3>
            <ul class="tm-members">
                <li>John<a href="#" class="tm-control action">Approve</a><a href="#"
                        class="tm-control action">Decline</a></li>
                <li>Preya<a href="#" class="tm-control action">Approve</a><a href="#"
                        class="tm-control action">Decline</a></li>
            </ul>
        </div>
    </article>
</section>`;



export async function detailsPage(ctx) {
    const teamId = ctx.params.id;

    ctx.render(until(populateTemplate(teamId), loaderTemplate()))

    async function populateTemplate(teamId) {
        const userId = sessionStorage.getItem('userId')
        const [team, requests] = await Promise.all([
            getTeamById(teamId),
            getRequestsbyTeamId(teamId)
        ])

        return detailsTemplate(team, createControls);

        function createControls() {
            if (userId != null) {
                const request = requests.find(r => r._ownerId == userId)
                if (userId == team._ownerId) {
                    // Current user is owner
                    return html`<a href="${`/edit/${team._id}`}" class="action">Edit team</a>`;
                } else if (request && request.status == 'member') {
                    // Current user is a member
                    return html`<a @click=${e=>leave(e,request._id)} href="javascript:void(0)" class="action invert">Leave team</a>`;
                } else if (request && request.status =='pending') {
                    // Current user has a pending request
                    return html`Membership pending. <a @click=${e=>leave(e,request._id)} href="javascript:void(0)">Cancel request</a>`;
                } else {
                    // User is not related to the team
                    return html`<a @click=${join} href="javascript:void(0)" class="action">Join team</a>`;
                }

            } else return ''; //guest visitor
        };

        async function join(event) {
            event.target.remove();
            await requestToJoin(teamId);
            ctx.render(await populateTemplate(teamId));
        }

        async function leave(event, requestId) {
            event.target.remove();
            const confirmed = confirm('Are you sure?');
            if (confirmed) {
                await cancelMembership(requestId)
                ctx.render(await populateTemplate(teamId));
            }

        }

    }

}


