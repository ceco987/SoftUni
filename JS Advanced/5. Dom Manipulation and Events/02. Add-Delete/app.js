function addItem() {
    const textField = document.getElementById("newItemText");
    const list = document.getElementById("items");
    if(textField.value.length == 0) return;
    let newLi = document.createElement("li");
    newLi.textContent = textField.value;

    let remove = document.createElement('a');
    remove.textContent = "[Delete]";
    remove.href = '#';
    remove.addEventListener("click",() =>newLi.remove());
    newLi.appendChild(remove);
    list.appendChild(newLi);
    textField.value='';
}