const {sum} = require('./4.SumOfNumbers');
const {expect,assert} = require('chai');

describe('Sum function', ()=>{
    it('returns correct result',()=>{
        assert.equal(sum([1,2]),3)
    })
})