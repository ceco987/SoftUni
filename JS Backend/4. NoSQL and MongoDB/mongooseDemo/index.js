const mongoose = require('mongoose');
const Person = require('./models/Person');
const Cat = require('./models/Cat');
const Post = require('./models/Post');

start();

async function start() {
    const client = await mongoose.connect('mongodb://localhost:27017/testdb', {
        useNewUrlParser: true,
        useUnifiedTopology: true
    });

    console.log('Database connected');

    // code for creating and persisting entries in the schema
    /* const person1 = new Personrson({
        firstName: 'John',
        lastName: 'Smith',
        age: 34
    });

    const person2 = new Person({
        firstName: 'Adam',
        lastName: 'Johnson',
        age: 29
    });
    await person1.save();
    await person2.save(); */

    // methods example
    /* const people = await Person.find({});
    people.forEach(p => p.sayHi());
    people.map(p => p.fullName).forEach(p => console.log(p)) */

    // relation example
   /*  const person = await Person.findOne({});
    const post = new Post({
        author: person,
        title: 'New Post',
        content: 'This is post content'
    });
    await post.save(); */
    
}