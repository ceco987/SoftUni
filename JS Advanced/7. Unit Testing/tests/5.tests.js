const {isSymmetric} = require('../5.CheckForSymmetry');
const {assert,expect} = require('chai')

describe('General test',()=>{
    it("Returns false with number argument",()=>{
        assert.isFalse(isSymmetric(5));
    });
    it("Returns false with string argument",()=>{
        assert.isFalse(isSymmetric('domati'));
    });
    it("Returns false with NaN argument",()=>{
        assert.isFalse(isSymmetric(NaN));
    });
    it("Returns false with undefined argument",()=>{
        assert.isFalse(isSymmetric(undefined));
    });
    it("Returns false with non-symmetric array",()=>{
        assert.isFalse(isSymmetric([1,3]));
    });
    it("Returns true with symmetric array",()=>{
        assert.isTrue(isSymmetric([1,1]))
    });
    it("Returns true with mixed number and number-as-string array",()=>{
        assert.isFalse(isSymmetric([1,'1']));
    })
})