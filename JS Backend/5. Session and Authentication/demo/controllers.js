module.exports = (app) => {
    app.all('*', (req, res, next) => {
        console.log('>>> ', req.method, req.url, req.body);
        console.log('>>> Sesion data:\n', req.session);
        next();
    })

    app.get('/', (req, res) => {
        let title = 'Welcome'
        if(req.session.user){
            title = 'Welcome, ' + req.session.user.username;
        }
        res.send(layout('<p>Home page</p>', title))
    })

    app.get('/register', (req, res) => {
        let title = 'Welcome'
        if(req.session.user){
            title = 'Welcome, ' + req.session.user.username;
        }
        res.send(layout(`
        <form action="/register" method="POST">
            <label>Username: <input type="text" name="username"></label></br>
            <label>Password: <input type="password" name="password"></label></br>
            <label>Repeat: <input type="password" name="repass"></label></br>
            <input type="submit" value="register">
        </form>
    `,title))
    });

    app.get('/login', (req, res) => {
        let title = 'Welcome'
        if(req.session.user){
            title = 'Welcome, ' + req.session.user.username;
        }
        res.send(layout(`
        <form action="/login" method="POST">
            <label>Username: <input type="text" name="username"></label></br>
            <label>Password: <input type="password" name="password"></label></br>
            <input type="submit" value="Login">
        </form>
    `,title))
    });
}

function layout(html, title) {
    return `
    <h1>${title}</h1>
    <a href="/">Home</a>
    <a href="/register">Register</a>
    <a href="/login">Login</a>
    ${html}
    `
}