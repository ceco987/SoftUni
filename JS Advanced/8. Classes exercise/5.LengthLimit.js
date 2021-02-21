class Stringer {
    constructor(string, length) {
        this.innerString = string;
        this.innerLength = length;
    }

    increase(length){
        this.innerLength+=length;
    }
    
    decrease(length){
        if(length>this.innerLength) this.innerLength = 0;
        else this.innerLength-=length;
    }

    toString(){
        let output = '';
        if(this.innerLength==0) output = '...';
        else if(this.innerLength<this.innerString.length) output=this.innerString.slice(0,this.innerLength)+'...';
        else output = this.innerString;
        
        return output;
    }
}

let test = new Stringer('domati',3);
console.log(test.toString())
test.increase(25);
console.log(test.toString())
test.decrease(122)
console.log(test.toString())