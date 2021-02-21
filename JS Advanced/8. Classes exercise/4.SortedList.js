class List {
    constructor(){
        this.arr = []
        this.size = 0;
    }
    
    add (e){
        this.arr.push(e);
        this.size++;
        this.arr.sort((a,b)=>a-b)
    }
    
    remove(index){
        if(index<0||index>=this.arr.length) throw new RangeError('Index Out of Bounds Exception');
        this.arr.splice(index,1);
        this.size--;
        this.arr.sort((a,b)=>a-b)
    }
    
    get(index){
        if(index<0||index>=this.arr.length) throw new RangeError('Index Out of Bounds Exception');
        return this.arr[index];
    }
}

let list = new List();
list.
list.add(5);
list.add(3);
list.remove(0);
console.log(list.get(0))
console.log(list.size)