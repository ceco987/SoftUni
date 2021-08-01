const bcrypt = require('bcrypt');
const saltRounds = 8;
const pass1 = 'password1';
const pass2 = 'password2';

async function gen() {
    const hash = await bcrypt.hash(pass1, saltRounds);
    console.log(hash);
};


async function comp(hash) {
    const check1 = await bcrypt.compare(pass1, hash);
    console.log('Comparing ', pass1, '=>', check1);

    const check2 = await bcrypt.compare(pass2, hash)
    console.log('Comparing ', pass2, '=>', check2);   
}

gen();
comp('$2b$10$XOeA6.QePOtST.CY2X22sum1Ce4WydZxci.YNpfAA3t9ps9PLa/WS');