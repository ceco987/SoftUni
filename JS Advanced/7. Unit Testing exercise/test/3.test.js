const {assert} = require('chai');
const lookupChar = require('../3.CharLookup');

describe("General Tests",()=>{
    it("return undefined if par1 is number",()=>{
        assert.isUndefined(lookupChar(5,2));
    });

    it("return undefined if par1 is array",()=>{
        assert.isUndefined(lookupChar([123],2));
    });
    
    it("return undefined if par2 is string",()=>{
        assert.isUndefined(lookupChar('asd','asd'));
    });
    
    it("return undefined if par2 is array",()=>{
        assert.isUndefined(lookupChar('asd',[123]));
    });
    
    it("return undefined if par2 is decimal",()=>{
        assert.isUndefined(lookupChar('asd',1.2));
    });
    
    it("return message if index out of bounds (big)",()=>{
        assert.equal(lookupChar('asd',5),'Incorrect index');
    });
    
    it("return message if index out of bounds (small)",()=>{
        assert.equal(lookupChar('asd',-1),'Incorrect index');
    });
    
    it("expected behaviour",()=>{
        assert.equal(lookupChar('asd',1),'s');
    });
    
})