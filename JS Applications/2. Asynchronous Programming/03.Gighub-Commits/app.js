function loadCommits() {
    const username = document.getElementById("username");
    const repo = document.getElementById("repo");
    const url = `https://api.github.com/repos/${username.value}/${repo.value}/commits`;
    const ul = document.getElementById("commits");

    //fix
    fetch(url)
        .then(response => {
            try {
                const test = response.json();
                test.then(data => {
                    ul.innerHTML = '';
                    data.forEach(e => {
                        const li = document.createElement('li')
                        li.textContent = `${e.commit.author.name}: ${e.commit.message}`;
                        ul.appendChild(li);
                    })
                })
            }
            catch (err) {
                console.log(response)
                ul.innerHTML = '';
                const li = document.createElement('li');
                li.textContent = `Error: ${response.status} (${response.statusText})`;
                ul.appendChild(li);
            }
        })

}

document.querySelector("body").addEventListener('keyup', (ev) => {
    if (ev.target.tagName == "INPUT" && ev.key == 'Enter') {
        document.querySelector("button").click();
    }
})