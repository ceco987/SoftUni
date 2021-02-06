function deleteByEmail() {
    const textField = document.querySelector('input[name="email"]');
    const rows = Array.from(document.querySelectorAll('tbody tr'));
    let outputMessage = 'Not found.'
    for (let row of rows){
        if(row.children[1].textContent==textField.value){
            row.remove();
            outputMessage = 'Deleted.'
        }
    }
    document.getElementById('result').textContent = outputMessage;
    textField.value='';
}