function createSortedList(width,height,color){
    const rectangle ={
        width,
        height,
        color: color[0].toUpperCase()+color.slice(1),
         calcArea: function calcArea(){
            return this.width*this.height;
        }
    }
    return rectangle;
}

console.log(createSortedList(4,5,'red'))