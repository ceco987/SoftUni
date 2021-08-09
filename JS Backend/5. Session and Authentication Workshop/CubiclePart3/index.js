const express = require('express');
const expressConfig = require('./config/express');
const routesConfig = require('./config/routes');
const databaseConfig = require('./config/database');

const storage = require('./middlewares/storage');
const logger = require('./middlewares/logger');

start();

async function start() {
    const port = 3000;
    const app = express();

    // app.use(logger);

    expressConfig(app);
    await databaseConfig(app);

    app.use(await storage());
    routesConfig(app); 


    app.listen(port, console.log(`Listening on port ${port}! Now its up to you...`));
}