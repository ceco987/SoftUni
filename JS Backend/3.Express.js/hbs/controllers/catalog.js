const router = require('express').Router();

router.get('/',(req,res)=>{
    const ctx = {
        books: req.storage.getAll()
    };
    res.render('catalog',ctx)
});

router.get('/create/',(req,res)=>{
    res.render('create');
})

router.post('/create/',(req,res)=>{
    console.log(req.body)
    //... validate fields
    //... save in storage
    res.redirect('/catalog');
})

module.exports= router;