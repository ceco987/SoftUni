function getArticleGenerator(articles) {
    const div = document.querySelector("#content");
    return ()=>{
        let element = articles.shift();
        if (!element) return;
        const article = document.createElement("article");
        article.textContent = element;
        div.appendChild(article);        
    }
}
