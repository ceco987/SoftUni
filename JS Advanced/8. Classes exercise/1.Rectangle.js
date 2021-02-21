class Rectangle{
    constructor(width,height,color){
        this.width=width;
        this.height=height;
        this.color=color[0].toUpperCase()+color.slice(1).toLowerCase();
    }

    calcArea(){
        return this.width*this.height;
    }
}