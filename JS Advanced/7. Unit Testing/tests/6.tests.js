const {assert} = require('chai');
const rgbToHexColor = require('../6.RGBToHex');


// Take three integer numbers, representing the red, green and blue values of an RGB color, each within range [0…255]
// Return the same color in hexadecimal format as a string (e.g. '#FF9EAA')
// Return undefined if any of the input parameters are of invalid type or not in the expected range


describe("General Tests",()=>{
    it("Converts black to hex",()=>{
        assert.equal(rgbToHexColor(0,0,0),'#000000')
    });

    it("Converts #FF9EAA to dec",()=>{
        assert.equal(rgbToHexColor(255,158,170),'#FF9EAA')
    });
    
    it("Returns undefined with fewer arguments",()=>{
        assert.isUndefined(rgbToHexColor(1,2));
    });

    it("Returns undefined with strings",()=>{
        assert.isUndefined(rgbToHexColor('a','b'));
    });

    it("Returns undefined when argument1 is decimal",()=>{
        assert.isUndefined(rgbToHexColor(0.8,0,1));
    });

    it("Returns undefined when argument2 is decimal",()=>{
        assert.isUndefined(rgbToHexColor(0,0.5,1));
    });

    it("Returns undefined when argument3 is decimal",()=>{
        assert.isUndefined(rgbToHexColor(0,0,1.2));
    });

    it("Returns undefined when argument1 is out of range (small)",()=>{
        assert.isUndefined(rgbToHexColor(-1,0,1));
    });

    it("Returns undefined when argument2 is out of range (small)",()=>{
        assert.isUndefined(rgbToHexColor(0,-1,1));
    });

    it("Returns undefined when argument3 is out of range (small)",()=>{
        assert.isUndefined(rgbToHexColor(0,0,-1));
    });

    it("Returns undefined when argument1 is out of range (big)",()=>{
        assert.isUndefined(rgbToHexColor(256,0,1));
    });

    it("Returns undefined when argument2 is out of range (big)",()=>{
        assert.isUndefined(rgbToHexColor(0,256,1));
    });

    it("Returns undefined when argument3 is out of range (big)",()=>{
        assert.isUndefined(rgbToHexColor(0,256,1));
    });
})
