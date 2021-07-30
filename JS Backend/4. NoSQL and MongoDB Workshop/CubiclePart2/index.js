// const env = process.env.NODE_ENV || 'development';

// const config = require('./config/config')[env];
// const app = require('express')();

// require('./config/express')(app);
// require('./config/routes')(app);

// [x] initialize express app
// [x] setup handlebars
// [x] setup static files
// [x] setup storage middleware
// [x] set main route handlers (controller actions)

const express = require('express');
const expressConfig = require('./config/express');
const routesConfig = require('./config/routes');
const databaseConfig = require('./config/database');

const { init: storage } = require('./services/storage')

start();

async function start() {
    const port = 3000;
    const app = express();

    expressConfig(app);
    await databaseConfig(app);

    app.use(await storage());
    routesConfig(app); 


    app.listen(port, console.log(`Listening on port ${port}! Now its up to you...`));
}