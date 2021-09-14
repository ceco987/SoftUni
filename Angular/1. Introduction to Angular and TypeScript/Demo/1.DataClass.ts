class Data{
    method: String;
    uri: String;
    version: String;
    message: String;
    private response: String = undefined;
    private fulfilled: boolean = false;

    constructor(method:String,uri:String,version:String,message:String){
        this.method = method;
        this.uri = uri;
        this.version = version;
        this.message = message;
    }
}

let myData = new Data('GET','http://google.com','HTTP/1.1','');
console.log(myData)