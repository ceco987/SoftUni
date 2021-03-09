function loadRepos() {
	const username = document.getElementById("username").value;
	const url = `https://api.github.com/users/${username}/repos`;
	fetch(url).then(response=>response.json().then((data)=>console.log(data)));
}