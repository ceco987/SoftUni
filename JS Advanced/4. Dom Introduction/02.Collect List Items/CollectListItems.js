function extractText() {
    const elements = document.getElementsByTagName('li');
    document.getElementById('result').value = Array.from(elements).map(e=>e.textContent).join('\n');
}