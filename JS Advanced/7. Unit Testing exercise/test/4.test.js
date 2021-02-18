const { assert } = require('chai');
const { mathEnforcer } = require('../4.MathEnforcer');

describe("addFive tests", () => {
    it("return undefined if par for addFive is a string", () => {
        assert.isUndefined(mathEnforcer.addFive('s'))
    });

    it("return undefined if par for addFive is a number as string", () => {
        assert.isUndefined(mathEnforcer.addFive('5'))
    });
    it("return undefined if par for addFive is an array", () => {
        assert.isUndefined(mathEnforcer.addFive([4]))
    });

    it("expected behaviour of addFive with decimals", () => {
        assert.closeTo(mathEnforcer.addFive(1.22), 6.22, 0.01)
    });
    
    it("expected behaviour of addFive with negative numbers", () => {
        assert.closeTo(mathEnforcer.addFive(-5), 0, 0.01)
    });
});

describe("subtractTen tests",()=>{
    it("return undefined if par for subtractTen is a string", () => {
        assert.isUndefined(mathEnforcer.subtractTen('s'))
    });

    it("return undefined if par for subtractTen is a number as string", () => {
        assert.isUndefined(mathEnforcer.subtractTen('15'))
    });
    it("return undefined if par for subtractTen is an array", () => {
        assert.isUndefined(mathEnforcer.subtractTen([4]))
    });

    it("expected behaviour of subtractTen with decimals", () => {
        assert.closeTo(mathEnforcer.subtractTen(15.22), 5.22, 0.01)
    });
    
    it("expected behaviour of subtractTen with negative numbers", () => {
        assert.closeTo(mathEnforcer.subtractTen(-5), -15, 0.01)
    });
});

describe("sum tests",()=>{
    it("return undefined if par1 for sum is a string", () => {
        assert.isUndefined(mathEnforcer.sum('s',5))
    });
    
    it("return undefined if par2 for sum is a string", () => {
        assert.isUndefined(mathEnforcer.sum(5,'s'))
    });

    it("return undefined if par1 for sum is a number as string", () => {
        assert.isUndefined(mathEnforcer.sum('15',2))
    });
    it("return undefined if par2 for sum is a number as string", () => {
        assert.isUndefined(mathEnforcer.sum(2,'2'))
    });

    it("expected behaviour of sum with decimals", () => {
        assert.closeTo(mathEnforcer.sum(2.22,2.22), 4.44, 0.01)
    });
    
    it("expected behaviour of sum with negative numbers", () => {
        assert.closeTo(mathEnforcer.sum(-2.22,-2.22), -4.44, 0.01)
    });
});