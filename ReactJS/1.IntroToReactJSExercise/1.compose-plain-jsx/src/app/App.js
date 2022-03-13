import './style/app.css';
import ContactList from './contacts.json'
import { render } from 'react-dom'

let targetEmail = ContactList[0].email

const detailsDiv = (contact) => (
    <div className="content">
        <div className="info">
            <div className="col">
                <span className="avatar">&#9787;</span>
            </div>
            <div className="col">
                <span className="name">{contact.firstName}</span>
                <span className="name">{contact.lastName}</span>
            </div>
        </div>
        <div className="info">
            <span className="info-line">&phone; {contact.phone}</span>
            <span className="info-line">&#9993; {contact.email}</span>
        </div>
    </div>
)

const displayContact = (email) => {
    targetEmail = email
    render(App(), document.getElementById('root'))
}

const showContact = data => (
    <div className="contact" data-id="id" key={data.email} onClick={() => displayContact(data.email)}>
        <span className="avatar small">&#9787;</span>
        <span className="title">{data.firstName} {data.lastName}</span>
    </div>
)

function App() {
    return (
        <div className="container">
            <header>&#9993; Contact Book</header>
            <div id="book">
                <div id="list">
                    <h1>Contacts</h1>
                    <div className="content">
                        {ContactList.map(showContact)}
                    </div>
                </div>
                <div id="details">
                    <h1>Details</h1>
                    {detailsDiv(ContactList.find(e => e.email === targetEmail))}
                </div>
            </div>
            <footer>Contact Book SPA &copy; 2017</footer>
        </div>
    );
}

export default App;
