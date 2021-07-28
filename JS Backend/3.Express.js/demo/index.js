const express = require('express');
const logger = require('./logger');
const responses = [
    'Я пак 😉',
    'тц, нещо не уцели',
    'пробвай пак',
    'няма такова нещо',
    'чети си кода бе човеко...',
    '404 мозъка на красьо'
]

const app = express();
app.use(logger)
app.get('/', (req,res)=>{
    res.send('Hello express!')
});

app.get('/tos',(req,res)=>{
    res.sendFile(__dirname+'/test.pdf',);
})

app.route('*').all((req,res)=>{
    const magicNumber = Math.floor(Math.random() * responses.length);
    res.send(responses[magicNumber]);
})

app.listen(3000,()=>console.log('Server listening on port 3000...'));
