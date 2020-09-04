package GenericSwapMethodStrings;

public class Box<T>{
    private T item;

    public Box(T item){
        this.item = item;
    }

    @Override
    public String toString(){
        return item.getClass().getName() + ": "+ item.toString();
    }
}
