function solution(data){
    
    let output = [];

    function add(value){
        output.push(value);
        return output;
    }

    function remove (value){
        return output=output.filter(e=>e!=value);
    }

    function print(){
        console.log(output.join(','));
    }

    let obj ={
        add,
        remove,
        print,
    }
    
        for(let i = 0; i< data.length;i++){
            let [command,value] = data[i].split(' ');
            if(command!='print'){
                obj[command](value);
            } else obj[command]();
        }
}

solution(['add hello', 'add again', 'remove hello', 'add again', 'print'])