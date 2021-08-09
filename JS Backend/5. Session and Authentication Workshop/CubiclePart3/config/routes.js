const {post:commentPost} = require('../controllers/comments');

const productController = require('../controllers/productControllers')
const accessoryController = require('../controllers/accessoryController');
const homecController = require('../controllers/homeController')
const authController = require('../controllers/authController')

module.exports = (app) => {
    app.use('/products',productController);
    app.use('/accessory',accessoryController)
    app.use('/auth',authController)
    app.post('/comments/:cubeId/create', commentPost);
    app.use('/',homecController)
}