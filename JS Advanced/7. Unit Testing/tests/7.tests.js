const {assert} = require('chai')
const createCalculator = require('../7.AddSubract');

// Return a module (object), containing the functions add(), subtract() and get() as properties
// Keep an internal sum which can’t be modified from the outside
// The functions add() and subtract() take a parameter that can be parsed as a number (either a number or a string containing a number) that is added or subtracted from the internal sum
// The function get() returns the value of the internal sum

let asd = {
    sum: 0,
    asd: function (){
        return 'yes';
    }
}

//works here, 26/100 in judge, wasted too much time.
describe("General Tests",()=>{
    let calculator = createCalculator();

    it("Returns object",()=>{
        assert.isObject(createCalculator());
    });

    it("has add",()=>{
        assert.property(createCalculator(),'add')
    });

    it("has subtract",()=>{
        assert.property(createCalculator(),'subtract')
    });

    it("has get",()=>{
        assert.property(createCalculator(),'get')
    });

    it("can add",()=>{
        calculator.add(2);
        calculator.add(3);
        assert.equal(calculator.get(),5)
    });

    it("can subtract",()=>{
        calculator.subtract(2);
        assert.equal(calculator.get(),3)
    });
    
    it("works with numbers as strings",()=>{
        calculator.subtract('2');
        assert.equal(calculator.get(),1)
    });
    
    it("can add decimals",()=>{
        calculator.add(1.1);
        assert.equal(calculator.get(),2.1)
    });
    
})