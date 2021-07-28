const mongoose = require('mongoose');

const catSchema = new mongoose.Schema({
    name: String,
    color: String
}, { versionKey: false });

const Cat = mongoose.model('Cat', catSchema);

module.exports = Cat;