const mongoose = require('mongoose');

const personSchema = new mongoose.Schema({
    firstName: String,
    lastName: String,
    age: Number
},
    { versionKey: false }
);
personSchema.virtual('fullName').get(function () {
    return this.firstName + ' ' + this.lastName;
});
personSchema.methods.sayHi = function () {
    console.log(`My name is ${this.firstName} and I am ${this.age} years old.`);
};

const Person = mongoose.model('Person', personSchema);

module.exports = Person;