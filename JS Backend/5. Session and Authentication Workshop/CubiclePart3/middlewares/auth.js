const userService = require('../services/user')

module.exports = () => (req,res,next) =>{
    req.auth = {
        register: userService.createUser
    }
    
    next();
}