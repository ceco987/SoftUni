class Hex{
    constructor(value){
        this.value = Number(value);
    }

    valueOf(){
        return this.value;
    }

    toString(){
        return '0x'+this.value.toString(16).toUpperCase();
    }

    plus(number){
        return new Hex(this.value+number);
    }

    minus(number){
        return new Hex(this.value-number);
    }

    parse(input){
        return parseInt(input,16);
    }
}

let test = new Hex(255);
console.log(test.toString())
console.log(test.plus(5).toString());