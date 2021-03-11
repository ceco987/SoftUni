async function solution() {
    //part 1: create "summary" view
    const url = 'http://localhost:3030/jsonstore/cookbook/recipes'
    const main = document.querySelector("main");

    const response = await fetch(url);
    const data = await response.json();
    main.innerHTML = '';

    Object.values(data).forEach(e => {
        const article = document.createElement("article");
        article.classList.add("preview");

        const divTitle = document.createElement("div");
        divTitle.classList.add("title");
        const h2 = document.createElement("h2");
        h2.textContent = e.name;
        divTitle.appendChild(h2);

        const divImage = document.createElement("div");
        divImage.classList.add("small");
        const img = document.createElement("img");
        img.src = e.img;
        divImage.appendChild(img);

        article.appendChild(divTitle);
        article.appendChild(divImage);
        main.appendChild(article);

        article.addEventListener('click', () => expansion(e._id, article))

    })

    //part 2: expand specific card
    async function expansion(id, element) {
        const url = 'http://localhost:3030/jsonstore/cookbook/details/' + id;
        const response = await fetch(url);
        const data = await response.json();

        const result = e('article', {},
            e('h2', {}, data.name),
            e('div', { className: 'band' },
                e('div', { className: 'thumb' },
                    e('img', { src: data.img })
                ),
                e('div', { className: 'ingredients' },
                    e('h3', {}, 'Ingredients:'),
                    e('ul', {}, data.ingredients.map(i => e('li', {}, i)))
                )
            ),
            e('div', { className: 'description' },
                e('h3', {}, 'Preparation:'),
                data.steps.map(s => e('p', {}, s))
            )
        )

        element.parentNode.replaceChild(result, element);
    }

}

function e(type, attributes, ...content) {
    const result = document.createElement(type);

    for (let [attr, value] of Object.entries(attributes || {})) {
        if (attr.substring(0, 2) == 'on') {
            result.addEventListener(attr.substring(2).toLocaleLowerCase(), value)
        } else {
            result[attr] = value;
        }
    }

    content = content.reduce((acc, c) => acc.concat(Array.isArray(c) ? c : [c]), [])

    content.forEach(e => {
        if (typeof e == 'string' || typeof e == 'number') {
            const node = document.createTextNode(e);
            result.appendChild(node)
        } else {
            result.appendChild(e)
        }
    })

    return result;
}
