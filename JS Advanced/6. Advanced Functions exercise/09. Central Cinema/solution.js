function solve() {

    const onScreen = document.querySelector("button")
    const archiveList = document.querySelector("#archive ul");
    const movieListField = document.querySelector("section#movies ul");
    const fieldArray = Array.from(document.querySelectorAll("div#container input[type='text']"));

    onScreen.addEventListener("click",addMovie);

    function addMovie(e){
        e.preventDefault();
        if(validateInitial(fieldArray)){
            const name = fieldArray[0].value;
            const hall = fieldArray[1].value;
            const price = Number(fieldArray[2].value).toFixed(2);

            const resultLi = document.createElement("li");
            
            const span = document.createElement("span");
            span.textContent = name;

            const strong = document.createElement("strong");
            strong.textContent = `Hall: ${hall}`;

            const div = document.createElement("div");
            const strongPrice = document.createElement("strong");
            strongPrice.textContent = price;
            const input = document.createElement("input");
            input.setAttribute('placeholder','Tickets Sold');
            const button = document.createElement("button");
            button.textContent = 'Archive';
            div.appendChild(strongPrice);
            div.appendChild(input);
            div.appendChild(button);

            resultLi.appendChild(span);
            resultLi.appendChild(strong);
            resultLi.appendChild(div);

            movieListField.appendChild(resultLi);

            clearInputs(fieldArray);
        }
    }

    document.getElementById('movies').addEventListener('click',archiveMovie);

    function archiveMovie (ev){
        if(ev.target.tagName=='BUTTON'&&validateNumber(ev.target.parentNode.querySelector("input").value)){
            const removed = ev.target.parentNode.parentNode.parentNode.removeChild(ev.target.parentNode.parentNode);
            const totalAmount = Number(removed.querySelector('div strong').textContent)*Number(removed.querySelector('div input').value)
            removed.removeChild(removed.querySelector('div'));
            removed.querySelector('strong').textContent=`Total amount: ${totalAmount.toFixed(2)}`;
            const deleteButton = document.createElement('button');
            deleteButton.textContent = 'Delete';
            removed.appendChild(deleteButton);
            archiveList.appendChild(removed);
        }
    }

    archiveList.parentNode.addEventListener("click",deleteRecord)

    function deleteRecord(ev){
        if (ev.target.tagName=='BUTTON'&&ev.target.textContent=='Delete'){
            ev.target.parentNode.parentNode.removeChild(ev.target.parentNode);
        }
        else if(ev.target.tagName=='BUTTON'&&ev.target.textContent=='Clear'){
            const ul = ev.target.parentNode.querySelector('ul');
            while(ul.firstChild){
                ul.removeChild(ul.firstChild)
            }
        }
    }
    
    const validateInitial = (arr) => arr[0].value&&arr[1].value&&arr[2].value&&!Number.isNaN(Number(arr[2].value));
    const validateNumber = (val) => val!=''&&!Number.isNaN(Number(val));
    const clearInputs = (arr) => arr.map(e=>e.value = '');
}