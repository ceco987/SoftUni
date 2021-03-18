const url = 'http://localhost:3030/jsonstore/messenger';

function attachEvents() {
    const distributor = {
        'submit': sendMessage,
        'refresh': getMessages
    }

    document.getElementById("controls").addEventListener('click', ev => {
        if (ev.target.type == 'button') {
            const author = document.querySelector('input[name="author"]').value;
            const content = document.querySelector('input[name="content"]').value;
            distributor[ev.target.id]({ author, content });
        }
    })


}

async function sendMessage(message) {
    const response = await fetch(url, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(message)
    })

}

async function getMessages() {
    const response = await fetch(url);
    const data = await response.json();

    const output = Object.values(data).reduce((acc, c) => {
        acc.push(`${c.author}: ${c.content}`)
        return acc;
    }, []);

    const inputField = document.getElementById("messages").value = output.join('\n');


}

attachEvents();