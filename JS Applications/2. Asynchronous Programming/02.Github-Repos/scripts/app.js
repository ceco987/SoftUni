function loadRepos() {
	const username = document.getElementById("username").value;
	const url = `https://api.github.com/users/${username}/repos`;
	const repos = document.getElementById("repos");
	fetch(url)
		.then(response => response.json())
		.then(data => {
			repos.innerHTML = '';
			document.getElementById("username").value = '';
			data.forEach(e => {
				const li = document.createElement("li");
				const a = document.createElement("a");
				a.href = e.html_url;
				a.textContent = e.full_name;
				li.appendChild(a);
				repos.appendChild(li);
			})
		});
}

document.getElementById("username").addEventListener("keyup", (ev) => {
	if (ev.key == "Enter") {
		document.querySelector("button").click();
	}
})