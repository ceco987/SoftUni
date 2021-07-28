const { MongoClient } = require('mongodb');
const connectionStr = 'mongodb://localhost:27017';
const client = new MongoClient(connectionStr, {
    useUnifiedTopology: true
});

client.connect((err)=>{
    if (err!=null){
        console.log('Something unexpected happened!')
        return;
    }

    console.log('Database connected!')

    const db = client.db('testdb')
    const collection = db.collection('cats');
    collection.find({}).toArray((err,data)=>{
        console.log(data);
    });
});