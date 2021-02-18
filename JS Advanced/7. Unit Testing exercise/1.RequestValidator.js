function solution(obj){
    let correctMethods = ['GET','POST','DELETE','CONNECT'];
    let correctUriRegex = /[\da-zA-Z\.]+/;
    let correctVersion = ['HTTP/0.9', 'HTTP/1.0', 'HTTP/1.1', 'HTTP/2.0'];
    let specialCharacters = ['<', '>', '\\', '&', "\'", "\""];

    if(!correctMethods.some(e=>e==obj.method)) throw new Error('Incorrect method');
    if(!correctUriRegex.test(obj.uri)&&obj.uri!='*') throw new Error ('Incorrect uri');
    if(!correctVersion.some(e=>e==obj.version)) throw new Error('Incorrect verison');
    if(!/^\d*$/.test(obj.message)||specialCharacters.some(e=>e==obj.message)) throw new Error('Incorrect message');

    return obj;
}

console.log(solution({
        method: 'OPTIONS',
        uri: 'git.master',
        version: 'HTTP/1.1',
        message: '-recursive'
}));