const mongoose = require('mongoose');

const schema = new Mongoose.Schema({
    author: {type: mongoose.Schema.Types.ObjectId, ref: 'Person'},
    title:{type: String, required: true},
    content:{type: String, minLength: 10}
});

module.exports = mongoose.model('Post',schema)