document.querySelector('form').addEventListener('submit', createRecipe);

async function createRecipe(ev) {
    ev.preventDefault();
    const formData = new FormData(ev.target);
    const name = formData.get('name');
    const img = formData.get('img');
    const ingredients = formData
        .get('ingredients')
        .split('\n')
        .map(e => e.trim())
        .filter(e => e != '');
    const steps = formData
        .get('steps')
        .split('\n')
        .map(e => e.trim())
        .filter(e => e != '');

    const response = await fetch('http://localhost:3030/data/recipes', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-Authorization': sessionStorage.getItem('userToken')
        },
        body: JSON.stringify({ name, img, ingredients, steps })
    })

    if (!response.ok){
        const error = await response.json();
        return alert(error.message);
    }

    window.location.pathname = 'index.html';

}