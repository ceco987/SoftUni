function addItem() {
    const item = document.getElementById("newItemText");
    const list = document.getElementById("items");
    let newLi = document.createElement("li");
    newLi.textContent = item.value;
    item.value='';
    list.appendChild(newLi);
}