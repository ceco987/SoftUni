const {assert} = require('chai');
const isOddOrEven = require('../2.EvenOrOdd');

describe ("General Tests",()=>{
    it("return undefined on number",()=>{
        assert.isUndefined(isOddOrEven(5))
    });
    
    it("return undefined on array",()=>{
        assert.isUndefined(isOddOrEven([5]))
    });
    
    it("return 'even' on even string input",()=>{
        assert.equal(isOddOrEven('aa'),'even')
    });
    
    it("return 'odd' on odd string input",()=>{
        assert.equal(isOddOrEven('a'),'odd')
    });
})