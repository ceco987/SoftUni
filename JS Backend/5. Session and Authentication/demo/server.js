const express = require('express');
const bodyParser = require('express').urlencoded;
const expressSession = require('express-session');
const routes = require('./controllers');
const auth = require('./auth')

// const cookieParser = require('cookie-parser');

/*
const sessions = {};

function mySessionStorage(req, res, next) {
    let session = {};
    if (req.cookies.sessionId && sessions[req.cookies.sessionId] != undefined) {
        const id = req.cookies.sessionId;
        session = sessions[id];
        console.log('>>> Existing session', session)
    } else {
        createSession();
    }
    
    req.session = session;
    
    next();
    
    function createSession() {
        const id = ('0000000' + (Math.random() * 99999999 | 0).toString(16)).slice(-8);
        session.visited = 0;
        sessions[id] = session;
        
        res.cookie('sessionId', id)        
        console.log('New user, generated session with id:', id);
    }
}

app.use(cookieParser());
app.use(mySessionStorage)

app.get('/', (req, res) => {
    req.session.visited++;
    res.send('<h1>Hello</h1><p>Your session has data ' + JSON.stringify(req.session) + '</p>');
}) */

const users = {};
const app = express();
app.use(bodyParser({ extended: false }))
app.use(expressSession({
    secret: 'my random secret',
    resave: false,
    saveUninitialized: true,
    cookie: { secure: false }
}));
app.use(auth);

routes(app);

app.post('/register', async (req, res) => {
    await req.register(req.body.username, req.body.password);
    res.redirect('/login')
})

app.post('/login', async (req, res) => {
    const username = req.body.username;
    const password = req.body.password;

    const passwordsMatch = await req.login(username, password);
    if (passwordsMatch) {
        res.redirect('/');
    } else {
        res.send(403, 'Wrong password');
    }
});


app.listen(3000, () => console.log('Start creating magic...'));