class Contact {
    constructor(firstName, lastName, phone, email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this._online = false;
    }

    get online(){
        return this._online;
    }

    set online(value) {
        this._online = value;
        this._online == true ? this.divTitle.classList.add('online') : this.divTitle.classList.remove('online');
    }

    /*
    <article>
        <div class="title">{firstName lastName}<button>&#8505;</button></div>
        <div class="info">
            <span>&phone; {phone}</span>
            <span>&#9993; {email}</span>
        </div>
    </article>
    */

    render(id) {
        this.article = this.elCreater('article')

        this.divTitle = this.elCreater('div', `${this.firstName} ${this.lastName}`);
        this.divTitle.classList.add('title');
        this.buttonInfo = this.elCreater('button');
        this.buttonInfo.innerHTML = '&#8505;';
        this.buttonInfo.addEventListener('click', ()=>{
            this.divInfo.style.display = this.divInfo.style.display === "block" ? "none" : "block"
        })
        this.divTitle.appendChild(this.buttonInfo);

        this.divInfo = this.elCreater('div');
        this.divInfo.classList.add('info');
        this.divInfo.style.display = "none";
        this.spanPhone = this.elCreater('span')
        this.spanPhone.innerHTML = `&phone; ${this.phone}`;
        this.spanEmail = this.elCreater('span');
        this.spanEmail.innerHTML = `&#9993; ${this.email}`;
        this.divInfo.appendChild(this.spanPhone);
        this.divInfo.appendChild(this.spanEmail);

        this.article.appendChild(this.divTitle);
        this.article.appendChild(this.divInfo);

        document.getElementById(id).appendChild(this.article);
    }

    elCreater(type, content) {
        const temp = document.createElement(type);
        temp.textContent = content;
        return temp;
    }

}

let contacts = [
    new Contact("Ivan", "Ivanov", "0888 123 456", "i.ivanov@gmail.com"),
    new Contact("Maria", "Petrova", "0899 987 654", "mar4eto@abv.bg"),
    new Contact("Jordan", "Kirov", "0988 456 789", "jordk@gmail.com")
];
contacts.forEach(c => c.render('main'));  
setTimeout(() => contacts[1].online = true, 2000);
setTimeout(() => contacts[1].online = false, 5000);